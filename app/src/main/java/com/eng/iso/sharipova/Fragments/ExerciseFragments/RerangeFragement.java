package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseFillTextWords;
import com.eng.iso.sharipova.Entity.ExerciseRearrange;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

public class RerangeFragement extends Fragment {
    ExerciseRearrange exerciseRearrange;
    ArrayList<Exercise> exercises;
    int firstWordTop []= {R.id.q,R.id.w,R.id.e,R.id.r,R.id.t,R.id.y,R.id.u,R.id.i,R.id.o};
    int firstWordBottom []= {R.id.qq,R.id.ww,R.id.ee,R.id.rr,R.id.tt,R.id.yy,R.id.uu,R.id.ii,R.id.oo};
    int firstChars [] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    int secondWordTop []= {R.id.a,R.id.s,R.id.d,R.id.f,R.id.g};
    int secondWordBottom []= {R.id.aa,R.id.ss,R.id.dd,R.id.ff,R.id.gg};
    int secondChars [] = {-1,-1,-1,-1,-1};

    int thirtWordTop []= {R.id.h,R.id.j,R.id.k,R.id.l};
    int thirtWordBottom []= {R.id.hh,R.id.jj,R.id.kk,R.id.ll};
    int thirtChars [] = {-1,-1,-1,-1};

    int fourWordTop []= {R.id.z,R.id.x,R.id.c,R.id.v,R.id.b,R.id.n,R.id.m};
    int fourWordBottom []= {R.id.zz,R.id.xx,R.id.cc,R.id.vv,R.id.bb,R.id.nn,R.id.mm};
    int fourChars [] = {-1,-1,-1,-1,-1,-1,-1};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_rerange_fragement, container, false);
        if (getArguments() != null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exerciseRearrange = (ExerciseRearrange) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
        }
        ((TextView) view.findViewById(R.id.tvContition)).setText(exerciseRearrange.getCondition());
        for (final int buttonID:firstWordBottom){
            view.findViewById(buttonID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 0;i<firstChars.length;i++ ){
                        if(firstChars[i]==-1){
                            ((TextView)view.findViewById(firstWordTop[i])).setText(((TextView)view.findViewById(buttonID)).getText());
                            firstChars[i]= buttonID;
                            view.findViewById(buttonID).setVisibility(View.INVISIBLE);
                            break;
                        }
                    }
                }
            });
        }
        for(final int topID: firstWordTop){
            view.findViewById(topID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int j =-1;
                    for(int q= 0;q<firstWordTop.length;q++){
                        if(topID == firstWordTop[q]){
                            j=q;
                            break;
                        }
                    }
                    if(j==-1) return;
                    int toBack= firstChars[j];
                    if(toBack==-1) return;

                    view.findViewById(toBack).setVisibility(View.VISIBLE);
                    ((TextView)view.findViewById(topID)).setText("");
                    firstChars[j]= -1;
                }
            });
        }

        for (final int buttonID:secondWordBottom){
            view.findViewById(buttonID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 0;i<secondChars.length;i++ ){
                        if(secondChars[i]==-1){
                            ((TextView)view.findViewById(secondWordTop[i])).setText(((TextView)view.findViewById(buttonID)).getText());
                            secondChars[i]= buttonID;
                            view.findViewById(buttonID).setVisibility(View.INVISIBLE);
                            break;
                        }
                    }
                }
            });
        }
        for(final int topID: secondWordTop){
            view.findViewById(topID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int j =-1;
                    for(int q= 0;q<secondWordTop.length;q++){
                        if(topID == secondWordTop[q]){
                            j=q;
                            break;
                        }
                    }
                    if(j==-1) return;
                    int toBack= secondChars[j];
                    if(toBack==-1) return;

                    view.findViewById(toBack).setVisibility(View.VISIBLE);
                    ((TextView)view.findViewById(topID)).setText("");
                    secondChars[j]= -1;
                }
            });
        }


        for (final int buttonID:thirtWordBottom){
            view.findViewById(buttonID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 0;i<thirtChars.length;i++ ){
                        if(thirtChars[i]==-1){
                            ((TextView)view.findViewById(thirtWordTop[i])).setText(((TextView)view.findViewById(buttonID)).getText());
                            thirtChars[i]= buttonID;
                            view.findViewById(buttonID).setVisibility(View.INVISIBLE);
                            break;
                        }
                    }
                }
            });
        }
        for(final int topID: thirtWordTop){
            view.findViewById(topID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int j =-1;
                    for(int q= 0;q<thirtWordTop.length;q++){
                        if(topID == thirtWordTop[q]){
                            j=q;
                            break;
                        }
                    }
                    if(j==-1) return;
                    int toBack= thirtChars[j];
                    if(toBack==-1) return;

                    view.findViewById(toBack).setVisibility(View.VISIBLE);
                    ((TextView)view.findViewById(topID)).setText("");
                    thirtChars[j]= -1;
                }
            });
        }

        for (final int buttonID:fourWordBottom){
            view.findViewById(buttonID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 0;i<fourChars.length;i++ ){
                        if(fourChars[i]==-1){
                            ((TextView)view.findViewById(fourWordTop[i])).setText(((TextView)view.findViewById(buttonID)).getText());
                            fourChars[i]= buttonID;
                            view.findViewById(buttonID).setVisibility(View.INVISIBLE);
                            break;
                        }
                    }
                }
            });
        }
        for(final int topID: fourWordTop){
            view.findViewById(topID).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int j =-1;
                    for(int q= 0;q<fourWordTop.length;q++){
                        if(topID == fourWordTop[q]){
                            j=q;
                            break;
                        }
                    }
                    if(j==-1) return;
                    int toBack= fourChars[j];
                    if(toBack==-1) return;

                    view.findViewById(toBack).setVisibility(View.VISIBLE);
                    ((TextView)view.findViewById(topID)).setText("");
                    fourChars[j]= -1;
                }
            });
        }

        return view;
    }


}
