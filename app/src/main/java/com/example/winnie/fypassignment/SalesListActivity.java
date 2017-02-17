package com.example.winnie.fypassignment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class SalesListActivity extends AppCompatActivity {
    ListView mListView;
  //  ArrayAdapter<String> adapter;
    ArrayList<String> listitemname = new ArrayList<>();
    ArrayList<String> listprice = new ArrayList<>();
    ArrayList<String> listimg1 = new ArrayList<>();
private ProgressDialog mProgress;
    // positionRow p ;
   CustomListAdapter adapter;String name;
    Integer[] imgid={
            R.drawable.ic_picture,
            R.drawable.ic_picture,
            R.drawable.ic_picture,
            R.drawable.ic_picture,
            R.drawable.ic_picture,
            R.drawable.ic_picture,
            R.drawable.ic_picture,
            R.drawable.ic_picture,
    };
    SalesProductclass a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_list);

        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Loading");
        mProgress.show();

          adapter=new CustomListAdapter(this, listitemname,listimg1 , listprice);
         mListView = (ListView) findViewById(R.id.mListView);
        mListView.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference().getRoot();

     //   adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
        mListView.setAdapter(adapter);
        databaseReference.child("Category").child("clothes").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               // String value= dataSnapshot.getValue(String.class).toString();
                Map<String, Object> map = (Map) dataSnapshot.getValue();
                name = map.get("item name").toString();
             String   price = map.get("price").toString();
             String   img1 = map.get("image1").toString();
//                name = map.get("item name").toString();
//                name = map.get("item name").toString();
                listitemname.add(name);
                listprice.add(price);
                listimg1.add(img1);
                adapter.notifyDataSetChanged();
                mProgress.dismiss();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String value= dataSnapshot.getValue(String.class);
              //  list.remove(value);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= listitemname.get(position);
                 a = new SalesProductclass();
                a.setItem(Slecteditem);
               // Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent (SalesListActivity.this, ProductViewActivity.class);
                intent.putExtra("EXTRA_SESSION_ID", Slecteditem);
                startActivity(intent);
            }
        });



//        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, databaseReference) {
//            @Override
//            protected void populateView(View v, String model, int position) {
//                TextView textView = (TextView) v.findViewById(android.R.id.text1);
//                textView.setText(model);
//            }
//        };
//        mListView.setAdapter(firebaseListAdapter);

    }










}
