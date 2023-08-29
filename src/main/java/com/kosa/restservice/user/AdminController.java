package com.kosa.restservice.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
//    private UserService service;
//
//    public AdminController(UserService service){
//        this.service = service;
//    }
//
//    @GetMapping("/users")
//    public MappingJacksonValue retrieveAllUsers(){
//        List<User> users = service.findAll();
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
//                .filterOutAllExcept("id", "name", "joinDate", "password");
//        //보여주고자 하는 대상만 필터링 대상에서 제외
//
//        FilterProvider filterProvider =
//                new SimpleFilterProvider().addFilter("UserInfo", filter);
//        //proxy에 filter명을 UserInfo로 정한 filter를 Provider에 추가
//        MappingJacksonValue mapping = new MappingJacksonValue(users);
//        mapping.setFilters(filterProvider);
//        //user 객체중에 filterProvider에 필터링 되고 남은 JsonData를 보여주겠다.
//
//        return mapping;
//    }
//
//    @GetMapping("/users/{id}")
//    public MappingJacksonValue retrieveOneUser(@PathVariable int id){
//        User user = service.findOne(id);
//
//        if(user == null){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
//                .filterOutAllExcept("id", "name", "joinDate", "ssn");
//        //보여주고자 하는 대상만 필터링 대상에서 제외
//
//        FilterProvider filterProvider =
//                new SimpleFilterProvider().addFilter("UserInfo", filter);
//        //proxy에 filter명을 UserInfo로 정한 filter를 Provider에 추가
//        MappingJacksonValue mapping = new MappingJacksonValue(user);
//        mapping.setFilters(filterProvider);
//        //user 객체중에 filterProvider에 필터링 되고 남은 JsonData를 보여주겠다.
//
//        return mapping;
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity createUser(@Valid @RequestBody User user){
//        User savedUser = service.save(user);
//
//        //입력한 정보를 확인하기 위한 URI생성
//        //방금 입력한 정보를 확인하고 싶다면 다음의 URI를 사용하라.
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id){
//        User user = service.deleteById(id);
//
//        if(user == null){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//    }
}
