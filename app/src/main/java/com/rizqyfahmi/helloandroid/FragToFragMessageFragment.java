package com.rizqyfahmi.helloandroid;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragToFragMessageFragment extends Fragment {

    private Button button;
    private EditText editText;
    OnMessageSendListener messageSendListener;

    public interface OnMessageSendListener{
        public void onMessageSend(String message);
    }

    public FragToFragMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_to_frag_message, container, false);
        editText = view.findViewById(R.id.frag_to_frag_text_message);
        button = view.findViewById(R.id.frag_to_frag_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                messageSendListener.onMessageSend(message);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            messageSendListener = (OnMessageSendListener) activity;

        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must implement OnMessageSendListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        editText.setText("");
    }
}
