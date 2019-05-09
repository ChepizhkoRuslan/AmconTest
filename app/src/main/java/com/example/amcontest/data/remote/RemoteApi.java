package com.example.amcontest.data.remote;


import com.example.amcontest.data.model.ListUsersResponse;

import java.util.List;

import retrofit2.http.GET;

import retrofit2.http.Headers;

import rx.Observable;

public interface RemoteApi {

    @Headers({"Accept:application/json", "Content-Type:application/json"})
    @GET("users")
    Observable<List<ListUsersResponse>> getListUsers();

}

