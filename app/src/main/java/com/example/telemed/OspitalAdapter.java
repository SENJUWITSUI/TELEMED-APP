package com.example.telemed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OspitalAdapter extends RecyclerView.Adapter<OspitalAdapter.OspitalViewHolder> {

    private List<Ospital> mListOspital;

    public void setData(List<Ospital> list){
        this.mListOspital = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OspitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ospital,parent,false);
        return new OspitalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OspitalViewHolder holder, int position) {
        Ospital ospital = mListOspital.get(position);
        if (ospital==null){
            return;
        }
        holder.imgOspital.setImageResource(ospital.getResourceId());
        holder.tvOsname.setText(ospital.getTitle());
        holder.tvCpnum.setText(ospital.getNumber());
    }

    @Override
    public int getItemCount() {
       if (mListOspital != null){
         return mListOspital.size();
       }
    return 0;
    }

    public class OspitalViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgOspital;
        private TextView tvOsname, tvCpnum;

        public OspitalViewHolder(@NonNull View itemView){
            super(itemView);
            imgOspital = itemView.findViewById(R.id.img_ospital);
            tvOsname = itemView.findViewById(R.id.tv_osname);
            tvCpnum = itemView.findViewById(R.id.tv_cpnum);
        }
    }
}
