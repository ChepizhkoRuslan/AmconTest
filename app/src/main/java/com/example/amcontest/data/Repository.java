package com.example.amcontest.data;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.NonNull;
import androidx.room.Room;

import com.example.amcontest.data.annotations.Remote;
import com.example.amcontest.data.model.ListUsersResponse;
import com.example.amcontest.data.room.AppDatabase;

import java.net.ConnectException;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Provides;
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

    public AppDatabase provideDatabase() {
        return Room.databaseBuilder(context, AppDatabase.class, "database").build();
    }

}
