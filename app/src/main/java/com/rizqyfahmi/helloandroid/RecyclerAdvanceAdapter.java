package com.rizqyfahmi.helloandroid;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdvanceAdapter extends RecyclerView.Adapter<RecyclerAdvanceAdapter.ImageViewHolder> {

    private int[] images;
    private Context context;

    public RecyclerAdvanceAdapter(int[] images, Context context) {
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_advance_layout, viewGroup, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view, context, images);
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

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView imageViewTitle;
        Context context;
        int[] images;

        public ImageViewHolder(@NonNull View itemView, Context context, int[] images) {
            super(itemView);

            imageView = itemView.findViewById(R.id.raImageView);
            imageViewTitle = itemView.findViewById(R.id.raImageViewTitle);

            itemView.setOnClickListener(this);

            this.context = context;
            this.images = images;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, RecyclerAdvanceDisplayActivity.class);
            intent.putExtra("id", images[getAdapterPosition()]);

            context.startActivity(intent);
        }
    }
}
