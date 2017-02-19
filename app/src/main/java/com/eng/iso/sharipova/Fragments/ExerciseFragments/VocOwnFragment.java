package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseVocabulOwn;
import com.eng.iso.sharipova.Entity.ExerciseWriteSenrences;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.EditTextState;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

public class VocOwnFragment extends Fragment {
    ArrayList<Exercise> exercises;
    ExerciseVocabulOwn exerciseVocabulOwn;
    TextView tvCondition;
    EditTextState editTextState;
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voc_own, container, false);
        tvCondition = (TextView) view.findViewById(R.id.tvContition);
        editTextState = (EditTextState) view.findViewById(R.id.etsWrite);
        imageView = (ImageView) view.findViewById(R.id.ivPicture);

        if(getArguments()!=null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exerciseVocabulOwn = (ExerciseVocabulOwn) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
            tvCondition.setText(exerciseVocabulOwn.getCondition());
            editTextState.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),0);
            if(!exerciseVocabulOwn.getPhotoName().equals("")){
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(getResources().getIdentifier(exerciseVocabulOwn.getPhotoName(), "drawable", getContext().getPackageName()));
            }
            else imageView.setVisibility(View.GONE);
        }

            return view;
    }

}
