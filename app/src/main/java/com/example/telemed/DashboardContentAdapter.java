package com.example.telemed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DashboardContentAdapter extends RecyclerView.Adapter<DashboardContentAdapter.CategoryViewHolder> {

    private List<DashboardContent> mListDashboardContent;

    public void setData(List<DashboardContent> list){
        this.mListDashboardContent = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        DashboardContent dashboardContent = mListDashboardContent.get(position);
        if (dashboardContent==null){
            return;
        }
        holder.img.setImageResource(dashboardContent.getResourceId());
        holder.title.setText(dashboardContent.getTitle());
        holder.count.setText(dashboardContent.getCount());
    }

    @Override
    public int getItemCount() {
        if (mListDashboardContent!= null){
            return mListDashboardContent.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView title, count;

        public CategoryViewHolder(@NonNull View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            count = itemView.findViewById(R.id.count);
        }
    }
}
