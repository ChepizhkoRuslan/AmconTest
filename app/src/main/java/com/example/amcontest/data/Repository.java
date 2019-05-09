package com.example.amcontest.data;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;


import androidx.annotation.NonNull;

import com.example.amcontest.data.annotations.Remote;
import com.example.amcontest.data.model.ListUsersResponse;

import java.net.ConnectException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;


@Singleton
public class Repository implements Source {

    private final Source mSource;

    @Inject
    Application context;

    @Inject
    Repository(@Remote Source source) {
        this.mSource = source;
    }

    private boolean isInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null;
    }

    @NonNull
    @Override
    public Observable<List<ListUsersResponse>> getListUsers() {
        if (isInternetConnection())
            return mSource.getListUsers();
        else
            return Observable.error(new ConnectException("No internet connection"));
    }
}
