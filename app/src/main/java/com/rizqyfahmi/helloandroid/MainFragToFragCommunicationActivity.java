package com.rizqyfahmi.helloandroid;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainFragToFragCommunicationActivity extends AppCompatActivity implements FragToFragMessageFragment.OnMessageSendListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frag_to_frag_communication);

        if (findViewById(R.id.frag_to_frag_fragment_container) != null){

            if (savedInstanceState != null){
                return;
            }

            // Fragment Target
            FragToFragMessageFragment fragToFragMessageFragment = new FragToFragMessageFragment();
            // Connecting Fragment Target into Container (Which is Frame Layout in MainFragToFragCommunicationActivity)
            getSupportFragmentManager().beginTransaction().add(R.id.frag_to_frag_fragment_container, fragToFragMessageFragment, null).commit();
        }
    }

    @Override
    public void onMessageSend(String message) {
        FragToFragDisplayFragment fragToFragDisplayFragment = new FragToFragDisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        fragToFragDisplayFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.frag_to_frag_fragment_container, fragToFragDisplayFragment, null);
        fragmentTransaction.addToBackStack(null).commit();
    }
}
