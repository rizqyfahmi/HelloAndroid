package com.rizqyfahmi.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class RecyclerAdvanceDisplayActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_advance_display);

        imageView = findViewById(R.id.raImageViewDetail);
        imageView.setImageResource(getIntent().getIntExtra("id", 00));
    }
}
