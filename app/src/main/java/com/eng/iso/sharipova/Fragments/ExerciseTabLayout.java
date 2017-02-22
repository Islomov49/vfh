package com.eng.iso.sharipova.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eng.iso.sharipova.Entity.Exercise;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.AdwantageDisadvantageFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.ComWordsFillWriteFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.EmptyFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.FillGapsFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.FillTextWordsAudioFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.FillTextWordsFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.JumpedKeyFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.ListenAndMatchFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.ListeningAnswerFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.MatchWordsFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.PickPhotoFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.PickPicFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.QuestionAnswerFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.RerangeFragement;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.SynonimFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.TestFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.TrueFalseFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.TwoDeferentsFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.UnderlineExerciseFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.VocOwnFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.WriteSentenceFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.WriteSentenceTextFragment;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseManager;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;

import static com.eng.iso.sharipova.Utils.ExerciseTypes.*;


public class ExerciseTabLayout extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private PagerAdapter adapter;
    private TabLayout tabLayout;
    private ArrayList<Fragment> list;
    int countCurrent = 0;
    int lessonNumber = 0;
    ArrayList<Exercise> exercises;
    Exercise exercise;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_tab_layout, container, false);

        if(getArguments()!=null){
            countCurrent = getArguments().getInt("COUNT_KEY");
            lessonNumber = getArguments().getInt(ExerciseTypes.LESSON_NUMBER);
            exercises = ExerciseManager.fillData(getArguments().getInt(ExerciseTypes.LESSON_NUMBER));

        }

        tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        list = new ArrayList<>();



        for(int i = 0 ;i<exercises.size();i++){
            list.add(getNeededFragment(lessonNumber,i));
        }


        adapter = new PagerAdapter(getActivity().getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(countCurrent);
        viewPager.addOnPageChangeListener(this);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        tabLayout.getTabAt(countCurrent).select();

                    }
                });
            }
        });

        return  view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
       }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    boolean show = false;

    @Override
    public void onClick(View v) {

    }

    public Fragment getNeededFragment(int lessonNumber, int exerciseCount){
        Fragment fragment = null;
        exercise =  exercises.get(exerciseCount);
        switch (exercise.getType()){
            case UNDERLINE_EX:
                fragment = new UnderlineExerciseFragment();
                break;
            case QUESTION_EX:
                fragment = new QuestionAnswerFragment();
                break;
            case PIC_PICK_EX:
                fragment = new PickPicFragment();
                break;
            case COM_PIC_PICK_FILL_GAP_EX:
                fragment = new ComWordsFillWriteFragment();
                break;
            case FILL_GAP_EX:
                fragment = new FillGapsFragment();
                break;
            case FILL_TEXT_WITH_WORDS_EX:
                fragment = new FillTextWordsFragment();
                break;
            case RERANGE_EX:
                fragment = new RerangeFragement();
                break;
            case WRITE_SENTENCES_EX:
                fragment = new WriteSentenceFragment();
                break;
            case SYNONYMS_EX:
                fragment = new SynonimFragment();
                break;
            case WRITE_SENTENCES_TEXT_EX:
                fragment = new WriteSentenceTextFragment();
                break;
            case VOC_OWN_EX:
                fragment = new VocOwnFragment();
                break;
            case LISTENING_ANSWER_KEY:
                fragment = new ListeningAnswerFragment();
                break;
            case TEST_EX:
                fragment = new TestFragment();
                break;
            case PICT_PHOTO_EX:
                fragment = new PickPhotoFragment();
                break;
            case MATCH_WORDS_EX:
                fragment = new MatchWordsFragment();
                break;
            case ADVANTAGE_DISADVANTAGE_AUDIO_FILL_EX:
                fragment = new AdwantageDisadvantageFragment();
                break;
            case LISTEN_TEXT_MATCH_KEY:
                fragment = new ListenAndMatchFragment();
                break;
            case JUMPED_KEY:
                fragment = new JumpedKeyFragment();
                break;
            case FILL_TEXT_AUDIO_EX:
                fragment = new FillTextWordsAudioFragment();
                break;
            case TWO_DEFERENT_EX:
                fragment = new TwoDeferentsFragment();
                break;
            case TRUE_FALSE_EX:
                fragment = new TrueFalseFragment();
                break;
            default: fragment = new EmptyFragment();



        }
        Bundle bundle = new Bundle();
        bundle.putInt(ExerciseTypes.LESSON_NUMBER,lessonNumber);
        bundle.putInt(ExerciseTypes.COUNT_KEY,exerciseCount);
        fragment.setArguments(bundle);
        return fragment;

    }
    public class PagerAdapter extends FragmentStatePagerAdapter {
        private ArrayList<Fragment> list;
        public PagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            this.list = list;
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return "I Exercise";
                case 1:
                    return "II Exercise";
                case 2:
                    return "III Exercise";
                case 3:
                    return "IV Exercise";
                case 4:
                    return "V Exercise";
                case 5:
                    return "VI Exercise";
                case 6:
                    return "VII Exercise";
                case 7:
                    return "VIII Exercise";
                case 8:
                    return "IX Exercise";
                case 9:
                    return "X Exercise";

            }
            return "";
        }
    }
}
