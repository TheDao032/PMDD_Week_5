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
    TextView txtRed;
    Button btnRedClock;

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
        // Activities containing this fragment must implement interface: MainCallbacks
        if (!(getActivity() instanceof MainCallBacks)) {
            throw new IllegalStateException("Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity(); // use this reference to invoke main callbacks
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // inflate res/layout_red.xml which includes a textview and a button
        RelativeLayout user_info = (RelativeLayout) inflater.inflate(R.layout.user_info, null);
//        txtUserForm = (TextView) user_form.findViewById(R.id.textView1Red);
        // show string argument supplied by constructor (if any!)
//        try { Bundle arguments = getArguments(); txtRed.setText(arguments.getString("arg1", "")); }
//        catch (Exception e) { Log.e("RED BUNDLE ERROR – ", "" + e.getMessage()); }
//        // clicking the button changes the time displayed and sends a copy to MainActivity
//        btnRedClock = (Button) user_form.findViewById(R.id.button1Red);
//        btnRedClock.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String redMessage = "Red clock:\n" + new Date().toString();
//                txtRed.setText(redMessage);
//                main.onMsgFromFragToMain("RED-FRAG", redMessage);
//        }});
        return user_info;
    }

    @Override
    public void onMsgFromMainToFragment(String strValue) {
        // receiving a message from MainActivity (it may happen at any point in time)
        txtRed.setText("THIS MESSAGE COMES FROM MAIN:" + strValue);
    }
}