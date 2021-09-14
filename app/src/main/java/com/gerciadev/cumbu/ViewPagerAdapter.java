package com.gerciadev.cumbu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.gerciadev.cumbu.fragments.AddFragment;
import com.gerciadev.cumbu.fragments.CoinsFragment;
import com.gerciadev.cumbu.fragments.PieFragment;
import com.gerciadev.cumbu.fragments.ToolsFragment;
import com.gerciadev.cumbu.fragments.WalletFragment;

import org.jetbrains.annotations.NotNull;

/**
 * Created by gerciafonseca on 14/09/2021
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull @NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:
               return new CoinsFragment();
           case 1:
               return new AddFragment();
           case 2:
               return new PieFragment();
           case 3:
               return new ToolsFragment();
           case 4:
               return new WalletFragment();
       }
       return null;

    }

    @Override
    public int getCount() {
        return 5;
    }
}
