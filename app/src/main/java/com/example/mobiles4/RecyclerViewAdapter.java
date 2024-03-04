package com.example.mobiles4;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<Item> items;
    public RecyclerViewAdapter(Context context, List<Item> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_adapter, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder
                             holder, int position) {
        Item item = items.get(position);
        holder.textView.setText(item.getText());
        holder.imageView.setImageResource(item.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),"Item clicked: " +
                                holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Item clicked: " + holder.getAdapterPosition());
            }
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
        }
    }
}