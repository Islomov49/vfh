package com.eng.iso.sharipova.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eng.iso.sharipova.Adapters.LessonListAdapter;
import com.eng.iso.sharipova.Entity.Lesson;
import com.eng.iso.sharipova.R;

import java.util.ArrayList;

public class LessonFragment extends Fragment {
    ArrayList<Lesson> lessons;
    RecyclerView rvLessons;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_lesson, container, false);
        fillData();
        rvLessons = (RecyclerView) inflate.findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvLessons.setLayoutManager(linearLayoutManager);
        LessonListAdapter lessonListAdapter = new LessonListAdapter(lessons,getActivity());
        rvLessons.setAdapter(lessonListAdapter);
        return inflate;
    }

    public void fillData(){
        lessons = new ArrayList<>();

        lessons.add(new Lesson("LESSON 1","What is computer? What are the different types of Desktop Computers?"));
        lessons.add(new Lesson("LESSON 2","What makes easy to use computer for us?"));
        lessons.add(new Lesson("LESSON 3","How can we enter characters and functions into the computer system?"));
        lessons.add(new Lesson("LESSON 4","How can we move the cursor on the screen of the computer?"));
        lessons.add(new Lesson("LESSON 5","Which part of a computer is it? Which computer components can you find inside of it?"));
        lessons.add(new Lesson("LESSON 6","Which part of a computer system is it?"));
        lessons.add(new Lesson("LESSON 7","Are you editing large picture files or high-definition video? Are you not able to watch your DVDs or other movies in the best resolution?"));
        lessons.add(new Lesson("LESSON 8","How can we produce a text or a document in computing?"));
        lessons.add(new Lesson("LESSON 9","What for do we use scanner?"));
        lessons.add(new Lesson("LESSON 10","What is a computer storage device?"));
        lessons.add(new Lesson("LESSON 11","What is microprocessor for computers?"));
        lessons.add(new Lesson("LESSON 12","What Is a Modem in Computer Networking?"));


    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
