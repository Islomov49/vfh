package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eng.iso.sharipova.Adapters.ExerciseAdapters.SynonimAdapter;
import com.eng.iso.sharipova.Adapters.ExerciseAdapters.TestAdapter;
import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseTest;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

public class TestFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Exercise> exercises;
    ExerciseTest testexec;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        if(getArguments()!=null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            testexec = (ExerciseTest) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
            TestAdapter synonimAdapter = new TestAdapter(testexec,getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY));
            recyclerView  = (RecyclerView) view.findViewById(R.id.recycSynonimic);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            layoutManager.setAutoMeasureEnabled(true);
            recyclerView.setHasFixedSize(false);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(synonimAdapter);
            textView = (TextView) view.findViewById(R.id.tvContition);
            textView.setText(testexec.getCondition());
        }
            return view;
    }

}
