package com.example.telemed;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.telemed.fragments.Aktibo;
import com.example.telemed.fragments.Natapos;

public class Myviewpager extends FragmentStateAdapter {
    public Myviewpager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Aktibo();
            case 1:
                return new Natapos();
            default:
                return new Aktibo();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
