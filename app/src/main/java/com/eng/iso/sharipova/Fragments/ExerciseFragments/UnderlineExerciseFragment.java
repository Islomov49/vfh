package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseUnderline;
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
        String keywords = "";
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
                                    if((str.charAt(cursorEnd))==' '||(str.charAt(cursorEnd))==':'||(str.charAt(cursorEnd))=='"'||(str.charAt(cursorEnd))==')'||(str.charAt(cursorEnd))=='('){
                                        keyEnd = true;
                                        break;
                                    }
                                    cursorEnd ++;
                                }
                                else break;
                            }
                        } else {
                            while (true){
                                if(cursor<0){
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
                    sub =  str.substring(++cursor,cursorEnd);
                    TextUtils.ColorSubSeq(exerciseUnderline.getText(),sub,"#eaf3ed",content);
                }

                return true;
            }
        });
        return view;
    }

}
