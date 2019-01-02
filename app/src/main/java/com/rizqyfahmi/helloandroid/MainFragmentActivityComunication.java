package com.rizqyfahmi.helloandroid;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainFragmentActivityComunication extends AppCompatActivity implements MessageFragment.onMessageReadListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment_comunication);

        if (findViewById(R.id.fragment_comunication_container) != null){

            if (savedInstanceState != null){
                return;
            }

            MessageFragment messageFragment = new MessageFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.fragment_comunication_container, messageFragment, null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onMessageRead(String message) {
        textView = findViewById(R.id.text_display_message_fragment_comunication);
        textView.setText(message);
    }
}
