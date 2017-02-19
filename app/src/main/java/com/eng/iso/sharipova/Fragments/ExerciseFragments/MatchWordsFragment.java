package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseMatchWords;
import com.eng.iso.sharipova.Entity.ExerciseSynonyms;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;
import com.eng.iso.sharipova.Utils.TextUtils;

import java.util.ArrayList;

public class MatchWordsFragment extends Fragment {
    int numberics [] = {R.id.oneTv,R.id.twoTv,R.id.thirtTv,R.id.fourTv,R.id.fiveTv,R.id.sixTv,R.id.sevenTv,R.id.eightTv};
    int alphabitic [] = {R.id.atv,R.id.btv,R.id.ctv,R.id.dtv,R.id.etv,R.id.ftv,R.id.gtv,R.id.htv};
    int answer[] = {R.id.aAnswer,R.id.bAnswer,R.id.cAnswer,R.id.dAnswer,R.id.eAnswer,R.id.fAnswer,R.id.gAnswer,R.id.hAnswer};
    String alpha [] = {"A","B","C","D","E","F","G","H"};
    ArrayList<Exercise> exercises;
    ExerciseMatchWords exerciseMatchWords;

    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_words, container, false);
        textView = (TextView) view.findViewById(R.id.tvContition);
        if(getArguments()!=null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exerciseMatchWords = (ExerciseMatchWords) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
        }
        textView.setText(exerciseMatchWords.getCondition());
        int t = 0;
        for (String s:exerciseMatchWords.getFirstCollumb()){
            ((TextView) view.findViewById(numberics[t])).setText(Integer.toString(t+1)+") "+s);

            t++;
        }
         t = 0;
        for (String s:exerciseMatchWords.getSecondCollumb()){
            ((TextView) view.findViewById(alphabitic[t])).setText(alpha[t]+") "+s);
            t++;
        }
        if(exerciseMatchWords.getFirstCollumb().size()==7){
            view.findViewById(numberics[7]).setVisibility(View.GONE);
            view.findViewById(alphabitic[7]).setVisibility(View.GONE);
            view.findViewById(R.id.ifInvis).setVisibility(View.INVISIBLE);
            view.findViewById(R.id.ifInvisTop).setVisibility(View.INVISIBLE);
        }
        for(int i =0;i<exerciseMatchWords.getFirstCollumb().size();i++){
            view.findViewById(answer[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick( final View v) {
                    AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,alpha);
                    builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ((TextView)v).setText(alpha[which]);
                        }
                    });
                    builderSingle.show();

                }
            });
        }

        return view;
    }

}
