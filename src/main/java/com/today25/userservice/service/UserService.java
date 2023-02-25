package com.today25.userservice.service;

import com.today25.userservice.repository.UserEntity;
import com.today25.userservice.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * UserDetailsService
 * 로그인을 하기위한 클래스
 */
public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();

    UserDto getUserDetailByEmail(String userEmail);
}
