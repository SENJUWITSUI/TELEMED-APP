package com.example.telemed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CategoryViewHolder> {

    private List<User> mListUser;

    public void setData(List<User> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_serbisyo,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user==null){
            return;
        }
        holder.imgUser.setImageResource(user.getResourceId());
        holder.tvName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
       if (mListUser != null){
         return mListUser.size();
       }
    return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgUser;
        private TextView tvName;

        public CategoryViewHolder(@NonNull View itemView){
            super(itemView);
            imgUser = itemView.findViewById(R.id.img_user);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
