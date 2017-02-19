package com.eng.iso.sharipova.Adapters.ExerciseAdapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.EditTextState;

import java.util.ArrayList;

/**
 * Created by developer on 19.02.2017.
 */

public class ListenTextMatchAdapter extends  RecyclerView.Adapter<ListenTextMatchAdapter.ViewHolder> {
    ArrayList<String> strings;
    ArrayList<String> variants;
    Context context;
    int lessonNumber ;
    int count;
    public ListenTextMatchAdapter(ArrayList<String> strings, int lessonNumber, int count, ArrayList<String> variants, Context context){
        this.strings = strings;
        this.lessonNumber= lessonNumber;
        this.count = count;
        this.variants = variants;
        this.context= context;
    }
    @Override
    public ListenTextMatchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listen_adap, parent, false);
        return new ListenTextMatchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListenTextMatchAdapter.ViewHolder holder, final int position) {
        holder.tvHeader.setText(strings.get(position));
        holder.eTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(context);
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,variants);
                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((TextView)v).setText(variants.get(which));
                    }
                });
                builderSingle.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;
        TextView eTS;
        public ViewHolder(View v) {
            super(v);
            tvHeader = (TextView) v.findViewById(R.id.word);
            eTS = (TextView) v.findViewById(R.id.editSt);
        }
    }
}
