package com.example.learningfoodapp.ui.favourite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.learningfoodapp.R;
import com.example.learningfoodapp.fragments.FragmentApdapter;
import com.google.android.material.tabs.TabLayout;


public class FavourateFragment extends Fragment {

TabLayout tabLayout;
ViewPager2 viewPager2;
FragmentApdapter fragmentApdapter;
private FragmentActivity myContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_favourate,container,false);
         tabLayout=root.findViewById(R.id.tab_layout);
        viewPager2=root.findViewById(R.id.view_page2);
        FragmentManager fm=getActivity().getSupportFragmentManager();
        fragmentApdapter=new FragmentApdapter(fm,getLifecycle());
        viewPager2.setAdapter(fragmentApdapter);
         tabLayout.addTab(tabLayout.newTab().setText("Feature"));
        tabLayout.addTab(tabLayout.newTab().setText("populate"));
        tabLayout.addTab(tabLayout.newTab().setText("New"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

         viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
             @Override
             public void onPageSelected(int position) {
                 tabLayout.selectTab(tabLayout.getTabAt(position));
             }
         });
        return root;
    }


}