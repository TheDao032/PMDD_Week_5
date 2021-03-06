package com.example.a2042410_20424026_20424093_20424105_20424109;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UserInfo extends Fragment implements FragmentCallBacks {
    MainActivity main;
    TextView userName;
    TextView userGrade;
    TextView userAverage;
    Button btnLast;
    Button btnPrevious;
    Button btnNext;
    Button btnFirst;


    static int position;


    public static UserInfo newInstance(String strArg1) {
        UserInfo fragment = new UserInfo();
        Bundle bundle = new Bundle();
        bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }// newInstance

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(getActivity() instanceof MainCallBacks)) {
            throw new IllegalStateException("Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // inflate res/layout_red.xml which includes a textview and a button
        RelativeLayout user_info = (RelativeLayout) inflater.inflate(R.layout.user_info, null);
        userName = (TextView) user_info.findViewById(R.id.tvUserName);
        userGrade = (TextView) user_info.findViewById(R.id.tvUserGrade);
        userAverage = (TextView) user_info.findViewById(R.id.tvUserAverage);


        btnNext = (Button) user_info.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onPositionFromFragToMain(position, 1);
        }});

        btnPrevious = (Button) user_info.findViewById(R.id.btnPrevious);
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onPositionFromFragToMain(position, 2);
        }});

        btnFirst = (Button) user_info.findViewById(R.id.btnFirst);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onPositionFromFragToMain(position, 3);
        }});

        btnLast = (Button) user_info.findViewById(R.id.btnLast);
        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onPositionFromFragToMain(position, 4);
        }});
        return user_info;
    }

    @Override
    public void onUserFromMainToFragment(User information, int position) {
        userName.setText("H??? T??n:" + information.getName());
        userGrade.setText("L???p:" + information.getGrade());
        userAverage.setText("??i???m trung b??nh:" + information.getAverage());
        System.out.println(information.getName());
        this.position = position;
    }

    @Override
    public void onPositionFromMainToFragment(int position, int key) {
    }
}