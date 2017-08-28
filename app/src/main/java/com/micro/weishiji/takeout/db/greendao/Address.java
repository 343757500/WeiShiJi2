package com.micro.weishiji.takeout.db.greendao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.


import java.io.Serializable;

/**
 * Entity mapped to table "ADDRESS".
 */
public class Address implements Serializable {

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", addressName='" + addressName + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    private Long id;
    private String name;
    private Integer sex;
    private String phone;
    private String addressName;
    private String addressDetail;
    private Double latitude;
    private Double longitude;

    public Address(String name, Integer sex, String phone, String addressName, String
            addressDetail, Double latitude, Double longitude) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.addressName = addressName;
        this.addressDetail = addressDetail;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Address(Long id, String name, Integer sex, String phone, String addressName, String
            addressDetail, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.addressName = addressName;
        this.addressDetail = addressDetail;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Address() {
    }

    public Address(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
