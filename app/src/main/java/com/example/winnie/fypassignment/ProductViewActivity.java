package com.example.winnie.fypassignment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ProductViewActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    SliderLayout sliderLayout;
ImageView image3;
TextView etItemName;
    SalesProductclass salesproductclass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);


        salesproductclass = new SalesProductclass();

        etItemName = (TextView) findViewById(R.id.etItemName);

       String s = getIntent().getStringExtra("EXTRA_SESSION_ID");

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
     etItemName.setText(salesproductclass.getItem());

  //  sliderLayout = (SliderLayout) findViewById(R.id.slider);

    //Call this method if you want to add images from URL .
      AddImagesUrlOnline();

    //Call this method to add images from local drawable folder .
        AddImageUrlFormLocalRes();

    //Call this method to stop automatic sliding.
    //sliderLayout.stopAutoCycle();

        image3 = (ImageView)findViewById(R.id.imageadd1);



//    for (String name : HashMapForURL.keySet()) {
//
//        TextSliderView textSliderView = new TextSliderView(ProductViewActivity.this);
//
//        textSliderView
//                .description(name)
//                .image(HashMapForURL.get(name))
//                .setScaleType(BaseSliderView.ScaleType.Fit)
//                .setOnSliderClickListener(this);
//
//        textSliderView.bundle(new Bundle());
//
//        textSliderView.getBundle()
//                .putString("extra", name);
//
//        sliderLayout.addSlider(textSliderView);
//    }
//    sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
//
//    sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//
//    sliderLayout.setCustomAnimation(new DescriptionAnimation());
//
//    sliderLayout.setDuration(3000);
//
//    sliderLayout.addOnPageChangeListener(ProductViewActivity.this);
}


    @Override
    protected void onStop() {

    //    sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

       // Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

      //  Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void AddImagesUrlOnline() {
//
       // HashMapForURL = new HashMap<String, String>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference().getRoot();
        databaseReference.child("account").child("12AAD102").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, Object> map = (Map) dataSnapshot.getValue();

                String[]  urlimage={
                 map.get("image").toString(),
                map.get("image1").toString()};

                ViewPager vp = (ViewPager) findViewById(R.id.view);
                ImageAdapter adap = new ImageAdapter(ProductViewActivity.this,urlimage,"");

                TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
                tabLayout.setupWithViewPager(vp, true);
                final int pageMargin = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, -8, getResources() .getDisplayMetrics());
                vp.setPageMargin(pageMargin);
                vp.setAdapter(adap);

                    System.out.println("aaaaaaaaaaaaaaaaaa          "+urlimage[0]);
                    System.out.println("aaaaaaaaaaaaaaaaaa          "+urlimage[1]);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

}

    public void AddImageUrlFormLocalRes() {

    }


}
