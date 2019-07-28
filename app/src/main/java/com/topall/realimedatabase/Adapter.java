package com.topall.realimedatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<Users>usersList;

    public Adapter(Context context, List<Users> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View v=layoutInflater.inflate(R.layout.raw_layout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Users users=usersList.get(i);
        viewHolder.nameText.setText(users.getName());
        viewHolder.ageText.setText(users.getAge());

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameText,ageText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText=itemView.findViewById(R.id.nameText);
            ageText=itemView.findViewById(R.id.ageText);

        }
    }
}
