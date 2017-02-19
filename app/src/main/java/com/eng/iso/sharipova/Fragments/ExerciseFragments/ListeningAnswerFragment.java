package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseListenCheckUpAnswers;
import com.eng.iso.sharipova.Entity.ExerciseSynonyms;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

public class ListeningAnswerFragment extends Fragment {
    ArrayList<Exercise> exercises;
    ExerciseListenCheckUpAnswers exerciseListenCheckUpAnswers;
    private Handler mHandler;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    ImageView playButton;
    ImageView pauseButton;
    TextView tvCondition;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listening_answer, container, false);
        tvCondition = (TextView) view.findViewById(R.id.tvContition);
        playButton = (ImageView) view.findViewById(R.id.playButton);
        pauseButton = (ImageView) view.findViewById(R.id.pauseButton);
        seekBar = (SeekBar) view.findViewById(R.id.seekbarProg);
        if(getArguments()!=null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            exerciseListenCheckUpAnswers = (ExerciseListenCheckUpAnswers) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
        }
        tvCondition.setText(exerciseListenCheckUpAnswers.getCondition());
        int resID=getResources().getIdentifier(exerciseListenCheckUpAnswers.getAudioName(), "raw", getContext().getPackageName());
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
