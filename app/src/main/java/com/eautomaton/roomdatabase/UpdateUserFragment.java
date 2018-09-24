package com.eautomaton.roomdatabase;


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
public class UpdateUserFragment extends Fragment {
    EditText met_userId,met_userName,met_userEmail;
    Button mbtn_update;


    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_update_user, container, false);
        met_userId=view.findViewById(R.id.et_userId);
        met_userName=view.findViewById(R.id.et_userName);
        met_userEmail=view.findViewById(R.id.et_userEmail);
        mbtn_update=view.findViewById(R.id.btn_update);
        mbtn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id= Integer.parseInt(met_userId.getText().toString().trim());
                String name=met_userName.getText().toString().trim();
                String email=met_userEmail.getText().toString().trim();
                User user=new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                MainActivity.myAppDatabase.mMyDao().updateUser(user);
                Toast.makeText(getContext(),"Updated",Toast.LENGTH_SHORT).show();
                met_userId.setText("");
                met_userName.setText("");
                met_userEmail.setText("");
            }
        });
        return view;
        //This is my code
    }

}
