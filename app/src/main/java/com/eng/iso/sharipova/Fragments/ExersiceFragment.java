package com.eng.iso.sharipova.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eng.iso.sharipova.Adapters.ExersiceListAdapter;
import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;


public class ExersiceFragment extends Fragment {
    ArrayList<Exercise> exercises;
    RecyclerView rvExercises;
    int lessonNumber = 0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_exersice, container, false);
        if(getArguments()!=null){
            lessonNumber = getArguments().getInt(ExerciseTypes.LESSON_NUMBER);
        }
        exercises = ExerciseManager.fillData(lessonNumber);
        rvExercises = (RecyclerView) inflate.findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvExercises.setLayoutManager(linearLayoutManager);
        ExersiceListAdapter exersiceListAdapter = new ExersiceListAdapter(exercises,getActivity(),lessonNumber);
        rvExercises.setAdapter(exersiceListAdapter);
        return inflate;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
