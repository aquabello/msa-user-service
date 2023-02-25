package com.today25.userservice.controller;

import com.today25.userservice.service.UserService;
import com.today25.userservice.vo.Greeting;
import com.today25.userservice.vo.RequestUser;
import com.today25.userservice.vo.ResponseUser;
import com.today25.userservice.vo.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    private Environment env;
    private UserService userService;

    // Value로 가져오는 방법
    private Greeting greeting;

    @Autowired
    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @GetMapping("/heath_check")
    public String status() {
        return "It's Working in in UserController PORT: ";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return env.getProperty("greeting.message");
//        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser requestUser) {

        // TODO: 회원 중복체크

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(requestUser, UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = modelMapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);


    }
}
