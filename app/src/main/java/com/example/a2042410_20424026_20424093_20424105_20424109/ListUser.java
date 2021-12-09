package com.example.a2042410_20424026_20424093_20424105_20424109;

import androidx.fragment.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListUser extends Fragment implements FragmentCallBacks{
    // this fragment shows a ListView
    MainActivity main;
    Context context = null;
    String message = "";
    TextView ListUser;
    // data to fill-up the ListView
    private String items[] = {};
    UserAdapter userAdapter;
    ListView lvContact;
    static int position;
    // convenient constructor(accept arguments, copy them to a bundle, binds bundle to fragment)

    public static ListUser newInstance(String strArg) {
        ListUser fragment = new ListUser();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = getActivity(); // use this reference to invoke main callbacks
            main = (MainActivity) getActivity();

            userAdapter = new UserAdapter(context, new ArrayList<>());
            userAdapter.add(new User("20HCB1", "Lê Thanh Nguyên", 8.2));
            userAdapter.add(new User("20HCB1", "Nguyễn Thị Mến", 7.3));
            userAdapter.add(new User("20HCB1", "Phạm Thị Ngọc Hạnh", 9.0));
            userAdapter.add(new User("20HCB1", "Nguyễn Thế Đạo", 8.5));
            userAdapter.add(new User("20HCB1", "Nguyễn Đoàn Tuấn Anh", 7.9));
        }
            catch (IllegalStateException e) {
            throw new IllegalStateException("MainActivity must implement callbacks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout layout_list_user = (RelativeLayout) inflater.inflate(R.layout.list_user, null);

        lvContact = (ListView) layout_list_user.findViewById(R.id.lvContact);

        lvContact.setAdapter(userAdapter);
        lvContact.setSelection(0); lvContact.smoothScrollToPosition(0);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                main.onUserFromFragToMain(userAdapter.getItem(position), position);
        }});
        return layout_list_user;
    }

    @Override
    public void onStart() {
        super.onStart();

        this.position = 0;
        main.onUserFromFragToMain(userAdapter.getItem(0), 0);
    }

    @Override
    public void onUserFromMainToFragment(User information, int position) {
    }

    @Override
    public void onPositionFromMainToFragment(int position, int key) {
        // Next
        if (key == 1) {
            this.position = position + 1;
        } else if (key == 2) {
            this.position = position - 1;
        } else if (key == 3) {
            this.position = 0;
        } else if (key == 4) {
            this.position = userAdapter.getCount() - 1;
        }

        main.onUserFromFragToMain(userAdapter.getItem(this.position), this.position);
    }
}
