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

import com.eng.iso.sharipova.Fragments.ExerciseFragments.QuestionAnswerFragment;
import com.eng.iso.sharipova.Fragments.ExerciseFragments.UnderlineExerciseFragment;
import com.eng.iso.sharipova.R;
import com.eng.iso.sharipova.Utils.ExerciseTypes;

import java.util.ArrayList;


public class ExerciseTabLayout extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private PagerAdapter adapter;
    private TabLayout tabLayout;
    private FloatingActionButton fb;
    private ArrayList<Fragment> list;
    int countCurrent = 0;
    int lessonNumber = 0;
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
        }

        tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        fb = (FloatingActionButton) view.findViewById(R.id.fbDebtBorrowFragment);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()!=list.size())
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
            }
        });
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        list = new ArrayList<>();



        UnderlineExerciseFragment object = new UnderlineExerciseFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ExerciseTypes.LESSON_NUMBER,lessonNumber);
        bundle.putInt(ExerciseTypes.COUNT_KEY,0);
        object.setArguments(bundle);
        list.add(object);
        QuestionAnswerFragment questionAnswerFragment = new QuestionAnswerFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(ExerciseTypes.LESSON_NUMBER,lessonNumber);
        bundle2.putInt(ExerciseTypes.COUNT_KEY,1);
        questionAnswerFragment.setArguments(bundle2);
        list.add(questionAnswerFragment);
        list.add(new LessonFragment());
        list.add(new LessonFragment());
        list.add(new LessonFragment());
        list.add(new LessonFragment());
        list.add(new LessonFragment());
        list.add(new LessonFragment());
        list.add(new LessonFragment());

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

    @Override
    public void onClick(View v) {

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
