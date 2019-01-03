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
public class SQLiteUpdateFragment extends Fragment {

    private Button buttonSave;
    private EditText id, name, email;

    public SQLiteUpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sqlite_update, container, false);
        id = view.findViewById(R.id.SQLite_delete_et_id);
        name = view.findViewById(R.id.SQLite_update_et_name);
        email = view.findViewById(R.id.SQLite_update_et_email);

        buttonSave = view.findViewById(R.id.SQLite_update_button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });
        return view;

    }

    private void updateContact(){
        int tempId = Integer.parseInt(id.getText().toString());
        String tempName = name.getText().toString();
        String tempEmail = email.getText().toString();

        SQLiteContactDBHelper contactDBHelper = new SQLiteContactDBHelper(getActivity());
        SQLiteDatabase db = contactDBHelper.getWritableDatabase();

        contactDBHelper.updateContact(tempId, tempName, tempEmail, db);
        contactDBHelper.close();

        id.setText("");
        name.setText("");
        email.setText("");

        Toast.makeText(getActivity(), "Contact Updated", Toast.LENGTH_SHORT).show();
    }

}
