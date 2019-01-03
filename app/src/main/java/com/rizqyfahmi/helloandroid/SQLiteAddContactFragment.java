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
public class SQLiteAddContactFragment extends Fragment {
    private Button buttonSave;
    private EditText id, name, email;

    public SQLiteAddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sqlite_add_contact, container, false);

        buttonSave = view.findViewById(R.id.SQLite_add_button_save);
        id = view.findViewById(R.id.SQLite_delete_et_id);
        name = view.findViewById(R.id.SQLite_update_et_name);
        email = view.findViewById(R.id.SQLite_update_et_email);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempId = id.getText().toString();
                String tempName = name.getText().toString();
                String tempEmail = email.getText().toString();

                SQLiteContactDBHelper contactDBHelper = new SQLiteContactDBHelper(getActivity());
                SQLiteDatabase db = contactDBHelper.getWritableDatabase();

                contactDBHelper.addContact(Integer.parseInt(tempId), tempName, tempEmail, db);
                contactDBHelper.close();

                id.setText("");
                name.setText("");
                email.setText("");

                Toast.makeText(getActivity(), "Contact Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
