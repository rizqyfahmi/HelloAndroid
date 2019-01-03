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
public class RoomDBDeleteUserFragment extends Fragment {

    private Button button;
    private EditText id;

    public RoomDBDeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room_db_delete_user, container, false);
        id = view.findViewById(R.id.RoomDB_delete_user_id);
        button = view.findViewById(R.id.RoomDB_delete_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tempId = Integer.parseInt(id.getText().toString());
                RoomDBUser user = new RoomDBUser();
                user.setId(tempId);
                MainRoomDBActivity.roomDBAppDatabase.roomDBUserDAO().deleteUser(user);

                id.setText("");
                Toast.makeText(getActivity(), "User Successfully Removed", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

}
