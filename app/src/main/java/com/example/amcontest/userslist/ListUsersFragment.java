package com.example.amcontest.userslist;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.amcontest.R;
import com.example.amcontest.base.BaseFragment;
import com.example.amcontest.data.model.ListUsersResponse;
import com.example.amcontest.userslist.adapter.ListUsersAdapter;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;



public class ListUsersFragment extends BaseFragment implements ListUserContract.View{

    @Inject
    ListUsersPresenter presenter;
    @Inject
    ListUsersAdapter listUsersAdapter;
    @BindView(R.id.rv_list)
    RecyclerView rvListUsers;

    private ProgressDialog mProgressDialog;

    @Inject
    public ListUsersFragment(){
    }


    @Nullable
    @Override
    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.simple_rv_list, null, false);
        ButterKnife.bind(this, view);

        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        mProgressDialog.show();

        initReviewsAdapter();
        return view;
    }

    private void initReviewsAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        listUsersAdapter = new ListUsersAdapter(getContext());
        rvListUsers.addItemDecoration(new DividerItemDecoration(rvListUsers.getContext(), manager.getOrientation()));
        rvListUsers.setLayoutManager(manager);
        rvListUsers.setAdapter(listUsersAdapter);

        presenter.loadListUsers();

    }

    @Override
    public void onResume() {
        presenter.takeView(this);
        super.onResume();
    }

    @Override
    public void onDestroy() {
        presenter.dropView();
        super.onDestroy();
        mProgressDialog.dismiss();
    }

    @Override
    public void setListUsersToAdapter(List<ListUsersResponse> listUsers) {
        if(listUsers == null)return;

        listUsersAdapter.setList(listUsers);
        mProgressDialog.dismiss();
    }

}
