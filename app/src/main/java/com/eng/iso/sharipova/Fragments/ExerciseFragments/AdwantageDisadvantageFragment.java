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
import com.eng.iso.sharipova.Entity.ExerciseAdvantagesDisadvantegs;
import com.eng.iso.sharipova.Entity.ExerciseFillTextWords;
import com.eng.iso.sharipova.Entity.IntervalsTwoPair;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;
import com.eng.iso.sharipova.Utils.TextUtils;

import java.util.ArrayList;


public class AdwantageDisadvantageFragment extends Fragment {
    ExerciseAdvantagesDisadvantegs exerciseAdvantagesDisadvantegs;
    ArrayList<Exercise> exercises;
    String forFilling = "";
    ArrayList<IntervalsTwoPair> intervalsTwoPairs;

    TextView tvKeyWords;
    TextView fillText;
    TextView tvCondition;
    TextView firTitle;

    String forFilling2 = "";
    ArrayList<IntervalsTwoPair> intervalsTwoPairs2;

    TextView tvKeyWords2;
    TextView fillText2;
    TextView secTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adwantage_disadvantage, container, false);
        if (getArguments() != null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exerciseAdvantagesDisadvantegs = (ExerciseAdvantagesDisadvantegs) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
        }
        intervalsTwoPairs = new ArrayList<>();
        intervalsTwoPairs2 = new ArrayList<>();
        firTitle = (TextView) view.findViewById(R.id.firstTitle);
        secTitle = (TextView) view.findViewById(R.id.secondTitle);
        firTitle.setText(exerciseAdvantagesDisadvantegs.getAdvantageTitle());
        secTitle.setText(exerciseAdvantagesDisadvantegs.getDisadvantageTitle());

        tvKeyWords = (TextView) view.findViewById(R.id.textView);
        tvCondition = (TextView) view.findViewById(R.id.tvContition);
        fillText = (TextView) view.findViewById(R.id.fillText);
        String str = "";
        for (String word:exerciseAdvantagesDisadvantegs.getAdvantageKeyWords()){
            str  = str + word+ ", ";
        }
        tvKeyWords.setText(str);
        tvCondition.setText(exerciseAdvantagesDisadvantegs.getCondition());
        forFilling  = exerciseAdvantagesDisadvantegs.getAdvantageText();
        IntervalsTwoPair intervalsTwoPair = null;
        for(int i = 0;i<forFilling.length();i++){
            if(forFilling.charAt(i)=='_'){
                if (intervalsTwoPair == null)
                    intervalsTwoPair =  new IntervalsTwoPair(i,-1);

            }
            else if(intervalsTwoPair!=null){
                intervalsTwoPair.setEndPosition(i);
                intervalsTwoPairs.add(intervalsTwoPair);
                intervalsTwoPair = null;
            }
        }
        TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairs,forFilling,fillText,getContext());
        fillText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    int i = fillText.getOffsetForPosition(event.getX(),event.getY());

                    for(final IntervalsTwoPair intervalsTwoPair1:intervalsTwoPairs){
                        if(intervalsTwoPair1.getStartPosition()<=i&&intervalsTwoPair1.getEndPosition()>=i){
                            AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,exerciseAdvantagesDisadvantegs.getAdvantageKeyWords());
                            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String strName = exerciseAdvantagesDisadvantegs.getAdvantageKeyWords().get(which);
                                    int farq =intervalsTwoPair1.getStartPosition() + strName.length() -  intervalsTwoPair1.getEndPosition() ;
                                    if(farq !=0){
                                        for(int j = intervalsTwoPairs.indexOf(intervalsTwoPair1)+1;j<intervalsTwoPairs.size();j++){
                                            intervalsTwoPairs.get(j).setStartPosition(intervalsTwoPairs.get(j).getStartPosition()+farq);
                                            intervalsTwoPairs.get(j).setEndPosition(intervalsTwoPairs.get(j).getEndPosition()+farq);
                                        }
                                    }
                                    forFilling = forFilling.substring(0,intervalsTwoPair1.getStartPosition()) + strName +forFilling.substring(intervalsTwoPair1.getEndPosition(),forFilling.length());
                                    intervalsTwoPair1.setEndPosition(intervalsTwoPair1.getStartPosition() + strName.length());
                                    intervalsTwoPair1.setWord(strName);
                                    TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairs,forFilling,fillText,getContext());

                                }
                            });
                            builderSingle.show();
                        }
                    }

                }

                return true;
            }
        });




        tvKeyWords2 = (TextView) view.findViewById(R.id.textView2);
        fillText2 = (TextView) view.findViewById(R.id.fillText2);
        String str2 = "";
        for (String word:exerciseAdvantagesDisadvantegs.getDisadvantageKeyWords()){
            str2  = str2 + word+ ", ";
        }
        tvKeyWords2.setText(str2);
        forFilling2  = exerciseAdvantagesDisadvantegs.getDisadvantageText();
        IntervalsTwoPair intervalsTwoPair2 = null;
        for(int i = 0;i<forFilling2.length();i++){
            if(forFilling2.charAt(i)=='_'){
                if (intervalsTwoPair2 == null)
                    intervalsTwoPair2 =  new IntervalsTwoPair(i,-1);

            }
            else if(intervalsTwoPair2!=null){
                intervalsTwoPair2.setEndPosition(i);
                intervalsTwoPairs2.add(intervalsTwoPair2);
                intervalsTwoPair2 = null;
            }
        }
        TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairs2,forFilling2,fillText2,getContext());
        fillText2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    int i = fillText2.getOffsetForPosition(event.getX(),event.getY());

                    for(final IntervalsTwoPair intervalsTwoPair1:intervalsTwoPairs2){
                        if(intervalsTwoPair1.getStartPosition()<=i&&intervalsTwoPair1.getEndPosition()>=i){
                            AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, exerciseAdvantagesDisadvantegs.getDisadvantageKeyWords());
                            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String strName = exerciseAdvantagesDisadvantegs.getDisadvantageKeyWords().get(which);
                                    int farq =intervalsTwoPair1.getStartPosition() + strName.length() -  intervalsTwoPair1.getEndPosition() ;
                                    if(farq !=0){
                                        for(int j = intervalsTwoPairs2.indexOf(intervalsTwoPair1)+1;j<intervalsTwoPairs2.size();j++){
                                            intervalsTwoPairs2.get(j).setStartPosition(intervalsTwoPairs2.get(j).getStartPosition()+farq);
                                            intervalsTwoPairs2.get(j).setEndPosition(intervalsTwoPairs2.get(j).getEndPosition()+farq);
                                        }
                                    }
                                    forFilling2 = forFilling2.substring(0,intervalsTwoPair1.getStartPosition()) + strName +forFilling2.substring(intervalsTwoPair1.getEndPosition(),forFilling2.length());
                                    intervalsTwoPair1.setEndPosition(intervalsTwoPair1.getStartPosition() + strName.length());
                                    intervalsTwoPair1.setWord(strName);
                                    TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairs2,forFilling2,fillText2,getContext());

                                }
                            });
                            builderSingle.show();
                        }
                    }

                }

                return true;
            }
        });
        return view;
    }
}
