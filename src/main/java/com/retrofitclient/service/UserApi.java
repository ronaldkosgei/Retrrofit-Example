package com.retrofitclient.service;

import com.retrofitclient.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {


    @GET("users")
    public Call<Flux<User>> fetchAllUsers();


    @GET("user")
    public Call<Mono<User>> fetchUserById(Long id);


    @POST("save")
    public Call<Mono<User>> saveUser(User user);

    @GET("user")
    public Call<Mono<User>> fetchUserByUserId(Long userId);
}
