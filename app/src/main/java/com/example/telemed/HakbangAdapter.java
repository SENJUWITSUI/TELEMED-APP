package com.example.telemed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HakbangAdapter extends RecyclerView.Adapter<HakbangAdapter.HakbangViewHolder> {

    private List<Hakbang> mListHakbang;

    public void setData(List<Hakbang> list){
        this.mListHakbang = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HakbangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hakbang,parent,false);
        return new HakbangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HakbangViewHolder holder, int position) {
        Hakbang hakbang = mListHakbang.get(position);
        if (hakbang==null){
            return;
        }
        holder.tvNumber.setText(hakbang.getResourceId());
        holder.tvStep.setText(hakbang.getTitle());
        holder.tvDescription.setText(hakbang.getDescription());
    }

    @Override
    public int getItemCount() {
       if (mListHakbang != null){
         return mListHakbang.size();
       }
    return 0;
    }

    public class HakbangViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNumber, tvStep, tvDescription;

        public HakbangViewHolder(@NonNull View itemView){
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tv_number);
            tvStep = itemView.findViewById(R.id.tv_step);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
