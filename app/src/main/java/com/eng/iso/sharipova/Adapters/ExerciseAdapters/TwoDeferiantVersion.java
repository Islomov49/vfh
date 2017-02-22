package com.eng.iso.sharipova.Adapters.ExerciseAdapters;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.EditTextState;

import java.util.ArrayList;

/**
 * Created by developer on 19.02.2017.
 */

public class TwoDeferiantVersion extends  RecyclerView.Adapter<TwoDeferiantVersion.ViewHolder> {
    ArrayList<String> strings;
    int lessonNumber ;
    int count;
    boolean perviy [];
    String firstKey;
    String secondKey;

    public TwoDeferiantVersion(ArrayList<String> strings, int lessonNumber, int count,String firstKey,String secondKey){
        this.strings = strings;
        this.lessonNumber= lessonNumber;
        this.count = count;
        this.firstKey = firstKey;
        this.secondKey = secondKey;
        perviy = new boolean[strings.size()];
        for(int i = 0;i<strings.size();i++){
            perviy[i] =true;
        }
    }
    @Override
    public TwoDeferiantVersion.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.two_deferent_adapter, parent, false);
        return new TwoDeferiantVersion.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TwoDeferiantVersion.ViewHolder holder, final int position) {
        holder.tvFirstTip.setText(firstKey);
        holder.tvSecondTip.setText(secondKey);
        if(perviy[position]){
            holder.tvFirstTip.setTextColor(Color.parseColor("#4ca66a"));
            holder.tvSecondTip.setTextColor(Color.parseColor("#a7a7a7"));
        }
        else {
            holder.tvFirstTip.setTextColor(Color.parseColor("#a7a7a7"));
            holder.tvSecondTip.setTextColor(Color.parseColor("#4ca66a"));
        }
        holder.tvWord.setText(strings.get(position));
        holder.tvFirstTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perviy[position] = true;
                notifyItemChanged(position);
            }
        });
        holder.tvSecondTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perviy[position] = false;
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvWord;
        TextView tvFirstTip;
        TextView tvSecondTip;
        public ViewHolder(View v) {
            super(v);
            tvWord = (TextView) v.findViewById(R.id.word);
            tvFirstTip = (TextView) v.findViewById(R.id.firstWord);
            tvSecondTip = (TextView) v.findViewById(R.id.secondWord);
        }
    }
}
