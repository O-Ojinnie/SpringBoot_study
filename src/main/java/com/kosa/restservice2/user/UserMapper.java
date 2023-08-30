package com.kosa.restservice2.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    public List<User> findAllUser();
    public User findUser(int id);
    public void createUser(User user);
}
