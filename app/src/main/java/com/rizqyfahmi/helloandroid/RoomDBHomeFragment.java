package com.rizqyfahmi.helloandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoomDBHomeFragment extends Fragment implements View.OnClickListener{
    private Button buttonAdd, buttonView, buttonUpdate, buttonDelete;


    public RoomDBHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room_dbhome, container, false);
        buttonAdd = view.findViewById(R.id.RoomDB_home_add_button);
        buttonAdd.setOnClickListener(this);

        buttonView = view.findViewById(R.id.RoomDB_home_view_button);
        buttonView.setOnClickListener(this);

        buttonUpdate = view.findViewById(R.id.RoomDB_home_update_button);
        buttonUpdate.setOnClickListener(this);

        buttonDelete = view.findViewById(R.id.RoomDB_home_delete_button);
        buttonDelete.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.RoomDB_home_add_button:
                MainRoomDBActivity.fragmentManager.beginTransaction().replace(R.id.RoomDB_fragment_container, new RoomDBAddUserFragmant()).addToBackStack(null).commit();
                break;
            case R.id.RoomDB_home_view_button:
                MainRoomDBActivity.fragmentManager.beginTransaction().replace(R.id.RoomDB_fragment_container, new RoomDBReadUsersFragment()).addToBackStack(null).commit();
                break;
            case R.id.RoomDB_home_update_button:
                MainRoomDBActivity.fragmentManager.beginTransaction().replace(R.id.RoomDB_fragment_container, new RoomDBUpdateUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.RoomDB_home_delete_button:
                MainRoomDBActivity.fragmentManager.beginTransaction().replace(R.id.RoomDB_fragment_container, new RoomDBDeleteUserFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
