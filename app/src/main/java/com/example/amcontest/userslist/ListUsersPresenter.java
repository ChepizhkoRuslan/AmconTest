package com.example.amcontest.userslist;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.example.amcontest.data.Repository;
import com.example.amcontest.data.model.ListUsersResponse;
import com.example.amcontest.data.room.AppDatabase;
import com.example.amcontest.data.room.Users;
import com.example.amcontest.data.room.UsersDao;


import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

public class ListUsersPresenter implements ListUserContract.Presenter{

    private  ListUserContract.View view;
    private Repository repository;
    private AppDatabase db;

    @Inject
    Application context;

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
            public void onNext(List<ListUsersResponse> listUsersResponses) {
                if (view != null) {
                    view.setListUsersToAdapter(listUsersResponses );
                    new SaveDataTask(listUsersResponses).execute();
                }
            }
        });
    }

    class SaveDataTask extends AsyncTask<Void, Void, Void> {
        private List<ListUsersResponse> listUsersResponses;

        SaveDataTask(List<ListUsersResponse> listUsersResponses) {
            this.listUsersResponses = listUsersResponses;
        }
        @Override
        protected Void doInBackground(Void... params) {

            db = repository.provideDatabase();
            UsersDao usersDao = db.userDao();
            Users users = new Users();
            for(ListUsersResponse us : listUsersResponses) {
                users.setName(us.getName());
                users.setLat(us.getAddress().getGeo().getLat());
                users.setLng(us.getAddress().getGeo().getLng());
                users.setContentUsers(us.toString());
                usersDao.insert(users);
            }
            return null;
        }
    }
}


