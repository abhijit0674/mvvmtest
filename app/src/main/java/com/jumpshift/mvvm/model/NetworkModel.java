package com.jumpshift.mvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NetworkModel {

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("location")
    @Expose
    private LocationModel location;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("license")
    @Expose
    private LicenseModel license;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LicenseModel getLicense() {
        return license;
    }

    public void setLicense(LicenseModel license) {
        this.license = license;
    }
}
