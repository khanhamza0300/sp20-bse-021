package com.example.programaticfragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LeftFragment.Communication{
    private FragmentManager fragMan;
    private FragmentTransaction fragTrans;
    private LeftFragment leftFragment;
    private RightFragment rightFragment;

    private SharedViewModel sharedViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        sharedViewModel.initialize();

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {
            fragMan = getSupportFragmentManager();
            fragTrans = fragMan.beginTransaction();
            leftFragment = LeftFragment.newInstance();
            rightFragment = RightFragment.newInstance();
            fragTrans.replace(R.id.frameLayout1, leftFragment);
            fragTrans.replace(R.id.frameLayout2, rightFragment);
            fragTrans.commitNow();
        }
    }

    @Override
    public void addRecord() {
        fragTrans = fragMan.beginTransaction();
      addrecord  AddFragment = addrecord.newInstance();
        fragTrans.replace(R.id.frameLayout2, AddFragment);
        fragTrans.commitNow();
    }
}