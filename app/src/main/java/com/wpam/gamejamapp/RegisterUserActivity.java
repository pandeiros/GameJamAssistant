package com.wpam.gamejamapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RegisterUserActivity extends FragmentActivity {

    private int currentFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.register_fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            RegisterRoleFragment fragment = new RegisterRoleFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            fragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.register_fragment_container, fragment).commit();
        }

//        findViewById(R.id.layout_progress_dots).setVisibility(View.VISIBLE);

        ImageView dot = (ImageView) findViewById(R.id.progress_dot1);
        dot.setColorFilter(ContextCompat.getColor(this, R.color.primary_light), PorterDuff.Mode.SRC_IN);

        Button btn = (Button) findViewById(R.id.progress_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterTagsForm();
            }
        });
    }

//    public void showRegisterRoleForm() {
//        if (findViewById(R.id.register_fragment_container) != null) {
//            // Create a new Fragment to be placed in the activity layout
//            RegisterRoleFragment fragment = new RegisterRoleFragment();
//
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//            transaction.setCustomAnimations(R.anim.slide_enter, R.anim.slide_exit, R.anim.slide_enter_back, R.anim.slide_exit_back);
//
//            // Replace whatever is in the fragment_container view with this fragment,
//            // and add the transaction to the back stack so the user can navigate back
//            transaction.replace(R.id.register_fragment_container, fragment);
//            transaction.addToBackStack(null);
//
//            // Commit the transaction
//            transaction.commit();
//        }
//
//        ImageView dot = (ImageView) findViewById(R.id.progress_dot1);
//        dot.setColorFilter(ContextCompat.getColor(this, R.color.primary_light), PorterDuff.Mode.SRC_IN);
//
//        dot = (ImageView) findViewById(R.id.progress_dot2);
//        dot.setColorFilter(ContextCompat.getColor(this, R.color.secondary_text), PorterDuff.Mode.SRC_IN);
//
//        Button btn = (Button) findViewById(R.id.progress_next);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showRegisterTagsForm();
//            }
//        });
//
////        btn = (Button) findViewById(R.id.progress_back);
////        btn.setVisibility(View.INVISIBLE);
////        btn.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                showRegisterRoleForm();
////            }
////        });
//    }

    public void showRegisterTagsForm() {
        if (findViewById(R.id.register_fragment_container) != null) {
            // Create a new Fragment to be placed in the activity layout
            RegisterTagsFragment fragment = new RegisterTagsFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.setCustomAnimations(R.anim.slide_enter, R.anim.slide_exit, R.anim.slide_enter_back, R.anim.slide_exit_back);

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.register_fragment_container, fragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }

        ImageView dot = (ImageView) findViewById(R.id.progress_dot1);
        dot.setColorFilter(ContextCompat.getColor(this, R.color.secondary_text), PorterDuff.Mode.SRC_IN);

        dot = (ImageView) findViewById(R.id.progress_dot2);
        dot.setColorFilter(ContextCompat.getColor(this, R.color.primary_light), PorterDuff.Mode.SRC_IN);

        Button btn = (Button) findViewById(R.id.progress_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterSummary();
            }
        });

//        btn = (Button) findViewById(R.id.progress_back);
//        btn.setVisibility(View.VISIBLE);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showRegisterRoleForm();
//            }
//        });

        currentFragment = 1;
    }

    public void showRegisterSummary() {
        if (findViewById(R.id.register_fragment_container) != null) {
            // Create a new Fragment to be placed in the activity layout
            RegisterSummaryFragment fragment = new RegisterSummaryFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.setCustomAnimations(R.anim.slide_enter, R.anim.slide_exit, R.anim.slide_enter_back, R.anim.slide_exit_back);

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.register_fragment_container, fragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }

        ImageView dot = (ImageView) findViewById(R.id.progress_dot2);
        dot.setColorFilter(ContextCompat.getColor(this, R.color.secondary_text), PorterDuff.Mode.SRC_IN);

        dot = (ImageView) findViewById(R.id.progress_dot3);
        dot.setColorFilter(ContextCompat.getColor(this, R.color.primary_light), PorterDuff.Mode.SRC_IN);

        Button btn = (Button) findViewById(R.id.progress_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        currentFragment = 2;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (currentFragment == 1)
        {
            ImageView dot = (ImageView) findViewById(R.id.progress_dot1);
            dot.setColorFilter(ContextCompat.getColor(this, R.color.primary_light), PorterDuff.Mode.SRC_IN);

            dot = (ImageView) findViewById(R.id.progress_dot2);
            dot.setColorFilter(ContextCompat.getColor(this, R.color.secondary_text), PorterDuff.Mode.SRC_IN);

            Button btn = (Button) findViewById(R.id.progress_next);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   showRegisterTagsForm();
                }
            });

            currentFragment = 0;
        }
        else if (currentFragment == 2)
        {
            ImageView dot = (ImageView) findViewById(R.id.progress_dot2);
            dot.setColorFilter(ContextCompat.getColor(this, R.color.primary_light), PorterDuff.Mode.SRC_IN);

            dot = (ImageView) findViewById(R.id.progress_dot3);
            dot.setColorFilter(ContextCompat.getColor(this, R.color.secondary_text), PorterDuff.Mode.SRC_IN);

            Button btn = (Button) findViewById(R.id.progress_next);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showRegisterSummary();
                }
            });

            currentFragment = 1;
        }
    }
}
