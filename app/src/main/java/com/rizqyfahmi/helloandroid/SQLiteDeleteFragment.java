package com.rizqyfahmi.helloandroid;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SQLiteDeleteFragment extends Fragment {

    private Button button;
    private EditText id;

    public SQLiteDeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sqlite_delete, container, false);
        id = view.findViewById(R.id.SQLite_delete_et_id);
        button = view.findViewById(R.id.SQLite_delete_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });

        return view;
    }

    private void deleteContact(){
        SQLiteContactDBHelper contactDBHelper = new SQLiteContactDBHelper(getActivity());
        SQLiteDatabase db = contactDBHelper.getWritableDatabase();

        int tempId = Integer.parseInt(id.getText().toString());

        contactDBHelper.deleteContact(tempId, db);
        contactDBHelper.close();

        id.setText("");

        Toast.makeText(getActivity(), "Contact Removed Successfully", Toast.LENGTH_SHORT).show();
    }

}
