package com.example.amcontest.data.remote;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.amcontest.data.Source;
import com.example.amcontest.data.model.ListUsersResponse;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


@Singleton
public class RemoteSource implements Source {

    private final RemoteApi mApi;

    @Inject
    Application context;

    @Inject
    RemoteSource(RemoteApi api) {
        this.mApi = api;
    }

    @NonNull
    @Override
    public Observable<List<ListUsersResponse>> getListUsers() {
        return mApi.getListUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
