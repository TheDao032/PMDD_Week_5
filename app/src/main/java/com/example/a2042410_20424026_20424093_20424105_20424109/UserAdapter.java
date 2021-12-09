package com.example.a2042410_20424026_20424093_20424105_20424109;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private final Context context;

    // View lookup cache
    private static class ViewHolder {
        ImageView avatar;
        TextView name;
        TextView average;
        TextView grade;
    }

    public UserAdapter(Context context, List<User> users) {
        super(context, R.layout.user_form, users);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.user_form, parent, false);
        }
        if (viewHolder == null){
            viewHolder = new ViewHolder();
        }

        viewHolder.avatar = (ImageView) convertView.findViewById(R.id.ivAvatar);
        viewHolder.name = (TextView) convertView.findViewById(R.id.tvName);
        viewHolder.grade = (TextView) convertView.findViewById(R.id.tvGrade);

        viewHolder.name.setText(user.getName());
        viewHolder.grade.setText(user.getGrade());
        return convertView;
    }
}
