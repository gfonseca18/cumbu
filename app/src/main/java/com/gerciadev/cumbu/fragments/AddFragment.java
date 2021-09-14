package com.gerciadev.cumbu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.gerciadev.cumbu.AddViewPagerAdapter;
import com.gerciadev.cumbu.CustomViewPage;
import com.gerciadev.cumbu.R;
import com.google.android.material.tabs.TabLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;


public class AddFragment extends Fragment {
 private TabLayout tabLayout;
 private CustomViewPage viewPager;
 private View mView;


    public AddFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.fragment_add,container,false);
        tabLayout = mView.findViewById(R.id.tab_layout);
        viewPager = mView.findViewById(R.id.add_viewpager);



        AddViewPagerAdapter adapter = new AddViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.setPagingEnabled(false);
        tabLayout.setupWithViewPager(viewPager);
        return mView;
    }

}