package com.eng.iso.sharipova.Adapters.ExerciseAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseTest;
import com.eng.iso.sharipova.Entity.TestVariant;
import com.eng.iso.sharipova.Entity.TestVariant4x;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.EditTextState;

import java.util.ArrayList;

/**
 * Created by developer on 20.02.2017.
 */

public class TestAdapter extends  RecyclerView.Adapter<TestAdapter.ViewHolder> {
    ExerciseTest exerciseTest;
    int lessonNumber ;
    int count;
    public TestAdapter (ExerciseTest exerciseTest, int lessonNumber, int count){
        this.exerciseTest = exerciseTest;
        this.lessonNumber= lessonNumber;
        this.count = count;
    }
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item_adapter, parent, false);
        return new TestAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TestAdapter.ViewHolder holder, int position) {
        holder.firstQuestion.setText(Integer.toString(position+1)+". "+exerciseTest.getQuestions().get(position));

        if(exerciseTest.getTestVariants().get(position) instanceof TestVariant4x){
            TestVariant4x testVariant4x = (TestVariant4x) exerciseTest.getTestVariants().get(position);
            holder.radioButtonA.setText(testVariant4x.getFirst());
            holder.radioButtonB.setText(testVariant4x.getSecond());
            holder.radioButtonC.setText(testVariant4x.getThirty());
            holder.radioButtonD.setText(testVariant4x.getFour());
        }
        else {
            TestVariant testVariant =  exerciseTest.getTestVariants().get(position);
            holder.radioButtonA.setText(testVariant.getFirst());
            holder.radioButtonB.setText(testVariant.getSecond());
            holder.radioButtonC.setText(testVariant.getThirty());
            holder.radioButtonD.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return exerciseTest.getQuestions().size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstQuestion;
        RadioGroup rgAnswers;
        RadioButton radioButtonA;
        RadioButton radioButtonB;
        RadioButton radioButtonC;
        RadioButton radioButtonD;
        public ViewHolder(View v) {
            super(v);
            firstQuestion = (TextView) v.findViewById(R.id.firstQuestion);
            rgAnswers = (RadioGroup) v.findViewById(R.id.rgAnswers);
            radioButtonA = (RadioButton) v.findViewById(R.id.aans);
            radioButtonB = (RadioButton) v.findViewById(R.id.bans);
            radioButtonC = (RadioButton) v.findViewById(R.id.cans);
            radioButtonD = (RadioButton) v.findViewById(R.id.dans);
        }
    }
}