package com.example.amcontest.data.model;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ListUsersResponse {

    @SerializedName("website")
    private String website;

    @SerializedName("address")
    private Address address;

    @SerializedName("phone")
    private String phone;

    @SerializedName("name")
    private String name;

    @SerializedName("company")
    private Company company;

    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return
               "id = " + id + '\n' +
               "name = " + name + '\n' +
               "username = " + username + '\n' +
               "email = " + email + '\n' +
               "phone = " + phone + '\n' +
               "website = " + website + '\n' +
               address + '\n' +
               company ;
    }
}