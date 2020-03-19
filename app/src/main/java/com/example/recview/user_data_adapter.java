package com.example.recview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class user_data_adapter extends RecyclerView.Adapter<user_data_adapter.ViewHolder> {

    ArrayList<user_data> udata;
    Context context;

    public user_data_adapter(ArrayList<user_data> data, Context context) {
        udata = data;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_data_blueprint,parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        user_data dts = udata.get(position);
        holder.usernameTV.setText(dts.username);
        holder.emailTV.setText(dts.email);
        holder.passwordTV.setText(dts.password);
    }

    @Override
    public int getItemCount() {
        return udata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView usernameTV, emailTV, passwordTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTV = (TextView)itemView.findViewById(R.id.user_nameTV);
            emailTV = (TextView)itemView.findViewById(R.id.user_emailTV);
            passwordTV = (TextView)itemView.findViewById(R.id.user_passTV);
        }
    }
}
