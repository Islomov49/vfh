package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseFillTextWords;
import com.eng.iso.sharipova.Entity.ExerciseJumpled;
import com.eng.iso.sharipova.Entity.IntervalsTwoPair;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;
import com.eng.iso.sharipova.Utils.StringUtils;
import com.eng.iso.sharipova.Utils.TextUtils;

import java.util.ArrayList;

public class JumpedKeyFragment extends Fragment {
    int keyID[]={R.id.firstkeys,R.id.secondKey,R.id.thirtKey,R.id.fourKey,R.id.fiveKey};
    int textID[]={R.id.firstFill,R.id.secondFill,R.id.thirtFill,R.id.fourFill,R.id.fiveFill};
    TextView firstToFill,secondToFill,thirtToFill,fourToFill,fiveToFill;
    TextView firstToKey,secondToKey,thirtToKey,fourToKey,fiveToKey;
    ArrayList<String> firstWords[];
    String wordTemplete[];
    String forkeys[];
    TextView tvCondition;
    ExerciseJumpled exerciseJumpled;
    ArrayList<Exercise> exercises;

   ArrayList<IntervalsTwoPair> intervalsTwoPairsFirst,intervalsTwoPairsSecond,intervalsTwoPairsThirt,intervalsTwoPairsFour,intervalsTwoPairsFive;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jumped_key, container, false);
        tvCondition = (TextView) view.findViewById(R.id.tvContition);

        firstToFill = (TextView) view.findViewById(textID[0]);
        secondToFill = (TextView) view.findViewById(textID[1]);
        thirtToFill = (TextView) view.findViewById(textID[2]);
        fourToFill = (TextView) view.findViewById(textID[3]);
        fiveToFill = (TextView) view.findViewById(textID[4]);

        firstToKey = (TextView) view.findViewById(keyID[0]);
        secondToKey = (TextView) view.findViewById(keyID[1]);
        thirtToKey = (TextView) view.findViewById(keyID[2]);
        fourToKey = (TextView) view.findViewById(keyID[3]);
        fiveToKey = (TextView) view.findViewById(keyID[4]);

        if (getArguments() != null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exerciseJumpled = (ExerciseJumpled) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
        }


        intervalsTwoPairsFirst = new ArrayList<>();
        intervalsTwoPairsSecond = new ArrayList<>();
        intervalsTwoPairsThirt = new ArrayList<>();
        intervalsTwoPairsFour = new ArrayList<>();
        intervalsTwoPairsFive = new ArrayList<>();
        firstWords = new ArrayList[5];
        firstWords[0] = StringUtils.spillter(exerciseJumpled.getJumpleds().get(0),",");
        firstWords[1] = StringUtils.spillter(exerciseJumpled.getJumpleds().get(1),",");
        firstWords[2] = StringUtils.spillter(exerciseJumpled.getJumpleds().get(2),",");
        firstWords[3] = StringUtils.spillter(exerciseJumpled.getJumpleds().get(3),",");
        firstWords[4] = StringUtils.spillter(exerciseJumpled.getJumpleds().get(4),",");

        firstToKey.setText("(select words)");
        secondToKey.setText("(select words)");
        thirtToKey.setText("(select words)");
        fourToKey.setText("(select words)");
        fiveToKey.setText("(select words)");

        forkeys = new String[5] ;
         wordTemplete = new String[5] ;
        forkeys[0] = "";
        forkeys[1] = "";
        forkeys[2] = "";
        forkeys[3] = "";
        forkeys[4] = "";
        wordTemplete[0] = "";
        wordTemplete[1] = "";
        wordTemplete[2] = "";
        wordTemplete[3] = "";
        wordTemplete[4] = "";

        tvCondition.setText(exerciseJumpled.getCondition());
        for (int i = 0;i<exerciseJumpled.getJumpleds().size();i++){
            for(String s:firstWords[i]){
                if(!s.equals("")){
                    int start = wordTemplete[i].length();
                    wordTemplete [i] = wordTemplete[i]+s + ", ";
                    IntervalsTwoPair intervalsTwoPair = new IntervalsTwoPair(wordTemplete[i].indexOf(s,start),wordTemplete[i].indexOf(s,start)+s.length());
                    switch (i){
                        case 0: intervalsTwoPairsFirst.add(intervalsTwoPair);
                            break;
                        case 1: intervalsTwoPairsSecond.add(intervalsTwoPair);
                            break;
                        case 2: intervalsTwoPairsThirt.add(intervalsTwoPair);
                            break;
                        case 3: intervalsTwoPairsFour.add(intervalsTwoPair);
                            break;
                        case 4: intervalsTwoPairsFive.add(intervalsTwoPair);
                            break;
                    }
                }
            }
        }


        TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairsFirst,wordTemplete[0],firstToFill,getContext());
        TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairsSecond,wordTemplete[1],secondToFill,getContext());
        TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairsThirt,wordTemplete[2],thirtToFill,getContext());
        TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairsFour,wordTemplete[3],fourToFill,getContext());
        TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairsFive,wordTemplete[4],fiveToFill,getContext());

        firstToFill.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    int i = firstToFill.getOffsetForPosition(event.getX(),event.getY());

                    for(final IntervalsTwoPair intervalsTwoPair1:intervalsTwoPairsFirst){
                        if(intervalsTwoPair1.getStartPosition()<=i&&intervalsTwoPair1.getEndPosition()>=i){
                            if (intervalsTwoPair1.getWord().equals("")){
                                forkeys[0] = forkeys[0] + " "+wordTemplete[0].substring(intervalsTwoPair1.getStartPosition(),intervalsTwoPair1.getEndPosition());
                                firstToKey.setText(forkeys[0]);
                                intervalsTwoPair1.setWord(" "+wordTemplete[0].substring(intervalsTwoPair1.getStartPosition(),intervalsTwoPair1.getEndPosition()));
                            }
                            else {
                                forkeys[0] = forkeys[0].substring(0,forkeys[0].indexOf(intervalsTwoPair1.getWord()))+forkeys[0].substring(forkeys[0].indexOf(intervalsTwoPair1.getWord())+intervalsTwoPair1.getWord().length(),forkeys[0].length());
                                firstToKey.setText(forkeys[0]);
                                intervalsTwoPair1.setWord("");
                            }
                            TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairsFirst,wordTemplete[0],firstToFill,getContext());
                        }
                    }

                }

                return true;
            }
        });

        secondToFill.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    int i = secondToFill.getOffsetForPosition(event.getX(),event.getY());

                    for(final IntervalsTwoPair intervalsTwoPair1:intervalsTwoPairsSecond){
                        if(intervalsTwoPair1.getStartPosition()<=i&&intervalsTwoPair1.getEndPosition()>=i){
                            if (intervalsTwoPair1.getWord().equals("")){
                                forkeys[1] = forkeys[1] + " "+wordTemplete[1].substring(intervalsTwoPair1.getStartPosition(),intervalsTwoPair1.getEndPosition());
                                secondToKey.setText(forkeys[1]);
                                intervalsTwoPair1.setWord(" "+wordTemplete[1].substring(intervalsTwoPair1.getStartPosition(),intervalsTwoPair1.getEndPosition()));
                            }
                            else {
                                forkeys[1] = forkeys[1].substring(0,forkeys[1].indexOf(intervalsTwoPair1.getWord()))+forkeys[1].substring(forkeys[1].indexOf(intervalsTwoPair1.getWord())+intervalsTwoPair1.getWord().length(),forkeys[1].length());
                                secondToKey.setText(forkeys[1]);
                                intervalsTwoPair1.setWord("");
                            }
                            TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairsSecond,wordTemplete[1],secondToFill,getContext());
                        }
                    }

                }

                return true;
            }
        });

        thirtToFill.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    int i = thirtToFill.getOffsetForPosition(event.getX(),event.getY());

                    for(final IntervalsTwoPair intervalsTwoPair1:intervalsTwoPairsThirt){
                        if(intervalsTwoPair1.getStartPosition()<=i&&intervalsTwoPair1.getEndPosition()>=i){
                            if (intervalsTwoPair1.getWord().equals("")){
                                forkeys[2] = forkeys[2] + " "+wordTemplete[2].substring(intervalsTwoPair1.getStartPosition(),intervalsTwoPair1.getEndPosition());
                                thirtToKey.setText(forkeys[2]);
                                intervalsTwoPair1.setWord(" "+wordTemplete[2].substring(intervalsTwoPair1.getStartPosition(),intervalsTwoPair1.getEndPosition()));
                            }
                            else {
                                forkeys[2] = forkeys[2].substring(0,forkeys[2].indexOf(intervalsTwoPair1.getWord()))+forkeys[2].substring(forkeys[2].indexOf(intervalsTwoPair1.getWord())+intervalsTwoPair1.getWord().length(),forkeys[2].length());
                                thirtToKey.setText(forkeys[2]);
                                intervalsTwoPair1.setWord("");
                            }
                            TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairsThirt,wordTemplete[2],thirtToFill,getContext());
                        }
                    }

                }

                return true;
            }
        });
        fourToFill.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    int i = fourToFill.getOffsetForPosition(event.getX(),event.getY());

                    for(final IntervalsTwoPair intervalsTwoPair1:intervalsTwoPairsFour){
                        if(intervalsTwoPair1.getStartPosition()<=i&&intervalsTwoPair1.getEndPosition()>=i){
                            if (intervalsTwoPair1.getWord().equals("")){
                                forkeys[3] = forkeys[3] + " "+wordTemplete[3].substring(intervalsTwoPair1.getStartPosition(),intervalsTwoPair1.getEndPosition());
                                fourToKey.setText(forkeys[3]);
                                intervalsTwoPair1.setWord(" "+wordTemplete[3].substring(intervalsTwoPair1.getStartPosition(),intervalsTwoPair1.getEndPosition()));
                            }
                            else {
                                forkeys[3] = forkeys[3].substring(0,forkeys[3].indexOf(intervalsTwoPair1.getWord()))+forkeys[3].substring(forkeys[3].indexOf(intervalsTwoPair1.getWord())+intervalsTwoPair1.getWord().length(),forkeys[3].length());
                                fourToKey.setText(forkeys[3]);
                                intervalsTwoPair1.setWord("");
                            }
                            TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairsFour,wordTemplete[3],fourToFill,getContext());
                        }
                    }

                }

                return true;
            }
        });
        fiveToFill.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    int i = fiveToFill.getOffsetForPosition(event.getX(),event.getY());

                    for(final IntervalsTwoPair intervalsTwoPair1:intervalsTwoPairsFive){
                        if(intervalsTwoPair1.getStartPosition()<=i&&intervalsTwoPair1.getEndPosition()>=i){
                            if (intervalsTwoPair1.getWord().equals("")){
                                forkeys[4] = forkeys[4] + " "+wordTemplete[4].substring(intervalsTwoPair1.getStartPosition(),intervalsTwoPair1.getEndPosition());
                                fiveToKey.setText(forkeys[4]);
                                intervalsTwoPair1.setWord(" "+wordTemplete[4].substring(intervalsTwoPair1.getStartPosition(),intervalsTwoPair1.getEndPosition()));
                            }
                            else {
                                forkeys[4] = forkeys[4].substring(0,forkeys[4].indexOf(intervalsTwoPair1.getWord()))+forkeys[4].substring(forkeys[4].indexOf(intervalsTwoPair1.getWord())+intervalsTwoPair1.getWord().length(),forkeys[4].length());
                                fiveToKey.setText(forkeys[4]);
                                intervalsTwoPair1.setWord("");
                            }
                            TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairsFive,wordTemplete[4],fiveToFill,getContext());
                        }
                    }

                }

                return true;
            }
        });
        return view;

    }

}
