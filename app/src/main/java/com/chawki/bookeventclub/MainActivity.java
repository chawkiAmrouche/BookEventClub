package com.chawki.bookeventclub;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    protected SekizbitSwitch sekizbitSwitch;
    protected ImageView ImageViewDrawerToggle;
    protected ImageView ImageViewSetting;
    protected ImageView ImageViewSearch;
    private FragmentManager fragmentManager;
    ViewPager todaymenupager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        todaymenupager = (ViewPager) findViewById(R.id.fragment_layout);

        initView();
    }

    private void initView() {
        sekizbitSwitch = new SekizbitSwitch(findViewById(R.id.sekizbit_switch));
        sekizbitSwitch.setSelected(0);
        TodayMenuPagerAdapter myPagerAdapter = new TodayMenuPagerAdapter(getSupportFragmentManager(), 2, 0);
        todaymenupager.setAdapter(myPagerAdapter);
        todaymenupager.setCurrentItem(0);
        sekizbitSwitch.setOnChangeListener(new SekizbitSwitch.OnSelectedChangeListener() {
            @Override
            public void OnSelectedChange(SekizbitSwitch sender) {
                if (sender.getCheckedIndex() == 0) {
                    TodayMenuPagerAdapter myPagerAdapter = new TodayMenuPagerAdapter(getSupportFragmentManager(), 2, 0);
                    todaymenupager.setAdapter(myPagerAdapter);
                    todaymenupager.setCurrentItem(0);
                } else {
                    TodayMenuPagerAdapter myPagerAdapter = new TodayMenuPagerAdapter(getSupportFragmentManager(), 2, 1);
                    todaymenupager.setAdapter(myPagerAdapter);
                    todaymenupager.setCurrentItem(1);
                }
            }
        });

    }

    private void setupFragment(int pos) {

        if (pos == 0) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_layout, new EventsFragment());
            transaction.commit();
        } else {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_layout, new ClubFragment());
            transaction.commit();
        }

    }

}
