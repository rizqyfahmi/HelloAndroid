package com.rizqyfahmi.helloandroid;


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
public class RoomDBAddUserFragmant extends Fragment {

    private Button buttonSave;
    private EditText id, name, email;

    public RoomDBAddUserFragmant() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room_db_add_user_fragmant, container, false);

        id = view.findViewById(R.id.RoomDB_add_user_id_et);
        name = view.findViewById(R.id.RoomDB_add_name_et);
        email = view.findViewById(R.id.RoomDB_add_email_et);
        buttonSave = view.findViewById(R.id.RoomDB_add_save_button);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tempId = Integer.parseInt(id.getText().toString());
                String tempName = name.getText().toString();
                String tempEmail = email.getText().toString();

                RoomDBUser user = new RoomDBUser();
                user.setId(tempId);
                user.setName(tempEmail);
                user.setEmail(tempEmail);

                MainRoomDBActivity.roomDBAppDatabase.roomDBUserDAO().addUser(user);

                id.setText("");
                name.setText("");
                email.setText("");

                Toast.makeText(getActivity(), "User added successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
