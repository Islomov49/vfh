package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseFillTextWords;
import com.eng.iso.sharipova.Entity.ExerciseWordsFillWriteAudio;
import com.eng.iso.sharipova.Entity.IntervalsTwoPair;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;
import com.eng.iso.sharipova.Utils.TextUtils;

import java.util.ArrayList;

public class FillTextWordsAudioFragment extends Fragment {

    ExerciseWordsFillWriteAudio wordsFillWrite;
    ArrayList<Exercise> exercises;
    String forFilling = "";
    ArrayList<IntervalsTwoPair> intervalsTwoPairs;

    TextView tvKeyWords;
    TextView fillText;
    private Handler mHandler;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    ImageView playButton;
    ImageView pauseButton;
    TextView tvCondition;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fill_text_words_audio, container, false);
        if (getArguments() != null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            wordsFillWrite = (ExerciseWordsFillWriteAudio) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
        }
        playButton = (ImageView) view.findViewById(R.id.playButton);
        pauseButton = (ImageView) view.findViewById(R.id.pauseButton);
        seekBar = (SeekBar) view.findViewById(R.id.seekbarProg);
        intervalsTwoPairs = new ArrayList<>();
        tvKeyWords = (TextView) view.findViewById(R.id.textView);
        tvCondition = (TextView) view.findViewById(R.id.tvContition);
        fillText = (TextView) view.findViewById(R.id.fillText);
        String str = "";
        for (String word:wordsFillWrite.getWords()){
            str  = str + word+ ", ";
        }
        tvKeyWords.setText(str);
        tvCondition.setText(wordsFillWrite.getCondition());
        forFilling  = wordsFillWrite.getText();
        IntervalsTwoPair intervalsTwoPair = null;
        for(int i = 0;i<forFilling.length();i++){
            if(forFilling.charAt(i)=='_'){
                if (intervalsTwoPair == null)
                    intervalsTwoPair =  new IntervalsTwoPair(i,-1);

            }
            else if(intervalsTwoPair!=null){
                intervalsTwoPair.setEndPosition(i);
                intervalsTwoPairs.add(intervalsTwoPair);
                intervalsTwoPair = null;
            }
        }
        TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairs,forFilling,fillText,getContext());
        fillText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    int i = fillText.getOffsetForPosition(event.getX(),event.getY());

                    for(final IntervalsTwoPair intervalsTwoPair1:intervalsTwoPairs){
                        if(intervalsTwoPair1.getStartPosition()<=i&&intervalsTwoPair1.getEndPosition()>=i){
                            AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
                            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,wordsFillWrite.getWords());
                            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String strName = wordsFillWrite.getWords().get(which);
                                    int farq =intervalsTwoPair1.getStartPosition() + strName.length() -  intervalsTwoPair1.getEndPosition() ;
                                    if(farq !=0){
                                        for(int j = intervalsTwoPairs.indexOf(intervalsTwoPair1)+1;j<intervalsTwoPairs.size();j++){
                                            intervalsTwoPairs.get(j).setStartPosition(intervalsTwoPairs.get(j).getStartPosition()+farq);
                                            intervalsTwoPairs.get(j).setEndPosition(intervalsTwoPairs.get(j).getEndPosition()+farq);
                                        }
                                    }
                                    forFilling = forFilling.substring(0,intervalsTwoPair1.getStartPosition()) + strName +forFilling.substring(intervalsTwoPair1.getEndPosition(),forFilling.length());
                                    intervalsTwoPair1.setEndPosition(intervalsTwoPair1.getStartPosition() + strName.length());
                                    intervalsTwoPair1.setWord(strName);
                                    TextUtils.ColorFillWordsForFillGaps(intervalsTwoPairs,forFilling,fillText,getContext());

                                }
                            });
                            builderSingle.show();
                        }
                    }

                }

                return true;
            }
        });

        int resID=getResources().getIdentifier(wordsFillWrite.getAudioName(), "raw", getContext().getPackageName());
        mediaPlayer = MediaPlayer.create(getContext(),resID);
        seekBar.setMax(mediaPlayer.getDuration()/1000);
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer != null){
                    int mCurrentPosition = mediaPlayer.getCurrentPosition() / 1000;
                    seekBar.setProgress(mCurrentPosition);
                }
                mHandler.postDelayed(this, 1000);
            }
        }, 1000);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mediaPlayer != null && fromUser){
                    mediaPlayer.seekTo(progress * 1000);
                }
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){

                    mediaPlayer.pause();
                    playButton.setImageResource(R.drawable.play);
                }
                else {  mediaPlayer.start();
                    playButton.setImageResource(R.drawable.pause);

                }
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButton.setImageResource(R.drawable.play);
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                seekBar.setProgress(0);
            }
        });

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mediaPlayer.stop();
    }

}
