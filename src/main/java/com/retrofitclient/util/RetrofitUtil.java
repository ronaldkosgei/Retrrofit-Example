package com.retrofitclient.util;

import com.retrofitclient.constant.RetrofitConstant;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import retrofit2.Retrofit;

public class RetrofitUtil {

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(RetrofitConstant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
        return retrofit;
    }
}
