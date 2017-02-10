package com.eng.iso.sharipova.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.eng.iso.sharipova.Entity.Lesson;
import com.eng.iso.sharipova.Fragments.ExersiceFragment;
import com.eng.iso.sharipova.MainActivity;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.AnimUtil;
import com.eng.iso.sharipova.Utils.ExersiceTypes;
import com.eng.iso.sharipova.Utils.StringUtils;

import java.util.ArrayList;

/**
 * Created by developer on 11.02.2017.
 */

public class LessonListAdapter extends RecyclerView.Adapter<LessonListAdapter.ViewHolder> {
    ArrayList<Lesson> lessons;
    Context context;
    public LessonListAdapter(ArrayList<Lesson> lessons,Context context){
        this.lessons = lessons;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Lesson lesson = lessons.get(position);
        holder.tvHeader.setText(lesson.getHeaderText());
        holder.tvText.setText(lesson.getContentText());
        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimUtil.buttonClickCustomAnimation(0.98f,holder.mainView, new AnimUtil.AfterAnimationEnd() {
                    @Override
                    public void onAnimoationEnd() {
                        ExersiceFragment fragment = new ExersiceFragment();
                        Bundle bundle =new Bundle();
                        bundle.putInt(ExersiceTypes.EXERSICE_TYPE,position);
                        fragment.setArguments(bundle);
                        ((MainActivity) context).getSupportFragmentManager().beginTransaction().add(R.id.mainFragment, fragment).addToBackStack(null).commit();
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return lessons.size();
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