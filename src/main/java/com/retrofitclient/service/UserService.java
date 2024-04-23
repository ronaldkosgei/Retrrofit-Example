package com.retrofitclient.service;

import com.retrofitclient.dto.UserDto;
import com.retrofitclient.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

        Mono<User> saveUser(UserDto userDto);

        Mono<UserDto> getUserById(Long id);

        Mono<UserDto> getUserByUserId(Long userId);


        Flux<UserDto> getAllUsers();
    }
}
