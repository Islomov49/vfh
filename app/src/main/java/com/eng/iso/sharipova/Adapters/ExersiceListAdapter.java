package com.eng.iso.sharipova.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Fragments.ExerciseTabLayout;
import com.eng.iso.sharipova.MainActivity;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.AnimUtil;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

/**
 * Created by developer on 11.02.2017.
 */

public class ExersiceListAdapter extends RecyclerView.Adapter<ExersiceListAdapter.ViewHolder> {
    ArrayList<Exercise> exercises;
    Context context;
    int lessonNumber = 0;
    public ExersiceListAdapter(ArrayList<Exercise> exercises, Context context, int lessonNumber){
        this.exercises = exercises;
        this.context = context;
        this.lessonNumber = lessonNumber;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Exercise exercise = exercises.get(position);
        holder.tvHeader.setText(exercise.getExNumber());
        holder.tvText.setText(exercise.getCondition());
        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimUtil.buttonClickCustomAnimation(0.98f,holder.mainView, new AnimUtil.AfterAnimationEnd() {
                    @Override
                    public void onAnimoationEnd() {
                        ExerciseTabLayout fragment = new ExerciseTabLayout();
                        Bundle bundle = new Bundle();
                        bundle.putInt("COUNT_KEY",position);
                        bundle.putInt(ExerciseTypes.LESSON_NUMBER,lessonNumber);
                        fragment.setArguments(bundle);
                        ((MainActivity) context).getSupportFragmentManager().beginTransaction().add(R.id.mainFragment, fragment).addToBackStack(null).commit();
//                        Toast.makeText(context, exercises.get(position).toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeader;
        TextView tvText;
        View mainView;
    public ViewHolder(View v) {
      super(v);
        mainView = v;
        tvHeader = (TextView) v.findViewById(R.id.tvHeader);
        tvText = (TextView) v.findViewById(R.id.tvText);
    }
  }

}
