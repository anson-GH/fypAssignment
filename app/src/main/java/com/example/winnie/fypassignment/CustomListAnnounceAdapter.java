package com.example.winnie.fypassignment;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAnnounceAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String>  AnnounceTitle;
    private final ArrayList<String>  AnnounceCourse;
    private final ArrayList<String>  AnnounceDate;
    private final ArrayList<String>  AnnounceTime;

   // private final Integer[] imgid;

    public CustomListAnnounceAdapter(Activity context, ArrayList<String> AnnounceTitle, ArrayList<String> AnnounceCourse, ArrayList<String> AnnounceDate, ArrayList<String> AnnounceTime) {
        super(context, R.layout.mylist, AnnounceTitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.AnnounceTitle=AnnounceTitle;
        this.AnnounceCourse=AnnounceCourse;
        this.AnnounceDate=AnnounceDate;
         this.AnnounceTime=AnnounceTime;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_notice, null,true);

        TextView txtAnnTitle = (TextView) rowView.findViewById(R.id.txtAnnTitle);
        TextView txtAnnCourse = (TextView) rowView.findViewById(R.id.txtAnnCourse);
        TextView txtDate = (TextView) rowView.findViewById(R.id.txtDate);
        TextView txttime = (TextView) rowView.findViewById(R.id.txttime);

        txtAnnTitle.setText(AnnounceTitle.get(position));
        txtAnnCourse.setText(AnnounceCourse.get(position));
        txtDate.setText(AnnounceDate.get(position));
        txttime.setText(AnnounceTime.get(position));
        return rowView;

    };
}