package com.rizqyfahmi.helloandroid;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SQLiteHomeFragment extends Fragment implements View.OnClickListener{

    private Button buttonSave, buttonView, buttonDelete, buttonUpdate;
    OnDbOpListener onDbOpListener;


    public SQLiteHomeFragment() {
        // Required empty public constructor
    }

    public interface OnDbOpListener{
        public void dBOpPerformed(int method);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sqlite_home, container, false);
        buttonSave = view.findViewById(R.id.SQLite_home_button_save);
        buttonSave.setOnClickListener(this);

        buttonView = view.findViewById(R.id.SQLite_home_button_view);
        buttonView.setOnClickListener(this);

        buttonUpdate = view.findViewById(R.id.SQLite_home_button_update);
        buttonUpdate.setOnClickListener(this);

        buttonDelete = view.findViewById(R.id.SQLite_home_button_delete);
        buttonDelete.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SQLite_home_button_save:
                onDbOpListener.dBOpPerformed(0);
                break;
            case R.id.SQLite_home_button_view:
                onDbOpListener.dBOpPerformed(1);
                break;
            case R.id.SQLite_home_button_update:
                onDbOpListener.dBOpPerformed(2);
                break;
            case R.id.SQLite_home_button_delete:
                onDbOpListener.dBOpPerformed(3);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        try{
            onDbOpListener = (OnDbOpListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must implement interface method");
        }
    }
}
