package com.example.amcontest.userslist;

import androidx.annotation.NonNull;

import com.example.amcontest.data.Repository;
import com.example.amcontest.data.model.ListUsersResponse;


import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

public class ListUsersPresenter implements ListUserContract.Presenter{

    private  ListUserContract.View view;
    private Repository repository;

    @Inject
    ListUsersPresenter(Repository repository) {
        this.repository = repository;
    }


    @Override
    public void takeView(@NonNull ListUserContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        this.view = null;
    }

    @Override
    public void loadListUsers() {
        repository.getListUsers().subscribe(new Subscriber<List<ListUsersResponse>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                System.out.print(e);
            }

            @Override
            public void onNext(List<ListUsersResponse> reviewsUserResponse) {
                System.out.print(reviewsUserResponse);
//                List<Content> listReview = new ArrayList<>();
//                int size = reviewsUserResponse.getContent().size();
//
//                for (int i = 0; i < size; i++) {
//                    listReview.add(reviewsUserResponse.getContent().get(i));
//                }
//
//                if (view != null) {
//                    view.setListUsersToAdapter(listReview );
//                }
            }
        });
    }

}
