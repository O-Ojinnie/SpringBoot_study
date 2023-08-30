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
}
