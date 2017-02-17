package com.example.winnie.fypassignment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProductAddActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private EditText etMessageBox,texttitle,textPrice,textLocation;
    private Button  btn_cleartitle,btn_clearbox,btn_clearPrice,btn_clearlocation,buttonSell;
    ImageView imageadd1,imageadd2,imageadd3;
    Spinner spinnerCategory,spinnerCondition;
    String itemCategory,itemCondition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        etMessageBox = (EditText)findViewById(R.id.etMessageBox);
        btn_clearbox = (Button)findViewById(R.id.btn_clearbox);

        texttitle = (EditText)findViewById(R.id.texttitle);
        btn_cleartitle = (Button)findViewById(R.id.btn_cleartitle);

        textPrice = (EditText)findViewById(R.id.textPrice);
        btn_clearPrice = (Button)findViewById(R.id.btn_clearPrice);

        textLocation = (EditText)findViewById(R.id.textLocation);
        btn_clearlocation = (Button)findViewById(R.id.btn_clearlocation);
        buttonSell = (Button)findViewById(R.id.buttonSell);

        etMessageBox.addTextChangedListener(textWatcher());
        texttitle.addTextChangedListener(textWatcher());
        textPrice.addTextChangedListener(textWatcher());
        textLocation.addTextChangedListener(textWatcher());

        btn_clearbox.setOnClickListener(this);
        btn_cleartitle.setOnClickListener(this);
        btn_clearPrice.setOnClickListener(this);
        btn_clearlocation.setOnClickListener(this);
        buttonSell.setOnClickListener(this);


        spinnerCategory = (Spinner) findViewById(R.id.spinnerCategory);
        spinnerCondition = (Spinner) findViewById(R.id.spinnerCondition);

        spinnerCategory.setOnItemSelectedListener(this);
        spinnerCondition.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("Men's fashion");
        categories.add("Women's fashion");
        categories.add("Beauty");
        categories.add("Home & Living");
        categories.add("Gadgets & Accessories");
        categories.add("Books");
        categories.add("Art & Design");
        categories.add("Collectibles & Hobbies");
        categories.add("Everything else");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(dataAdapter);

        List<String> condition = new ArrayList<String>();
        condition.add("Condition");
        condition.add("Preloved");
        condition.add("New");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, condition);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCondition.setAdapter(dataAdapter2);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
         itemCategory = parent.getItemAtPosition(position).toString();
        itemCondition = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
      Toast.makeText(parent.getContext(), "Selected: " + itemCategory, Toast.LENGTH_SHORT).show();
        Toast.makeText(parent.getContext(), "Selected: " + itemCondition, Toast.LENGTH_SHORT).show();

    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_clearbox:
                etMessageBox.setText("");
                break;

            case R.id.btn_cleartitle:
                texttitle.setText("");
                break;

            case R.id.btn_clearPrice:
                textPrice.setText("");
                break;

            case R.id.btn_clearlocation:
                textLocation.setText("");
                break;
            case R.id.buttonSell:
                databaseAdd();
        }
    }

    private void databaseAdd(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference().getRoot().child("Category").child("clothes").push();

        databaseReference.child("item name").setValue("long pant");
        databaseReference.child("student id").setValue("12aad1212");
        databaseReference.child("price").setValue(234.3);

    }

    private TextWatcher textWatcher() {
        return new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!etMessageBox.getText().toString().equals("")) { //if edittext include text
                    btn_clearbox.setVisibility(View.VISIBLE);
                } else { //not include text
                    btn_clearbox.setVisibility(View.GONE);
                 //   textView.setText("Edittext cleared!");
                }

                if (!texttitle.getText().toString().equals("")) { //if edittext include text
                    btn_cleartitle.setVisibility(View.VISIBLE);
                } else { //not include text
                    btn_cleartitle.setVisibility(View.GONE);
                }

                if (!textPrice.getText().toString().equals("")) { //if edittext include text
                    btn_clearPrice.setVisibility(View.VISIBLE);
                } else { //not include text
                    btn_clearPrice.setVisibility(View.GONE);
                }

                if (!textLocation.getText().toString().equals("")) { //if edittext include text
                    btn_clearlocation.setVisibility(View.VISIBLE);
                } else { //not include text
                    btn_clearlocation.setVisibility(View.GONE);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

}
