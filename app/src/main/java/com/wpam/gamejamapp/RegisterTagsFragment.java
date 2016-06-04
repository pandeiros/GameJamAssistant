package com.wpam.gamejamapp;


import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.apmem.tools.layouts.FlowLayout;

import java.util.Arrays;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterTagsFragment extends Fragment {

    private int backgroundColorSelected;
    private int textColorSelected;
    private int textColorNormal;
    private int animationTime = 200;

    CategoryTag categories[];

    public RegisterTagsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // specify an adapter
        categories = new CategoryTag[]{
                new CategoryTag(CategoryTag.Category.PROGRAMMING, "C++"),
                new CategoryTag(CategoryTag.Category.DESIGN, "Level design"),
                new CategoryTag(CategoryTag.Category.GRAPHICS, "3D Graphics")
        };

        Collections.shuffle(Arrays.asList(categories));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_tags, container, false);

        backgroundColorSelected = ContextCompat.getColor(view.getContext(), R.color.primary_dark);
        textColorNormal = ContextCompat.getColor(view.getContext(), R.color.primary_text);
        textColorSelected = ContextCompat.getColor(view.getContext(), R.color.primary_text_light);

        addTags(view, inflater);

//        (EditText) view.findViewById()

        return view;
    }

    private void addTags(View v, LayoutInflater inflater) {

        for (int i = 0; i < categories.length; i++) {

            FlowLayout layout = (FlowLayout) v.findViewById(R.id.flow_layout_tags);
            inflater.inflate(R.layout.button_tag, layout);

            Button btn = (Button)layout.getChildAt(i);
            btn.setText(categories[i].getName());
            btn.setTag(i);
            btn.setBackgroundColor(ContextCompat.getColor(v.getContext(), categories[i].getColor()));

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int)v.getTag();
                    Button btn = (Button)v;
                    ColorDrawable[] backgroundAnim;
                    ObjectAnimator textAnim;

                    if (categories[tag].isSelected())
                    {
                        textAnim = ObjectAnimator.ofInt(btn, "textColor", textColorNormal);
                        backgroundAnim = new ColorDrawable[] {
                                new ColorDrawable(backgroundColorSelected),
                                new ColorDrawable(ContextCompat.getColor(v.getContext(), categories[tag].getColor()))};
                    }
                    else
                    {
                        textAnim = ObjectAnimator.ofInt(btn, "textColor", textColorSelected);
                        backgroundAnim = new ColorDrawable[] {
                                new ColorDrawable(ContextCompat.getColor(v.getContext(), categories[tag].getColor())),
                                new ColorDrawable(ContextCompat.getColor(v.getContext(), R.color.primary_dark))};
                    }

                    TransitionDrawable backgroundTrans = new TransitionDrawable(backgroundAnim);
                    btn.setBackground(backgroundTrans);
                    backgroundTrans.startTransition(animationTime);

                    textAnim.setDuration(animationTime);
                    textAnim.setEvaluator(new ArgbEvaluator());
                    textAnim.start();

                    categories[tag].setIsSelected(!categories[tag].isSelected());
                }
            });
        }
    }
}
