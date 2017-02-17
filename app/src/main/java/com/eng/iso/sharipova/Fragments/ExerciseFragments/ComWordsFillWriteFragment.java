package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseComWordsFillWrite;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

public class ComWordsFillWriteFragment extends Fragment {
    ExerciseComWordsFillWrite exerciseComWordsFillWrite;
    ArrayList<Exercise> exercises;

    ImageView imageView;
    TextView tvKeyWords;
    TextView tvCondition;
    int idLinearView [] = {R.id.firstBlock,R.id.secondBlock,R.id.thirtBlock,R.id.fourBlock,R.id.fiveBlock,R.id.sixBlock};
    int idTextView [] = {R.id.firstTv,R.id.secondTv,R.id.thirtTv,R.id.fourTv,R.id.fiveTv,R.id.sixTv};
    int idSpinnerView [] = {R.id.firstSp,R.id.secondSp,R.id.thirtSp,R.id.fourSp,R.id.fiveSp,R.id.sixSp};
    String alphabet [] = {"A","B","C","D","E","F"};

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

        tvKeyWords = (TextView) view.findViewById(R.id.textView);
        tvCondition = (TextView) view.findViewById(R.id.tvContition);
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

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
