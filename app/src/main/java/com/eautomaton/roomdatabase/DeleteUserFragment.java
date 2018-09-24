package com.eautomaton.roomdatabase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteUserFragment extends Fragment {
    private EditText met_deleteUser;
    private Button mbtn_delete;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        met_deleteUser=view.findViewById(R.id.et_deleteUser);
        mbtn_delete=view.findViewById(R.id.btn_delete);
        mbtn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(met_deleteUser.getText().toString());
                User user=new User();
                user.setId(id);
                MainActivity.myAppDatabase.mMyDao().deleteUser(user);
                Toast.makeText(getContext(),"User removed",Toast.LENGTH_SHORT).show();
                met_deleteUser.setText("");
            }
        });
        return view;
    }


}
