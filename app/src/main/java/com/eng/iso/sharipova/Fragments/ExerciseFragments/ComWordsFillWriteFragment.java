package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseComWordsFillWrite;
import com.eng.iso.sharipova.Entity.IntervalsTwoPair;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;
import com.eng.iso.sharipova.Utils.TextUtils;

import java.util.ArrayList;

public class ComWordsFillWriteFragment extends Fragment {
    ExerciseComWordsFillWrite exerciseComWordsFillWrite;
    ArrayList<Exercise> exercises;

    ImageView imageView;
    TextView tvKeyWords;
    TextView fillText;
    TextView tvCondition;
    int idLinearView [] = {R.id.firstBlock,R.id.secondBlock,R.id.thirtBlock,R.id.fourBlock,R.id.fiveBlock,R.id.sixBlock};
    int idTextView [] = {R.id.firstTv,R.id.secondTv,R.id.thirtTv,R.id.fourTv,R.id.fiveTv,R.id.sixTv};
    int idSpinnerView [] = {R.id.firstSp,R.id.secondSp,R.id.thirtSp,R.id.fourSp,R.id.fiveSp,R.id.sixSp};
    String alphabet [] = {"A","B","C","D","E","F"};
    String forFilling = "";

    ArrayList<IntervalsTwoPair> intervalsTwoPairs;
    public ComWordsFillWriteFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_com_words_fill_write, container, false);
        if (getArguments() != null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exerciseComWordsFillWrite = (ExerciseComWordsFillWrite) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
        }
        intervalsTwoPairs = new ArrayList<>();
        tvKeyWords = (TextView) view.findViewById(R.id.textView);
        tvCondition = (TextView) view.findViewById(R.id.tvContition);
        fillText = (TextView) view.findViewById(R.id.fillText);
        imageView = (ImageView) view.findViewById(R.id.ivPicture);
        String str = "";
        for (String word:exerciseComWordsFillWrite.getWords()){
            str  = str + word+ ", ";
        }
        tvKeyWords.setText(str);
        tvCondition.setText(exerciseComWordsFillWrite.getCondition());
        imageView.setImageResource(getResources().getIdentifier(exerciseComWordsFillWrite.getPhotoName(), "drawable", getContext().getPackageName()));
        for(int i:idLinearView)
            view.findViewById(i).setVisibility(View.GONE);
        int t  = 0;
        for(int i=0;i<exerciseComWordsFillWrite.getCountPick();i++){
            view.findViewById(idLinearView[t]).setVisibility(View.VISIBLE);
            ((TextView)view.findViewById(idTextView[t])).setText(alphabet[i]);

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,exerciseComWordsFillWrite.getWords());
            ((Spinner)view.findViewById(idSpinnerView[t])).setAdapter(stringArrayAdapter);
            t++;
        }
        int counter = 1;
        for (String word:exerciseComWordsFillWrite.getGaps()){
            forFilling  = forFilling +Integer.toString(counter)+". "+ word+ "\n\n";
            counter ++;
        }
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
                            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,exerciseComWordsFillWrite.getWords());
                            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String strName = exerciseComWordsFillWrite.getWords().get(which);
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
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
