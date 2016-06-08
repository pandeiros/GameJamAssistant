package com.wpam.gamejamapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.wpam.gamejamapp.db.DB;
import com.wpam.gamejamapp.model.CategoryTag;
import com.wpam.gamejamapp.model.Profile;

import org.apmem.tools.layouts.FlowLayout;

import java.util.Set;

public class ProfileFragment extends Fragment {
    private Profile profile;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DB.getInstance().refresh();

        profile = DB.getInstance().getProfile();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

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
                view.findViewById(R.id.layout_profile).setBackgroundColor(color);
//                getView().findViewById(R.id.layout_profile).setBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary_lighter));
            }
        };

        Palette.from(icon).generate(paletteListener);

        icon = getCroppedBitmap(icon);
        ImageView img = (ImageView) view.findViewById(R.id.image_profile_user);
        img.setImageBitmap(icon);

        // Username
        TextView username = (TextView) view.findViewById(R.id.profile_username);
        username.setText(profile.getUsername());

        // Role
        TextView role = (TextView) view.findViewById(R.id.profile_role);
        role.setText(profile.getRole().getFunction());

        // Tags
        FlowLayout flowLayout = (FlowLayout) view.findViewById(R.id.flow_layout_user_tags);
        CategoryTag[] tags = profile.getTags();
        for (int i = 0; i < tags.length; i++) {
            Log.e("ITERUJE", Integer.toString(i));
            inflater.inflate(R.layout.card_user_tag, flowLayout);
            CardView card = (CardView) flowLayout.getChildAt(i);

            TextView text = (TextView) card.findViewById(R.id.card_user_tag_title);
            text.setText(tags[i].getName());
            card.setCardBackgroundColor(Utils.getColor(getContext(), tags[i].getColor()));
        }

        // Team name
        TextView teamTitle = (TextView) view.findViewById(R.id.team_title);
        teamTitle.setText(profile.getTeam().getName());

        // Team members
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.layout_team_members);
        Set<Profile> members = profile.getTeam().getAllMembers();
        int index = 0;

        for (Profile m : members) {
            if (m.getUsername().equals(profile.getUsername()))
                continue;

            inflater.inflate(R.layout.include_profile_team_member, layout);

            // Member icon
            View memberLayout = layout.getChildAt(index);
            TextDrawable drawable = TextDrawable.builder()
                    .buildRoundRect(m.getUsername().substring(0, 1),
                            Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)), 10);
//                    .buildRoundRect(m.getName().substring(0, 1), Utils.getColor(getContext(), R.color.accent), 10);

            ImageView image = (ImageView) memberLayout.findViewById(R.id.image_team_member);
            image.setImageDrawable(drawable);

            // Member name
            TextView memberTitle = (TextView) memberLayout.findViewById(R.id.team_member_title);
            memberTitle.setText(m.getUsername());

            index++;
        }

        // Team name
        TextView gameTitle = (TextView) view.findViewById(R.id.profile_game_title);
        gameTitle.setText(profile.getTeam().getGame().getName());

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
}