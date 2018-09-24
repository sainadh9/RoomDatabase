package com.eautomaton.roomdatabase;


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
public class ReadUserFragment extends Fragment {
    private TextView mtxt_display_info;


    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1=inflater.inflate(R.layout.fragment_read_user, container, false);
        mtxt_display_info=view1.findViewById(R.id.txt_display_info);
        // Inflate the layout for this fragment
        List<User> users=MainActivity.myAppDatabase.mMyDao().getUsers();
        String info="";
        for (User user:users){
            int id=user.getId();
            String name=user.getName();
            String email=user.getEmail();
            info=info+"\n\n"+"id:"+id+"\n Name:"+name+"\n"+"Email: "+email;
        }
        mtxt_display_info.setText(info);
        return view1;
    }

}
