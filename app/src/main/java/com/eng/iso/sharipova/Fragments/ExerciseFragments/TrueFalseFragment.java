package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eng.iso.sharipova.Adapters.ExerciseAdapters.TwoDeferiantVersion;
import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseTrueOrFalse;
import com.eng.iso.sharipova.Entity.ExerciseTwoDefferientThink;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

public class TrueFalseFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Exercise> exercises;
    ExerciseTrueOrFalse exerciseSynonyms;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_def, container, false);
        if(getArguments()!=null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exerciseSynonyms = (ExerciseTrueOrFalse) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
            TwoDeferiantVersion synonimAdapter = new TwoDeferiantVersion(exerciseSynonyms.getSentence(),getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),"True","False");
            recyclerView  = (RecyclerView) view.findViewById(R.id.recycSynonimic);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            layoutManager.setAutoMeasureEnabled(true);
            recyclerView.setHasFixedSize(false);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(synonimAdapter);
            textView = (TextView) view.findViewById(R.id.tvContition);
            textView.setText(exerciseSynonyms.getCondition());
        }



            return view;
    }


}
