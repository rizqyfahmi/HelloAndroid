package com.rizqyfahmi.helloandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdvanceAdapter extends RecyclerView.Adapter<RecyclerAdvanceAdapter.ImageViewHolder> {

    private int[] images;

    public RecyclerAdvanceAdapter(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_advance_layout, viewGroup, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder viewHolder, int i) {
        int id = images[i];
        viewHolder.imageView.setImageResource(id);
        viewHolder.imageViewTitle.setText("Image : "+(i+1));
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView imageViewTitle;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.raImageView);
            imageViewTitle = itemView.findViewById(R.id.raImageViewTitle);
        }
    }
}
