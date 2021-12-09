package com.example.a2042410_20424026_20424093_20424105_20424109;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ListAdapter;

import android.support.v4.app.*;

//import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements MainCallBacks{

    FragmentTransaction ft;
    UserInfo userInfoFragment;
    ListUser listUserFragment;
    TextView tvHeader;
    ListView lvContact;
    TextView tvUserFullName;
    TextView tvUserGrade;
    TextView tvUserAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserAdapter userAdapter = new UserAdapter(this, new ArrayList<>());
        userAdapter.add(new User("20HCB1", "Lê Thanh Nguyên", 8.2));
        userAdapter.add(new User("20HCB1", "Nguyễn Thị Mến", 7.3));
        userAdapter.add(new User("20HCB1", "Phạm Thị Ngọc Hạnh", 9.0));
        userAdapter.add(new User("20HCB1", "Nguyễn Thế Đạo", 8.5));
        userAdapter.add(new User("20HCB1", "Nguyễn Đoàn Tuấn Anh", 7.9));

        lvContact = (ListView) findViewById(R.id.lvContact);
//        tvUserFullName = (TextView) findViewById(R.id.tvUserFullName);
//        tvUserGrade = (TextView) findViewById(R.id.tvUserGrade);
//        tvUserAverage = (TextView) findViewById(R.id.tvUserAverage);

        lvContact.setAdapter(userAdapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                User user = (User) adapterView.getAdapter().getItem(position);
                tvUserAverage.setText(user.getAverage().toString());
                tvUserGrade.setText(user.getGrade().toString());
                tvUserFullName.setText(user.getName());
                System.out.println("test");
            }
        });

        ft = getSupportFragmentManager().beginTransaction();
        listUserFragment = ListUser.newInstance("first-blue");
        ft.replace(R.id.list_user, listUserFragment);
        ft.commit();

        // create a new RED fragment - show it
        ft = getSupportFragmentManager().beginTransaction();
        userInfoFragment = UserInfo.newInstance("first-red");
        ft.replace(R.id.user_info, userInfoFragment);
        ft.commit();
    }

    // MainCallback implementation (receiving messages coming from Fragments)

    @Override
    public void onMsgFromFragToMain(String sender, String strValue) {
        // show message arriving to MainActivity
        System.out.println(sender);
        Toast.makeText(getApplication(), " MAIN GOT>> " + sender + "\n" + strValue, Toast.LENGTH_LONG).show();
        if (sender.equals("RED-FRAG")) { /* TODO: if needed, do here something on behalf of the RED fragment*/ }
        if (sender.equals("LIST_USER_FRAG")) {
            try { // forward blue-data to redFragment using its callback method
                userInfoFragment.onMsgFromMainToFragment("\nSender: " + sender + "\nMsg: " + strValue);
            }
            catch (Exception e) { Log.e("ERROR", "onStrFromFragToMain " + e.getMessage()); }
        }
    }
}