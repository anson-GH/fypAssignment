package com.example.winnie.fypassignment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AnnouncementListActivity extends AppCompatActivity {
    ListView mListView;
    //  ArrayAdapter<String> adapter;
    ArrayList<String> listTitle = new ArrayList<>();
    ArrayList<String> listName = new ArrayList<>();
    ArrayList<String> listTime = new ArrayList<>();
    ArrayList<String> listDate = new ArrayList<>();
    private ProgressDialog mProgress;
    // positionRow p ;
    CustomListAnnounceAdapter adapter; String name;

    SalesProductclass a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement_list);


//        mProgress = new ProgressDialog(this);
//        mProgress.setMessage("Loading");
//        mProgress.show();

//        adapter = new CustomListAnnounceAdapter(this, listTitle, listName, listDate, listTime);
//        mListView = (ListView) findViewById(R.id.mListView);
//        mListView.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
         DatabaseReference databaseReference = database.getReference().getRoot();

        databaseReference.child("Announcement").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                for (DataSnapshot keys : dataSnapshot.getChildren()) {
              System.out.println("hahhahahasdasdasda     " );
                String tempKey2 = dataSnapshot.getKey().toString();
//                    //  listName.add(tempKey2);
//                    //  String tempKey3 = dataSnapshot.child(tempKey2).child("RSDgroup1").getValue().toString();
//                    //  String tempKey4 = dataSnapshot.child(tempKey3).getValue().toString();
//                    // Map<String, Object> map = (Map) dataSnapshot.child(tempKey4).getValue();
//                    //  String title = map.get("Title").toString();
//                    //  String name = map.get("name").toString();
//                    System.out.println("hahhahaha     " + tempKey2);
//                    System.out.println("hahhahaha     " + name);
//                    // listTitle.add(title);
//
//                }
                System.out.println("hahhahahasdasdasda     " +tempKey2);

                // String value= dataSnapshot.getValue(String.class).toString();
                //                Map<String, Object> map = (Map) dataSnapshot.getValue();
                //                name = map.get("item name").toString();
                //                String   price = map.get("Title").toString();
                //                String   img1 = map.get("Course").toString();
                //                String   price = map.get("price").toString();
                //                String   img1 = map.get("image1").toString();
                //
                //                listTitle.add(name);
                //                listName.add(price);
                //                listDate.add(name);
                //                listTime.add(price);
                //                adapter.notifyDataSetChanged();
                //                mProgress.dismiss();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
//
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // TODO Auto-generated method stub
//                String Slecteditem= listTitle.get(position);
//                a = new SalesProductclass();
//                a.setItem(Slecteditem);
//                // Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent (AnnouncementListActivity.this, ProductViewActivity.class);
//                intent.putExtra("EXTRA_SESSION_ID", Slecteditem);
//                startActivity(intent);
//            }
//        });

    }
}