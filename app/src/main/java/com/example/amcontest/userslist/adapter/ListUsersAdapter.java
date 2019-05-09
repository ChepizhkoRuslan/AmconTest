package com.example.amcontest.userslist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.amcontest.R;
import com.example.amcontest.data.model.ListUsersResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ListUsersAdapter extends RecyclerView.Adapter<ListUsersAdapter.ViewHolder>{
    private Context context;
    private List<ListUsersResponse> list;
    private UsersCallBack callBack;


    @Inject
    public ListUsersAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListUsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_users, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUsersAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bindView(list, position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setList(List<ListUsersResponse> list) {
        this.list = list;
        notifyDataSetChanged();

    }

    public void setUsersCallBack(UsersCallBack callBack) {
        this.callBack = callBack;
    }

    public interface UsersCallBack {
        void onClickItem(int commentId);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_name)
        TextView tvName;
        @BindView(R.id.text_email)
        TextView tvEmail;
        private View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void bindView(List<ListUsersResponse> list, int position) {



//            if (list.get(position).getUser().getFullName() != null) {
//                String nameUser = list.get(position).getUser().getFullName();
//                tvName.setText(nameUser);
//            }
//
//            if (list.get(position).getComment() != null) {
//                String comments = list.get(position).getComment();
//                tvEmail.setText(comments);
//            }

            itemView.setOnClickListener(v -> {
                    callBack.onClickItem(0);

            });
        }
    }
}

