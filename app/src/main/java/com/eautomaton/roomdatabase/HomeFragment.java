package com.eautomaton.roomdatabase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button mbtn_add_user, mbtn_view_users, mbtn_delete_user,mbtn_update_user;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mbtn_add_user = view.findViewById(R.id.btn_add_user);
        mbtn_view_users = view.findViewById(R.id.btn_view_users);
        mbtn_delete_user = view.findViewById(R.id.btn_delete_user);
        mbtn_update_user=view.findViewById(R.id.btn_update_user);

        mbtn_add_user.setOnClickListener(this);
        mbtn_view_users.setOnClickListener(this);
        mbtn_delete_user.setOnClickListener(this);
        mbtn_update_user.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_view_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadUserFragment()).
                        addToBackStack(null).commit();

                break;
            case R.id.btn_delete_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteUserFragment()).
                        addToBackStack(null).commit();
                break;
            case R.id.btn_update_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateUserFragment()).
                        addToBackStack(null).commit();
                break;
        }

    }


}
