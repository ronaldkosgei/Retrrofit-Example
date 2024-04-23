package com.retrofitclient.mapper;

import com.retrofitclient.dto.UserDto;
import com.retrofitclient.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserId(user.getUserId());
        userDto.setTittle(user.getTittle());
        userDto.setBody(user.getBody());

        return userDto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUserId(userDto.getUserId());
        user.setTittle(userDto.getTittle());
        user.setBody(userDto.getBody());

        return user;
    }
}