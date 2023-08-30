package com.kosa.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id,
                                           @RequestBody Post post){

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){ //isPresent를 사용하여 존재 여부를 파악.
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        post.setUser(user.get());

        //DB로 만들어진 데이터까지 ID값까지 들어간다.
        //savePost에는 DB의 post 테이블에 저장된(ID Generated 된) 모든 값이 저장되고(postRepository.save(post)),
        //post에는 요청시 description 부분만 저장한 Entity(@RequestBody)를 사용
        Post savePost = postRepository.save(post);

        //Location에 우리가 요청한 URI값이 들어간다.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savePost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostByUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){ //isPresent를 사용하여 존재 여부를 파악.
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return user.get().getPosts();
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    public EntityModel<Optional<User>> retrieveOneUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        //Data값을 가져오는데 User 객체로 가져오는 것이 아닌 Optional<User>로 가져온다
        //Optional형태로 가져와서 Null값이 넘어올 경우를 방지한다.

        if(!user.isPresent()){ //isPresent를 사용하여 존재 여부를 파악.
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        //hateoas 적용
        // user객체, methodOn에 UserController에 있는 retrieveAllUsers를 실행시켜 AllUser를 받아오고 이름을 all-users라고 지정.
        return EntityModel.of(user, linkTo(methodOn(UserJpaController.class).retrieveAllUsers()).withRel("all-users"));
    }
        @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);

        //입력한 정보를 확인하기 위한 URI생성
        //방금 입력한 정보를 확인하고 싶다면 다음의 URI를 사용하라.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }
}
