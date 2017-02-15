package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseUnderline;
import com.eng.iso.sharipova.Entity.IntervalsTwoPair;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;
import com.eng.iso.sharipova.Utils.TextUtils;

import java.util.ArrayList;

public class UnderlineExerciseFragment extends Fragment {
    TextView content;
    TextView tvContition;
    TextView tvKeyWords;
    TextView tvTitle;
    ArrayList<Exercise> exercises;
    ExerciseUnderline exerciseUnderline;
    ArrayList<IntervalsTwoPair> intervalsTwoPairs;
    String keywords;
    ArrayList<IntervalsTwoPair> switchedInterval;
    ArrayList<IntervalsTwoPair> wordsPosition;
    public UnderlineExerciseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_underline_exercise, container, false);
        intervalsTwoPairs = new ArrayList<>();
        switchedInterval = new ArrayList<>();
        wordsPosition = new ArrayList<>();
         content = (TextView) view.findViewById(R.id.textContent);
        tvContition = (TextView) view.findViewById(R.id.tvContition);
        tvKeyWords = (TextView) view.findViewById(R.id.textView);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        if(getArguments()!=null){
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exerciseUnderline = (ExerciseUnderline) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));

        }
        tvContition.setText(exerciseUnderline.getCondition());
        tvTitle.setText(exerciseUnderline.getTitle());
         keywords = "";
        String text = exerciseUnderline.getText();
        String orgin = "";
        for (String word:exerciseUnderline.getWords()){
           orgin = word;
            while (true) {
                if(!word.isEmpty()){
                    if (word.charAt(0) == ' ')
                        word = word.substring(1, word.length());
                    else break;
                }
                else break;
            }

            if(word.startsWith("to")&&word.charAt(2)==' '){
                word = word.substring(2,word.length());
            }
            if(word.startsWith("a")&&word.charAt(1)==' '){
                word = word.substring(1,word.length());
            }
            if(word.startsWith("an")&&word.charAt(2)==' '){
                word = word.substring(2,word.length());
            }

            if(text.contains(word)){
                int start = 0;
                while (text.indexOf(word,start)!=-1&&!word.isEmpty()){
                    wordsPosition.add(new IntervalsTwoPair(text.indexOf(word,start),text.indexOf(word,start)+word.length(),orgin));
                    start = text.indexOf(word,start)+word.length();

                }
                if (!word.isEmpty())
                keywords = keywords+orgin + ", ";
            }

        }
        tvKeyWords.setText(keywords);
        content.setText(exerciseUnderline.getText());




        content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){

                    String str =exerciseUnderline.getText();
                    boolean keyBegin = false;
                    boolean keyEnd = false;
                    int cursorEnd = content.getOffsetForPosition(event.getX(),event.getY());
                    int cursor = cursorEnd;
                    int lenghtt = exerciseUnderline.getText().length();
                    while (true){
                        if(keyEnd) break;
                        if(keyBegin){
                            cursorEnd = cursor;
                            cursorEnd ++;
                            while (true){
                                if(cursorEnd<=lenghtt){
                                    if (cursorEnd==lenghtt){
                                        keyEnd = true;
                                        break;
                                    }
                                    else if((str.charAt(cursorEnd))==' '||(str.charAt(cursorEnd))==':'||(str.charAt(cursorEnd))=='"'||(str.charAt(cursorEnd))==')'||(str.charAt(cursorEnd))=='('){
                                        keyEnd = true;
                                        break;
                                    }

                                    cursorEnd ++;
                                }
                                else break;
                            }
                        } else {
                            while (true){
                                if(cursor<=0){
                                    keyBegin = true;

                                    cursor = 0;
                                    break;
                                }
                                if(cursor<lenghtt)
                                if((str.charAt(cursor))==' '||(str.charAt(cursor))==':'||(str.charAt(cursor))=='"'||(str.charAt(cursor))==')'||(str.charAt(cursor))=='('){
                                    keyBegin = true;
                                    break;
                                }
                                cursor --;
                            }
                        }
                    }





                    IntervalsTwoPair incorrect  = new IntervalsTwoPair(cursor+1,cursorEnd);

                    int cursorik = content.getOffsetForPosition(event.getX(),event.getY());

                    for (IntervalsTwoPair intervalsTwoPair:wordsPosition){
                        if (cursorik<=intervalsTwoPair.getEndPosition()&&cursorik>=intervalsTwoPair.getStartPosition()){
                            switchedInterval.add(new IntervalsTwoPair(keywords.indexOf(intervalsTwoPair.getWord()),keywords.indexOf(intervalsTwoPair.getWord())+intervalsTwoPair.getWord().length()));
                            intervalsTwoPairs.add(new IntervalsTwoPair(intervalsTwoPair.getStartPosition(),intervalsTwoPair.getEndPosition()));
                            incorrect = null;
                        }
                    }

                    if (switchedInterval !=null){
                        TextUtils.ColorFillWords(switchedInterval,keywords,tvKeyWords,null,getContext());
                    }
                    TextUtils.ColorFillWords(intervalsTwoPairs,exerciseUnderline.getText(),content,incorrect,getContext());
                }

                return true;
            }
        });
        return view;
    }

}
