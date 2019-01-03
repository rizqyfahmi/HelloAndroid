package com.rizqyfahmi.helloandroid;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SQLiteReadContactsFragment extends Fragment {

    private TextView tvDisplay;

    public SQLiteReadContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sqlite_read_contacts, container, false);
        tvDisplay = view.findViewById(R.id.SQLite_read_tv_display);
        readContacts();
        return view;
    }

    private void readContacts(){
        SQLiteContactDBHelper contactDBHelper = new SQLiteContactDBHelper(getActivity());
        SQLiteDatabase db = contactDBHelper.getReadableDatabase();

        Cursor cursor = contactDBHelper.readContacts(db);
        String info = "";
        while (cursor.moveToNext()){
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(SQLiteContactContract.ContactEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(SQLiteContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(SQLiteContactContract.ContactEntry.EMAIL));
            info = info+"\n\n"+"ID: "+id+"\nName: "+name+"\nEmail: "+email;
        }

        tvDisplay.setText(info);
        contactDBHelper.close();
    }

}
