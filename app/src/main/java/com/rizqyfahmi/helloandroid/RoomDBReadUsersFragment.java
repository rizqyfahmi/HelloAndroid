package com.rizqyfahmi.helloandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoomDBReadUsersFragment extends Fragment {

    private TextView userDisplay;

    public RoomDBReadUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room_db_read_users, container, false);
        userDisplay = view.findViewById(R.id.RoomDB_read_tv);

        String info = "";
        List<RoomDBUser> users = MainRoomDBActivity.roomDBAppDatabase.roomDBUserDAO().getUsers();
        for (RoomDBUser user : users){
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info+"\n\n"+"ID: "+id+"\nName: "+name+"\nEmail: "+email;
        }

        userDisplay.setText(info);
        return view;
    }

}
