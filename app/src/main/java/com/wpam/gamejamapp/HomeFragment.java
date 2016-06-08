package com.wpam.gamejamapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 3;
//        options.inJustDecodeBounds = true;
//        options.inDither = true;
        Bitmap bg = BitmapFactory.decodeResource(getResources(),
                R.drawable.slavic_logo, options);
//        bg = Bitmap.createScaledBitmap(bg, 48, 48, true);
        ImageView eventBg = (ImageView) view.findViewById(R.id.image_event_background);
//        bg = Utils.fastblur(bg, 4, 32);

//        bg.recycle();

        //define this only once if blurring multiple times
        RenderScript rs = RenderScript.create(getContext());


//this will blur the bitmapOriginal with a radius of 8 and save it in bitmapOriginal
        final Allocation input = Allocation.createFromBitmap(rs, bg); //use this constructor for best performance, because it uses USAGE_SHARED mode which reuses memory
        final Allocation output = Allocation.createTyped(rs, input.getType());
        final ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        script.setRadius(25f);
        script.setInput(input);
        script.forEach(output);
        output.copyTo(bg);

        eventBg.setImageBitmap(bg);

        ImageView eventLogo = (ImageView) view.findViewById(R.id.image_event_logo);
        Bitmap logo = BitmapFactory.decodeResource(getResources(),
                R.drawable.slavic_logo, options);
        logo = Utils.getRoundedCornerBitmap(logo, 16);
        eventLogo.setImageBitmap(logo);

        return view;
    }
}
