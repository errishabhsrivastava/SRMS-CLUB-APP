package com.user.srmscet.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.user.srmscet.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;
//    Button txtMarquee;
    WebView myWebView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // casting of textview
        TextView rate = view.findViewById(R.id.marqueeText);
        rate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i2=new Intent(Intent.ACTION_VIEW, Uri.parse("http://zestparivartan.com.techbridge.online/regportal/client/generate_pid.php"));
                startActivity(i2);
            }
        });

        // Now we will call setSelected() method
        // and pass boolean value as true
        rate.setSelected(true);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);

        setSliderViews();

//        map = view.findViewById(R.id.map);
//        map.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openMap();
//            }
//        });

        return view;


    }

//    private void openMap() {
//        Uri uri = Uri.parse("");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        intent.setPackage("com.google.android.apps.maps");
//        startActivity(intent);
//    }

    private void setSliderViews() {
        for (int i = 0; i< 6; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d7f63.appspot.com/o/other%20images%2Fcollege.jpg?alt=media&token=e7fd272b-862c-4c79-b42a-af6ed47edb12");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d7f63.appspot.com/o/other%20images%2F2.jpg?alt=media&token=0fba6fee-7526-451c-99f4-f96b6404a990");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d7f63.appspot.com/o/other%20images%2F3.jpg?alt=media&token=0fba6fee-7526-451c-99f4-f96b6404a990");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d7f63.appspot.com/o/other%20images%2F4.jpg?alt=media&token=0fba6fee-7526-451c-99f4-f96b6404a990");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d7f63.appspot.com/o/other%20images%2F5.jpg?alt=media&token=0fba6fee-7526-451c-99f4-f96b6404a990");
                    break;
                case 5:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d7f63.appspot.com/o/other%20images%2F6.jpg?alt=media&token=0fba6fee-7526-451c-99f4-f96b6404a990");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

            sliderLayout.addSliderView(sliderView);
        }
    }

    public void marquee(View view) {
        String url = "www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void marque(View view) {
    }
}