package com.example.recview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class data_adapter extends RecyclerView.Adapter<data_adapter.ViewHolder> {

    ArrayList<data> mdata;
    Context context;

    public data_adapter(ArrayList<data> data, Context context) {
        mdata = data;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView  nameTV, genderTV, dobTV, fnameTV, foccTV, board10TV, roll10TV,
                per10TV, board12TV, roll12TV, per12TV, mobTV, emailTV, addTV, progTV, timeTV;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            nameTV = (TextView)itemView.findViewById(R.id.nameTV);
            genderTV = (TextView)itemView.findViewById(R.id.genderTV);
            dobTV = (TextView)itemView.findViewById(R.id.dobTV);
            fnameTV = (TextView)itemView.findViewById(R.id.fnameTV);
            foccTV = (TextView)itemView.findViewById(R.id.foccTV);
            board10TV = (TextView)itemView.findViewById(R.id.board10TV);
            roll10TV = (TextView)itemView.findViewById(R.id.roll10TV);
            per10TV = (TextView)itemView.findViewById(R.id.per10TV);
            board12TV = (TextView)itemView.findViewById(R.id.board12TV);
            roll12TV = (TextView)itemView.findViewById(R.id.roll12TV);
            per12TV = (TextView)itemView.findViewById(R.id.per12TV);
            mobTV = (TextView)itemView.findViewById(R.id.mobTV);
            emailTV = (TextView)itemView.findViewById(R.id.emailTV);
            addTV = (TextView)itemView.findViewById(R.id.addTV);
            progTV = (TextView)itemView.findViewById(R.id.progTV);
            timeTV = (TextView)itemView.findViewById(R.id.timeTV);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_blueprint,parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        data dts = mdata.get(position);
        holder.nameTV.setText(dts.name);
        holder.genderTV.setText(dts.gender);
        holder.dobTV.setText(dts.dob);
        holder.fnameTV.setText(dts.fname);
        holder.foccTV.setText(dts.focc);
        holder.board10TV.setText(dts.board10);
        holder.roll10TV.setText(dts.roll10);
        holder.per10TV.setText(dts.per10);
        holder.board12TV.setText(dts.board12);
        holder.roll12TV.setText(dts.roll12);
        holder.per12TV.setText(dts.per12);
        holder.mobTV.setText(dts.mob);
        holder.emailTV.setText(dts.email);
        holder.addTV.setText(dts.address);
        holder.progTV.setText(dts.programme);
        holder.timeTV.setText(dts.time);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
}
