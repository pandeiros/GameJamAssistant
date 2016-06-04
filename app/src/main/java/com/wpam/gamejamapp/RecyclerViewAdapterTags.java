//package com.wpam.gamejamapp;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//
//public class RecyclerViewAdapterTags extends RecyclerView.Adapter<RecyclerViewAdapterTags.ViewHolder> {
////    private CategoryTag[] mDataset;
////
////    // Provide a reference to the views for each data item
////    // Complex data items may need more than one view per item, and
////    // you provide access to all the views for a data item in a view holder
////    public static class ViewHolder extends RecyclerView.ViewHolder {
////        // each data item is just a string in this case
////        public Button mButton;
////        public ViewHolder(Button btn) {
////            super(btn);
////            mButton = btn;
////        }
////    }
////
////    // Provide a suitable constructor (depends on the kind of dataset)
////    public RecyclerViewAdapterTags(CategoryTag[] myDataset) {
////        mDataset = myDataset;
////    }
////
////    // Create new views (invoked by the layout manager)
////    @Override
////    public RecyclerViewAdapterTags.ViewHolder onCreateViewHolder(ViewGroup parent,
////                                                                 int viewType) {
////        // create a new view
//////        View flow = parent.findViewById(R.id.flow_layout_tags);
////
////        View v = LayoutInflater.from(parent.getContext())
////                .inflate(R.layout.button_tag, parent, false);
////        // set the view's size, margins, paddings and layout parameters
////
////        ViewHolder vh = new ViewHolder((Button)v);
////        return vh;
////    }
////
////    // Replace the contents of a view (invoked by the layout manager)
////    @Override
////    public void onBindViewHolder(final ViewHolder holder, int position) {
////
////        holder.mButton.setText(mDataset[position].getName());
////        holder.mButton.setBackgroundColor(mDataset[position].getColor());
////
//////        Bitmap myBitmap;
//////        if (position % 2 == 0)
//////            myBitmap = BitmapFactory.decodeResource(holder.mCardView.getResources(), R.drawable.rl);
//////        else
//////            myBitmap = BitmapFactory.decodeResource(holder.mCardView.getResources(), R.drawable.rl);
//////
//////        if (myBitmap != null && !myBitmap.isRecycled()) {
//////
//////            ImageView image = (ImageView)holder.mCardView.findViewById(R.id.card_game_image);
//////            image.setImageBitmap(myBitmap);
////////            holder.mCardView
//////
//////            final Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
//////                public void onGenerated(Palette palette) {
//////
//////                    int def = 0x000000;
//////                    int color = palette.getLightVibrantColor(def);
//////                    holder.mCardView.setCardBackgroundColor(color);
//////                }
//////            };
//////
//////            Palette.from(myBitmap).generate(paletteListener);
//////        }
//////        holder.mCardView.setCardBackgroundColor(ContextCompat.getColor(holder.mCardView.getContext(), R.color.divider));
////    }
////
////
////
////    // Return the size of your dataset (invoked by he layout manager)
////    @Override
////    public int getItemCount() {
////        return mDataset.length;
////    }
//}