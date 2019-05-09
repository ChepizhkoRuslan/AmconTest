package com.example.amcontest.data;


import androidx.annotation.NonNull;


import com.example.amcontest.data.model.ListUsersResponse;

import java.util.List;

import rx.Observable;

public interface Source {

    @NonNull
    Observable<List<ListUsersResponse>> getListUsers();

}
