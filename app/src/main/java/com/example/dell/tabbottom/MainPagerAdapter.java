package com.example.dell.tabbottom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by Munish on 10/15/15.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    public MainPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0)
        {
            SearchFragment tab1 = new SearchFragment();
//            tab1.setTvTab("tab1");
            return tab1;
        }
        else if (position==1){
            GitHubFragment tab2 = new GitHubFragment();
//            tab2.setTvTab("tab2");
            return tab2;
        }
        else if (position==3){
            PostsFragment tab3 = new PostsFragment();
//            tab3.setTvTab("tab3");
            return tab3;
        }
        else if (position==4){
            PostsFragment tab4 = new PostsFragment();
//            tab3.setTvTab("tab3");
            return tab4;
        }
        else
        {
            PostsFragment tab5 = new PostsFragment();
//            tab4.setTvTab("tab4");
            return tab5;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return Titles[position];
//    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
