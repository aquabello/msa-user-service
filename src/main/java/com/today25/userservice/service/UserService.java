package com.today25.userservice.service;

import com.today25.userservice.repository.UserEntity;
import com.today25.userservice.vo.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
