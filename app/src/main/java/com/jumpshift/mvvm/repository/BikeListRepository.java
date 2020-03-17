package com.jumpshift.mvvm.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.jumpshift.mvvm.model.BikeDetailsResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BikeListRepository {

    private static final String TAG = "BikeListRepository";
    private static BikeListRepository mInstance;

    private BikeListRepository() {
    }

    public static BikeListRepository getmInstance() {
        if (mInstance == null) {
            mInstance = new BikeListRepository();
        }
        return mInstance;
    }

    public MutableLiveData<BikeDetailsResponseModel> getBikeListDetail() {
        final MutableLiveData<BikeDetailsResponseModel> data = new MutableLiveData<>();
        RetrofitInstance.getClient().create(APIInterface.class).getBikeList().enqueue(new Callback<BikeDetailsResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<BikeDetailsResponseModel> call, @NonNull Response<BikeDetailsResponseModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<BikeDetailsResponseModel> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                data.setValue(null);
            }
        });
        return data;
    }
}
