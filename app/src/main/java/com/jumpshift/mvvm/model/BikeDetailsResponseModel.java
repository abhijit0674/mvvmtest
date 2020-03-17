package com.jumpshift.mvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BikeDetailsResponseModel {
    @SerializedName("networks")
    @Expose
    private List<NetworkModel> networks = null;

    public List<NetworkModel> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworkModel> networks) {
        this.networks = networks;
    }
}
