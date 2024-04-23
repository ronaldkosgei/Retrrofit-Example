package com.retrofitclient.service.impl;

import com.retrofitclient.dto.UserDto;
import com.retrofitclient.entity.User;
import com.retrofitclient.mapper.UserMapper;
import com.retrofitclient.repository.UserRepository;
import com.retrofitclient.service.UserApi;
import com.retrofitclient.service.UserService;
import com.retrofitclient.util.RetrofitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import retrofit2.Retrofit;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private Retrofit retrofit;
    private UserApi userApi;

    public UserServiceImpl() {

        retrofit = RetrofitUtil.getRetrofitInstance();
        userApi = retrofit.create(UserApi.class);

    }

    @Override
    public Mono<User> saveUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        Mono<User> savedUser = userRepository.save(user);
        return savedUser.map(userEntity -> UserMapper.mapToUser(userDto));
    }

    @Override
    public Mono<UserDto> getUserById(Long id) {
        Mono<User> userMono = userRepository.findById(id);
        return userMono.map(user -> UserMapper.mapToUserDto(user));
    }

    @Override
    public Mono<UserDto> getUserByUserId(Long userId) {
        Mono<User> userMono = userRepository.findById(userId);
        return userMono.map(user -> UserMapper.mapToUserDto(user));
    }

    @Override
    public Flux<UserDto> getAllUsers() {
        Flux<User> userFlux = userRepository.findAll();
        return userFlux.map(user -> UserMapper.mapToUserDto(user));
    }
}
