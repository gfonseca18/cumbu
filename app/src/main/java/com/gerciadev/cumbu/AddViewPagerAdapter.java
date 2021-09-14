package com.gerciadev.cumbu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class AddViewPagerAdapter extends FragmentStatePagerAdapter {
    public AddViewPagerAdapter(@NonNull @NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DespesasFragment();

            case 1:
                return new ReceitasFragment();
        }
        return null;

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return  "Despesas";

            case 1:
                return "Receitas";
        }
        return null;

    }
}
