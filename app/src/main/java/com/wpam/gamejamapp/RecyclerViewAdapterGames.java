package com.wpam.gamejamapp;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wpam.gamejamapp.model.Game;

public class RecyclerViewAdapterGames extends RecyclerView.Adapter<RecyclerViewAdapterGames.ViewHolder> {
    private Game[] mDataset;
    private CardView selectedCardView;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public CardView mCardView;

        public ViewHolder(CardView v) {
            super(v);
            mCardView = v;

            mCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View view) {
            Log.e("ANIM", "LOL");

//            Boolean selected = super
//            ValueAnimator anim = ValueAnimator.ofInt(view.getMeasuredHeightAndState(),
//                    view.getMeasuredHeightAndState() * 2);
//            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                    int val = (Integer) valueAnimator.getAnimatedValue();
//                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//                    layoutParams.height = val;
//                    view.setLayoutParams(layoutParams);
//                }
//            });
//            anim.start();
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerViewAdapterGames(Game[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapterGames.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_game, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder((CardView) v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that etlement
        TextView title = (TextView) holder.mCardView.findViewById(R.id.card_game_title);
        title.setText(mDataset[position].getName());

        TextView subtitle = (TextView) holder.mCardView.findViewById(R.id.card_game_subtitle);
        subtitle.setText(mDataset[position].getTeam().getName());

        Bitmap myBitmap;
        if (position % 2 == 0)
            myBitmap = BitmapFactory.decodeResource(holder.mCardView.getResources(), R.drawable.rl);
        else
            myBitmap = BitmapFactory.decodeResource(holder.mCardView.getResources(), R.drawable.rl);

        if (myBitmap != null && !myBitmap.isRecycled()) {

            ImageView image = (ImageView) holder.mCardView.findViewById(R.id.card_game_image);
            image.setImageBitmap(myBitmap);

            final Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
                public void onGenerated(Palette palette) {

                    int def = 0x000000;
                    int color = palette.getLightVibrantColor(def);
                    holder.mCardView.setCardBackgroundColor(color);
                }
            };

            Palette.from(myBitmap).generate(paletteListener);
        }

        holder.mCardView.setTag(position);
        mDataset[position].setHeight(holder.mCardView.getMinimumHeight());
//            holder.mCardView

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final CardView card = (CardView) v.findViewById(R.id.card_game);
                int pos = (int) card.getTag();
                Boolean selected = mDataset[pos].isSelected();

                if (selected) {
                    collapseCard(card);
                } else {
                    if (selectedCardView != null) {
                        int tag = (int)selectedCardView.getTag();
                        if (mDataset[tag].isSelected()) {
                            collapseCard(selectedCardView);
                            mDataset[tag].setIsSelected(false);
                        }
                    }
                    expandCard(card);
                    selectedCardView = card;
                }

                mDataset[pos].setIsSelected(!mDataset[pos].isSelected());
            }
        });
    }

    // Return the size of your dataset (invoked by he layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    private void expandCard(final CardView card) {
        int pos = (int) card.getTag();
        int height = mDataset[pos].getHeight() * 3;

        ValueAnimator anim = ValueAnimator.ofInt(card.getMeasuredHeightAndState(),
                height);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = card.getLayoutParams();
                layoutParams.height = val;
                card.setLayoutParams(layoutParams);
            }
        });
        anim.start();

        final LinearLayout extras = (LinearLayout) card.findViewById(R.id.card_game_extras);
        extras.setVisibility(View.VISIBLE);

        AlphaAnimation animation1;
        animation1 = new AlphaAnimation(0.0f, 1.0f);
        extras.setVisibility(View.VISIBLE);
        animation1.setDuration(300);
        animation1.setFillAfter(true);

        extras.startAnimation(animation1);
    }

    private void collapseCard(final CardView card) {
        int pos = (int) card.getTag();
        int height = mDataset[pos].getHeight();

        ValueAnimator anim = ValueAnimator.ofInt(card.getMeasuredHeightAndState(),
                height);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = card.getLayoutParams();
                layoutParams.height = val;
                card.setLayoutParams(layoutParams);
            }
        });
        anim.start();

        final LinearLayout extras = (LinearLayout) card.findViewById(R.id.card_game_extras);

        AlphaAnimation animation1;
        animation1 = new AlphaAnimation(1.f, 0.f);
        animation1.setDuration(300);
        animation1.setFillAfter(true);

        extras.startAnimation(animation1);
    }
}