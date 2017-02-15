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
        for (String s:exerciseUnderline.getWords()){
            keywords = keywords+s + ", ";
        }
        tvKeyWords.setText(keywords);
        content.setText(exerciseUnderline.getText());
        content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.d("touchtest", "onTouch: "+event.getX() + " --- " + event.getY());
                    Log.d("touchtest", "onTouch: "+exerciseUnderline.getText().charAt(content.getOffsetForPosition(event.getX(),event.getY()))) ;

                    String str =exerciseUnderline.getText();
                    String sub ="";
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
                                if((str.charAt(cursor))==' '||(str.charAt(cursor))==':'||(str.charAt(cursor))=='"'||(str.charAt(cursor))==')'||(str.charAt(cursor))=='('){
                                    keyBegin = true;
                                    break;
                                }
                                cursor --;
                            }
                        }
                    }
                    IntervalsTwoPair incorrect  = new IntervalsTwoPair(cursor+1,cursorEnd);
                    String subs = exerciseUnderline.getText().substring(cursor+1,cursorEnd);
                    for(String keyword:exerciseUnderline.getWords()){
                        while (true) {
                            if(!keyword.isEmpty()){
                            if (keyword.charAt(0) == ' ')
                                keyword = keyword.substring(1, keyword.length());
                            else break;
                            }
                            else break;
                        }
                        //TODO popravit dlya pervogo elementa electronic machines
                        if(keyword.contains(subs)&&!subs.equals("to")&&!subs.equals("a")&&!subs.equals("an")&&!subs.equals("in")&&((keywords.charAt(keywords.indexOf(subs)+subs.length()+1)==','||keywords.charAt(keywords.indexOf(subs)+subs.length()+1)==' ')&&keywords.charAt(keywords.indexOf(subs)-1)==' ')){
                            switchedInterval.add(new IntervalsTwoPair(keywords.indexOf(keyword),keywords.indexOf(keyword)+keyword.length()));
                            intervalsTwoPairs.add(new IntervalsTwoPair(cursor+1,cursorEnd));
                            incorrect = null;
                            break;
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
