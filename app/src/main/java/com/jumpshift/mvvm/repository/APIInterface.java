package com.jumpshift.mvvm.repository;

import com.jumpshift.mvvm.model.BikeDetailsResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("networks")
    Call<BikeDetailsResponseModel> getBikeList();
}
