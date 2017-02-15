package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseAnswerQuestions;
import com.eng.iso.sharipova.Entity.ExerciseUnderline;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.EditTextState;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

public class QuestionAnswerFragment extends Fragment {
    EditTextState firstETS;
    EditTextState secondETS;
    EditTextState thirtETS;
    EditTextState fourETS;
    EditTextState fiveETS;

    TextView firstTV;
    TextView secondTV;
    TextView thirtTV;
    TextView fourTV;
    TextView fiveTV;


    TextView tvContition;

    ArrayList<Exercise> exercises;
    ExerciseAnswerQuestions exerciseAnswerQuestions;
    public QuestionAnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_answer, container, false);
        firstETS = (EditTextState) view.findViewById(R.id.stateFirst);
        secondETS = (EditTextState) view.findViewById(R.id.stateSecond);
        thirtETS = (EditTextState) view.findViewById(R.id.stateThirt);
        fourETS = (EditTextState) view.findViewById(R.id.stateFour);
        fiveETS = (EditTextState) view.findViewById(R.id.stateFive);

        firstTV = (TextView) view.findViewById(R.id.firstQuestion);
        secondTV = (TextView) view.findViewById(R.id.secondQuestion);
        thirtTV = (TextView) view.findViewById(R.id.thirtQuestion);
        fourTV = (TextView) view.findViewById(R.id.fourQuestion);
        fiveTV = (TextView) view.findViewById(R.id.fiveQuestion);


        tvContition = (TextView) view.findViewById(R.id.tvContition);

        if(getArguments()!=null){
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exerciseAnswerQuestions = (ExerciseAnswerQuestions) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
            firstETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),1);
            secondETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),2);
            thirtETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),3);
            fourETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),4);
            fiveETS.initStateLisner(getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),5);

            firstTV.setText("1. "+ exerciseAnswerQuestions.getQuestions().get(0));
            secondTV.setText("2. "+ exerciseAnswerQuestions.getQuestions().get(1));
            thirtTV.setText("3. "+ exerciseAnswerQuestions.getQuestions().get(2));
            fourTV.setText("4. "+ exerciseAnswerQuestions.getQuestions().get(3));
            fiveTV.setText("5. "+ exerciseAnswerQuestions.getQuestions().get(4));
            tvContition.setText(exerciseAnswerQuestions.getCondition());
        }else return null;

        return view;
    }

}
