package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseAnswerQuestions;
import com.eng.iso.sharipova.Entity.ExercisePickPic;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

public class PickPicFragment extends Fragment {

    ImageView imageView;
    TextView tvCondition;
    int idLinearView [] = {R.id.firstBlock,R.id.secondBlock,R.id.thirtBlock,R.id.fourBlock,R.id.fiveBlock,R.id.sixBlock,R.id.sevenBlock,R.id.eightBlock,R.id.nineBlock,R.id.tenBlock,R.id.elevenBlock,R.id.twelveBlock,R.id.thirteenBlock,R.id.fourteenBlock,R.id.fiveteenBlock};
    int idTextView [] = {R.id.firstTv,R.id.secondTv,R.id.thirtTv,R.id.fourTv,R.id.fiveTv,R.id.sixTv,R.id.sevenTv,R.id.eightTv,R.id.nineTv,R.id.tenTv,R.id.elevenTv,R.id.twelveTv,R.id.thirteenTv,R.id.fourteenTv,R.id.fiveteenTv};
    int idSpinnerView [] = {R.id.firstSp,R.id.secondSp,R.id.thirtSp,R.id.fourSp,R.id.fiveSp,R.id.sixSp,R.id.sevenSp,R.id.eightSp,R.id.nineSp,R.id.tenSp,R.id.elevenSp,R.id.twelveSp,R.id.thirteenSp,R.id.fourteenSp,R.id.fiveteenSp};
    int countSpinner[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //a,b,c,d,e,f,g,h,i,k,l,m,n,o,p;
    String alphabet [] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};

    ArrayList<Exercise> exercises;
    ExercisePickPic exercisePickPic;

    public PickPicFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pick_pic, container, false);
        if (getArguments() != null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exercisePickPic = (ExercisePickPic) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
        }
        tvCondition = (TextView) view.findViewById(R.id.tvContition);
        imageView = (ImageView) view.findViewById(R.id.ivPicture);
        tvCondition.setText(exercisePickPic.getCondition());
        imageView.setImageResource(getResources().getIdentifier(exercisePickPic.getPhotoName(), "drawable", getContext().getPackageName()));
        for(int i:idLinearView)
            view.findViewById(i).setVisibility(View.GONE);
        int t  = 0;
        for(String sec:exercisePickPic.getWords()){
            view.findViewById(idLinearView[t]).setVisibility(View.VISIBLE);
            ((TextView)view.findViewById(idTextView[t])).setText(sec);
            String words [] = new String[exercisePickPic.getWords().size()];
            for (int i = 0; i<exercisePickPic.getWords().size() ;i++){
                words[i] = alphabet [i];
            }
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,words);
            ((Spinner)view.findViewById(idSpinnerView[t])).setAdapter(stringArrayAdapter);
            t++;
        }
        return view;
    }



}
