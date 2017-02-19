package com.eng.iso.sharipova.Fragments.ExerciseFragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.eng.iso.sharipova.Adapters.ExerciseAdapters.ListenTextMatchAdapter;
import com.eng.iso.sharipova.Adapters.ExerciseAdapters.SynonimAdapter;
import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Entity.ExerciseListenPictureMatch;
import com.eng.iso.sharipova.Entity.ExerciseListenTextMatchKey;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

public class ListenAndMatchFragment extends Fragment {
    ArrayList<Exercise> exercises;
    ExerciseListenTextMatchKey listenTextMatchKey;
    TextView textView;
    TextView textView2;
    private Handler mHandler;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    ImageView playButton;
    ImageView pauseButton;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listen_and_match, container, false);
        textView = (TextView) view.findViewById(R.id.tvContition);
        textView2 = (TextView) view.findViewById(R.id.textView);
        playButton = (ImageView) view.findViewById(R.id.playButton);
        pauseButton = (ImageView) view.findViewById(R.id.pauseButton);
        seekBar = (SeekBar) view.findViewById(R.id.seekbarProg);
        if (getArguments() != null) {
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));
            listenTextMatchKey = (ExerciseListenTextMatchKey) exercises.get(getArguments().getInt(ExerciseTypes.COUNT_KEY));
        }
        textView.setText(listenTextMatchKey.getCondition());
        String s ="";
        for(String s1:listenTextMatchKey.getKeyWords()){
            s = s + s1 + ", ";
        }
        textView2.setText(s);
        int resID=getResources().getIdentifier(listenTextMatchKey.getAudioName(), "raw", getContext().getPackageName());
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


        ListenTextMatchAdapter synonimAdapter = new ListenTextMatchAdapter(listenTextMatchKey.getTexts(),getArguments().getInt(ExerciseTypes.LESSON_NUMBER),getArguments().getInt(ExerciseTypes.COUNT_KEY),listenTextMatchKey.getKeyWords(),getContext());
        recyclerView  = (RecyclerView) view.findViewById(R.id.recycSynonimic);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(synonimAdapter);

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
