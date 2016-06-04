package com.wpam.gamejamapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Bitmap icon = BitmapFactory.decodeResource(getResources(),
                R.drawable.profile_pic);


//        String name = c.getString(str_url);
//        URL url_value = new URL(name);
//        ImageView profile = (ImageView)v.findViewById(R.id.vdo_icon);
//        if (profile != null) {
//            Bitmap mIcon1 =
//                    BitmapFactory.decodeStream(url_value.openConnection().getInputStream());
//            profile.setImageBitmap(mIcon1);
//        }

        final Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {

                int def = 0x000000;
                int color = palette.getLightVibrantColor(def);
                getView().findViewById(R.id.layout_profile).setBackgroundColor(color);
//                card.setCardBackgroundColor(color);
            }
        };

        Palette.from(icon).generate(paletteListener);

        icon = getCroppedBitmap(icon);
        ImageView img = (ImageView) view.findViewById(R.id.image_profile_user);
        img.setImageBitmap(icon);

//        Bitmap bg = BitmapFactory.decodeResource(getResources(),
//                R.drawable.ic_color_lens_black_48dp);

//        bg = applyGaussianBlur(bg);
//
//        ImageView bgView = (ImageView) view.findViewById(R.id.image_profile_user_back);
//        bgView.setImageBitmap(bg);

        return view;
    }

    public Bitmap getCroppedBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
                bitmap.getHeight() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        //Bitmap _bmp = Bitmap.createScaledBitmap(output, 60, 60, false);
        //return _bmp;
        return output;
    }

//    public static Bitmap applyGaussianBlur(Bitmap src) {
//        double[][] GaussianBlurConfig = new double[][] {
//                { 1, 2, 1 },
//                { 2, 4, 2 },
//                { 1, 2, 1 }
//        };
//
//        ConvolutionMatrix convMatrix = new ConvolutionMatrix(3);
//        convMatrix.applyConfig(GaussianBlurConfig);
//        convMatrix.Factor = 16;
//        convMatrix.Offset = 0;
//        return ConvolutionMatrix.computeConvolution3x3(src, convMatrix);
//    }
}
