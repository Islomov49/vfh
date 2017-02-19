package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseWriteSenrences;
import com.eng.iso.sharipova.Entity.ExerciseWriteSentencesText;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.EditTextState;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

public class WriteSentenceTextFragment extends Fragment {
    EditTextState firstETS;
    EditTextState secondETS;
    EditTextState thirtETS;
    EditTextState fourETS;
    EditTextState fiveETS;
    EditTextState sixETS;

    TextView firstTV;
    TextView secondTV;
    TextView thirtTV;
    TextView fourTV;
    TextView fiveTV;
    TextView sixTV;


    TextView tvContition;
    TextView tvText;
    ArrayList<Exercise> exercises;
    ExerciseWriteSentencesText writeSenrences;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_write_sentence_text, container, false);
        firstETS = (EditTextState) view.findViewById(R.id.stateFirst);
        secondETS = (EditTextState) view.findViewById(R.id.stateSecond);
        thirtETS = (EditTextState) view.findViewById(R.id.stateThirt);
        fourETS = (EditTextState) view.findViewById(R.id.stateFour);
        fiveETS = (EditTextState) view.findViewById(R.id.stateFive);
        sixETS = (EditTextState) view.findViewById(R.id.stateSix);

        firstTV = (TextView) view.findViewById(R.id.firstQuestion);
        secondTV = (TextView) view.findViewById(R.id.secondQuestion);
        thirtTV = (TextView) view.findViewById(R.id.thirtQuestion);
        fourTV = (TextView) view.findViewById(R.id.fourQuestion);
        fiveTV = (TextView) view.findViewById(R.id.fiveQuestion);
        sixTV = (TextView) view.findViewById(R.id.sixQuestion);


        tvContition = (TextView) view.findViewById(R.id.tvContition);
        tvText = (TextView) view.findViewById(R.id.textView);



        if(getArguments()!=null){
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            writeSenrences = (ExerciseWriteSentencesText) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
            firstETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),1);
            secondETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),2);
            thirtETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),3);
            fourETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),4);
            fiveETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),5);
            sixETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),6);

            tvText.setText(writeSenrences.getText());

            firstTV.setText(writeSenrences.getUsefullTips().get(0));
            secondTV.setText( writeSenrences.getUsefullTips().get(1));
            thirtTV.setText( writeSenrences.getUsefullTips().get(2));
            fourTV.setText( writeSenrences.getUsefullTips().get(3));
            if(writeSenrences.getUsefullTips().size()>=5)
            fiveTV.setText( writeSenrences.getUsefullTips().get(4));
            else{
                fiveTV.setVisibility(View.GONE);
                fiveETS.setVisibility(View.GONE);
            }
            if(writeSenrences.getUsefullTips().size()>=6)
                sixTV.setText(writeSenrences.getUsefullTips().get(5));
            else{
                sixTV.setVisibility(View.GONE);
                sixETS.setVisibility(View.GONE);
            }
            tvContition.setText(writeSenrences.getCondition());
        }else return null;

        return view;
    }


}
