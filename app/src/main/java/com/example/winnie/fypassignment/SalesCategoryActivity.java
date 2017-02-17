package com.example.winnie.fypassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

public class SalesCategoryActivity extends AppCompatActivity {
    GridView grid;
    String[] web = {
            "Men's fashion",
            "Women's fashion",
            "Home & Living",
            "Beauty",
            "Books",
            "Art & Design",
            "Gadgets & Accessories",
            "Collectibles & Hobbies",
            "Everything else"

    } ;
    int[] imageId = {
            R.drawable.men,
            R.drawable.wome,
            R.drawable.homr,
            R.drawable.beauty,
            R.drawable.book,
            R.drawable.art,
            R.drawable.gad,
            R.drawable.hobb,
            R.drawable.others
    };
    Intent intent;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_category);

        CustomGrid2 adapter = new CustomGrid2(SalesCategoryActivity.this, web, imageId);
        grid = (GridView) findViewById(R.id.gridCategory);
        grid.setAdapter(adapter);
    }
}
