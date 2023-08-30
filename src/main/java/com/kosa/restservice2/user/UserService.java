package com.kosa.restservice2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public List<User> findAll(){
        return mapper.findAllUser();
    }

    public User findOne(int id){return mapper.findUser(id);}

    public User save(User user){
        mapper.createUser(user);
        return user;
    }
}
