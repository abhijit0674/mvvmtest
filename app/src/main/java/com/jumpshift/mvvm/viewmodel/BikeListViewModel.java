package com.jumpshift.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jumpshift.mvvm.model.BikeDetailsResponseModel;
import com.jumpshift.mvvm.repository.BikeListRepository;

public class BikeListViewModel extends ViewModel {

    private MutableLiveData<BikeDetailsResponseModel> bannerResponse;

    public void setBikeListResponse() {
        if (this.bannerResponse == null) {
            this.bannerResponse = new MutableLiveData<>();
        }
        this.bannerResponse = BikeListRepository.getmInstance().getBikeListDetail();
    }

    public LiveData<BikeDetailsResponseModel> getBikeListResponse() {
        return bannerResponse;
    }
}
