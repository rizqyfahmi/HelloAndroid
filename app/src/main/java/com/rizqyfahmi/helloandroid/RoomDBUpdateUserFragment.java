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
public class RoomDBUpdateUserFragment extends Fragment {

    private Button buttonSave;
    private EditText id, name, email;

    public RoomDBUpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room_db_update_user, container, false);
        id = view.findViewById(R.id.RoomDB_update_user_id_et);
        name = view.findViewById(R.id.RoomDB_update_name_et);
        email = view.findViewById(R.id.RoomDB_update_email_et);

        buttonSave = view.findViewById(R.id.RoomDB_update_save_button);
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

                MainRoomDBActivity.roomDBAppDatabase.roomDBUserDAO().updateUser(user);

                id.setText("");
                name.setText("");
                email.setText("");

                Toast.makeText(getActivity(), "User Updated", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

}
