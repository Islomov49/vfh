package com.eng.iso.sharipova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eng.iso.sharipova.Fragments.LessonFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.mainFragment,new LessonFragment()).commit();
    }
}
