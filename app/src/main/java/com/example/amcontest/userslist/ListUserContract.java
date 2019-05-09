package com.example.amcontest.userslist;

import com.example.amcontest.base.baseMVP.BasePresenter;
import com.example.amcontest.base.baseMVP.BaseView;
import com.example.amcontest.data.model.ListUsersResponse;

import java.util.List;

public interface ListUserContract {

    interface View extends BaseView {
        void setListUsersToAdapter(List<ListUsersResponse> listUsers);

    }

    interface Presenter extends BasePresenter<View> {

        void loadListUsers();

    }
}
