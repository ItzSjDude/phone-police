package com.geekofia.phonepolice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geekofia.phonepolice.models.CardItem;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private final Context context;
    private final List<CardItem> cardItemList;

    public CardAdapter(Context context, List<CardItem> cardItemList) {
        this.context = context;
        this.cardItemList = cardItemList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem cardItem = cardItemList.get(position);
        holder.cardTitle.setText(cardItem.getTitle());
        holder.cardIcon.setImageResource(cardItem.getImageResId());

        holder.cardView.setOnClickListener(v -> {
            // Handle card click here
        });
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {

        MaterialCardView cardView;
        ImageView cardIcon;
        TextView cardTitle;
        TextView cardDescription;

        CardViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            cardIcon = itemView.findViewById(R.id.card_icon);
            cardTitle = itemView.findViewById(R.id.card_title);
            cardDescription = itemView.findViewById(R.id.card_description);
        }
    }
}
