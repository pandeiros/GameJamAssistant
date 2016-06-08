package com.wpam.gamejamapp;


import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wpam.gamejamapp.model.Role;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterRoleFragment extends Fragment {

    int backgroundColorSelected;
    int textColorSelected;
    int textColorNormal;
    private int animationTime = 200;
    CardView selectedCardView;

    Role roles[];

    public RegisterRoleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // specify an adapter
        roles = new Role[]{
                new Role(Role.RoleType.CODE),
                new Role(Role.RoleType.GRAPHICS),
                new Role(Role.RoleType.SOUND),
                new Role(Role.RoleType.STORY)
        };
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_role, container, false);

        backgroundColorSelected = ContextCompat.getColor(view.getContext(), R.color.primary_dark);
        textColorNormal = ContextCompat.getColor(view.getContext(), R.color.primary_text);
        textColorSelected = ContextCompat.getColor(view.getContext(), R.color.primary_text_light);

        addRoles(view, inflater);


        return view;
    }

    private void addRoles(View v, LayoutInflater inflater) {

        for (int i = 0; i < roles.length; i++) {

            LinearLayout layout = (LinearLayout) v.findViewById(R.id.grid_register_role);
            inflater.inflate(R.layout.card_register_role, layout);


            CardView card = (CardView) layout.getChildAt(i);
            card.setBackgroundColor(ContextCompat.getColor(v.getContext(), roles[i].getColor()));
            card.setTag(i);

            TextView title = (TextView) card.findViewById(R.id.card_role_title);
            title.setText(roles[i].getTitle());

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) v.getTag();
                    CardView card = (CardView) v;
                    ColorDrawable[] backgroundAnim;
                    ObjectAnimator textAnim;
                    TextView title = (TextView) card.findViewById(R.id.card_role_title);

                    if (roles[tag].isSelected()) {
                        textAnim = ObjectAnimator.ofInt(title, "textColor", textColorNormal);
                        backgroundAnim = new ColorDrawable[]{
                                new ColorDrawable(backgroundColorSelected),
                                new ColorDrawable(ContextCompat.getColor(v.getContext(), roles[tag].getColor()))};

                        selectedCardView = null;
                    } else {
                        if (selectedCardView != null) {
                            int selectedTag = (int) selectedCardView.getTag();
                            roles[selectedTag].setIsSelected(false);

                            TextView selectedTitle = (TextView) selectedCardView.findViewById(R.id.card_role_title);
                            textAnim = ObjectAnimator.ofInt(selectedTitle, "textColor", textColorNormal);
                            backgroundAnim = new ColorDrawable[]{
                                    new ColorDrawable(backgroundColorSelected),
                                    new ColorDrawable(ContextCompat.getColor(v.getContext(), roles[selectedTag].getColor()))};

                            animate(selectedCardView, backgroundAnim, textAnim);
                        }

                        textAnim = ObjectAnimator.ofInt(title, "textColor", textColorSelected);
                        backgroundAnim = new ColorDrawable[]{
                                new ColorDrawable(ContextCompat.getColor(v.getContext(), roles[tag].getColor())),
                                new ColorDrawable(ContextCompat.getColor(v.getContext(), R.color.primary_dark))};

                        selectedCardView = card;
                    }

                    animate(card, backgroundAnim, textAnim);

                    roles[tag].setIsSelected(!roles[tag].isSelected());
                }
            });
        }

    }

    private void animate(View view, ColorDrawable[] trans, ObjectAnimator textAnim) {
        TransitionDrawable backgroundTrans = new TransitionDrawable(trans);
        view.setBackground(backgroundTrans);
        backgroundTrans.startTransition(animationTime);

        textAnim.setDuration(animationTime);
        textAnim.setEvaluator(new ArgbEvaluator());
        textAnim.start();
    }
}

