package com.eng.iso.sharipova.Adapters.ExerciseAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eng.iso.sharipova.Adapters.ExersiceListAdapter;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.EditTextState;

import java.util.ArrayList;

/**
 * Created by developer on 19.02.2017.
 */

public class SynonimAdapter extends  RecyclerView.Adapter<SynonimAdapter.ViewHolder> {
    ArrayList<String> strings;
    int lessonNumber ;
    int count;
    public SynonimAdapter (ArrayList<String> strings,int lessonNumber, int count){
        this.strings = strings;
        this.lessonNumber= lessonNumber;
        this.count = count;
    }
    @Override
    public SynonimAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.synonim_adapter, parent, false);
        return new SynonimAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SynonimAdapter.ViewHolder holder, int position) {
        holder.eTS.initStateLisner(lessonNumber,count,position);
        holder.tvHeader.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;
        EditTextState eTS;
        public ViewHolder(View v) {
            super(v);
            tvHeader = (TextView) v.findViewById(R.id.word);
            eTS = (EditTextState) v.findViewById(R.id.editSt);
        }
    }
}
