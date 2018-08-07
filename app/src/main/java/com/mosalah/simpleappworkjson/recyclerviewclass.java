package com.mosalah.simpleappworkjson;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class recyclerviewclass extends RecyclerView.Adapter<recyclerviewclass.adapter> {

    private ArrayList<model> list;

    public recyclerviewclass(ArrayList<model> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_article, parent, false);
        return new adapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter holder, int position) {
        model m = list.get(position);
        if (m.getImage_url().equals("null")) {
            holder.image.setImageResource(R.drawable.download);

        } else {
            Picasso.get().load(m.getImage_url()).into(holder.image);
        }
        holder.time.setText(m.getTime());
        if (!m.getDescription().equals("null")) {
            holder.description.setText(m.getDescription());

        } else {
            holder.description.setText("read more");

        }
        holder.title.setText(m.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class adapter extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, description, time;

        adapter(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_article);
            time = itemView.findViewById(R.id.txt_date);
            title = itemView.findViewById(R.id.txt_title);
            description = itemView.findViewById(R.id.txt_description);
        }
    }
}
