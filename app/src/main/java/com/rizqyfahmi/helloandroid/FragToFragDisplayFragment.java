package com.rizqyfahmi.helloandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragToFragDisplayFragment extends Fragment {

    private TextView textView;

    public FragToFragDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_to_frag_display, container, false);
        textView = view.findViewById(R.id.frag_to_frag_message_display);

        Bundle bundle = getArguments();
        String message = bundle.getString("message");

        textView.setText(message);
        return view;
    }

}
