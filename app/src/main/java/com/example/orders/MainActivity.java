package com.example.orders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
private TabLayout tabLayout;
private ViewPager viewPager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager1);
        tabLayout.setupWithViewPager(viewPager);
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager());
        vpAdapter.addFragment(new Open_orders(),"Open Orders");
        vpAdapter.addFragment(new Positions(),"Positions");
        vpAdapter.addFragment(new Gtt(),"GTT");
        viewPager.setAdapter(vpAdapter);
        int desiredFragmentPosition = 0;
        tabLayout.setScrollPosition(desiredFragmentPosition,0,true);
        viewPager.setCurrentItem(desiredFragmentPosition);


    }


}