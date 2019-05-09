package com.example.amcontest.userslist;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.amcontest.R;
import com.example.amcontest.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ListUsersActivity extends BaseActivity {

    @Inject
    ListUsersFragment listUsersFragment;

    @Inject
    public ListUsersActivity(){
    }

    public static Intent newInstance(Context context) {
        return new Intent(context, ListUsersActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        ButterKnife.bind(this);
        showFragmentOrRestore(R.id.fragment_container, new ListUsersFragment(), getString(R.string.list_users));
    }
}
