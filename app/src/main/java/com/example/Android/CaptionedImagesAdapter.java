package com.example.Android;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;



public class CaptionedImagesAdapter
        extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{



    private String[] captions;
    private int[] imageIds;
    private int[] pricearr;
    private String[] ratingarr;

    public CaptionedImagesAdapter(String[] captions, int[] imageIds, int[] pricearr, String[] ratingarr) {
        this.captions = captions;
        this.imageIds = imageIds;
        this.pricearr = pricearr;
        this.ratingarr = ratingarr;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_image, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);

        imageView.setImageDrawable(dr);

        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText(captions[position]);
        TextView price = (TextView)cardView.findViewById(R.id.txtPrice);
        price.setText("Price: "+pricearr[position]);
        TextView rating = (TextView)cardView.findViewById(R.id.txtRating);
        rating.setText(ratingarr[position]);
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(),
                        MainActivity2.class);


                intent.putExtra("item_id", position);
                v.getContext().startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }


}
