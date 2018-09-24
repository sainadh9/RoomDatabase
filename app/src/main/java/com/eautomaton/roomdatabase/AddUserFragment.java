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
public class AddUserFragment extends Fragment {
    private EditText met_userId,met_userName,met_userEmail;
    private Button mbtn_save;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_user, container, false);
        met_userId=view.findViewById(R.id.et_userId);
        met_userName=view.findViewById(R.id.et_userName);
        met_userEmail=view.findViewById(R.id.et_userEmail);
        mbtn_save=view.findViewById(R.id.btn_save);
        //The app will crash because we are using operations on main thread
        mbtn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userId=Integer.parseInt(met_userId.getText().toString().trim());
                String userName=met_userName.getText().toString().trim();
                String userEmail=met_userEmail.getText().toString().trim();
                User user=new User();
                user.setId(userId);
                user.setEmail(userEmail);
                user.setName(userName);

                MainActivity.myAppDatabase.mMyDao().addUser(user);
                Toast.makeText(getActivity(),"User added successfully",Toast.LENGTH_SHORT).show();
                met_userId.setText("");
                met_userEmail.setText("");
                met_userName.setText("");
            }
        });
        return view ;
    }

}
