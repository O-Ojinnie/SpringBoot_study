package com.test.bestrestaurant.mrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class RestaurantJpaController {


    @Autowired
    private RestaurantRepository resRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurant(){
        return resRepository.findAll();
    }

    @GetMapping("/restaurant/{restaurntId}")
    public Optional<Restaurant> getOneRestaurant(@PathVariable int restaurntId){
        return resRepository.findById(restaurntId);
    }

    @PostMapping("/restaurant")
    public void createRestaurant(@RequestBody Restaurant restaurant){
        List<Menu> menus = restaurant.getMenus();
        restaurant.setCreated_at(new Date());
        restaurant.setUpdated_at(new Date());
        restaurant.setMenus(menus);
        Restaurant savedRestaurant = resRepository.save(restaurant);

        for (Menu m : menus) {
            m.setRestaurantId(savedRestaurant.getId());
            m.setCreated_at(new Date());
            m.setUpdated_at(new Date());
            menuRepository.save(m);
        }
        System.out.println("ID : " + savedRestaurant.getId());
        System.out.println("Menus : "+ menus);
    }

    @PutMapping("/restaurant/{restaurntId}")
    public void updateRestaurant(
            @PathVariable int restaurntId,
            @RequestBody Restaurant restaurant){
        restaurant.setId(restaurntId);
        resRepository.save(restaurant);
    }

    @DeleteMapping("/restaurant/{restaurntId}")
    public void deleteRestaurant(@PathVariable int restaurntId){
        resRepository.deleteById(restaurntId);
    }

//    Review Start
    @GetMapping("/restaurant/{restaurntId}/reviews")
    public Map<String, Object> allReviewByRestaurant (@PathVariable int restaurntId) {
       Integer selectID = resRepository.findById(restaurntId).get().getId();
       List<Review> star = reviewRepository.findByRestaurantId(restaurntId);

        double sum = star.stream()
                .mapToDouble(Review::getScore)
                .sum();

        double avgScore = sum / star.size();

        Map<String, Object> response = new HashMap<>();
        response.put("avgScore", avgScore);
        response.put("reviews", star);

        return response;
    }

    @PostMapping("/review")
    public void createReview(@RequestBody Review review){
        reviewRepository.save(review);
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable int reviewId){
        reviewRepository.deleteById(reviewId);
    }

}
