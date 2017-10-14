package com.retrofittest;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/9/27.
 */

public interface MyServe {
    @GET("list.from?key=abc2492254ea7d03c264c8e6a96c50e5&page=1&pagesize=10&sort=asc&time=1418745237")
    Call<JokeModel> getJoke();
    @GET("index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=b2288a26c388a5d3a5dee5c1472fccce")
    Call<WeatherModel> getWeather();
    @GET("query?key=2dfb77dbd0a9146a09a00693447ba3b7&menu=%E8%A5%BF%E7%BA%A2%E6%9F%BF&rn=10")
    Call<CookModel> getCook(@Query("pn") int pn);
}
