package com.learning.dbdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StoreInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer storeId;


    private String storeName;
    private String storeDetails;
    private String storePhoneNumber;

    public StoreInformation(){}

    public StoreInformation(String storeName, String storeDetails, String storePhoneNumber) {
        this.storeName = storeName;
        this.storeDetails = storeDetails;
        this.storePhoneNumber = storePhoneNumber;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(String storeDetails) {
        this.storeDetails = storeDetails;
    }

    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }


}
