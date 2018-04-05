package com.ericalarcon.basicframework.Templates;

import android.app.FragmentManager;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ericalarcon.basicframework.R;

@SuppressWarnings("unused")
/**

 */
public abstract class TabsFragment extends Fragment {
    public abstract android.app.Fragment getTabFragment(int position);
    public abstract int getTabCount();
    public abstract TabGravityItemType getTabGravity();
    public abstract String getTabTitle(int position);
    public abstract Integer getTabIcon(int position);
    public abstract Integer getTabIconTint(int position);
    public abstract void didSelectTab(TabLayout.Tab tab);
    public abstract void viewCreated();

    public SectionsPagerAdapter pagerAdapter;

    //ActionBarMenu if is independent of the tab selected
    private BFMenu generalMenu;

    //ActionBarMenus if is dependent of the tab selected
    private SparseArray<BFMenu> menusMap;
    public SparseArray<BFMenu> getMenusMap() {
        if(menusMap == null){
            menusMap = new SparseArray<>();
        }
        return menusMap;
    }

    private Integer currentTab = 0;

    public TabsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tabs, container, false);
        //remove the bottom shadow of the actionBar
        if(((AppCompatActivity)getActivity()).getSupportActionBar() != null)
            //noinspection ConstantConditions
            ((AppCompatActivity)getActivity()).getSupportActionBar().setElevation(0);

        pagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager;

        mViewPager = (ViewPager) view.findViewById(R.id.container);
        mViewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        //tab selected listener
        tabLayout.addOnTabSelectedListener( new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                currentTab = tab.getPosition();
                didSelectTab(tab); //abstract method that must be implemented by the child
            }
        });

        //Set tab icons if necessary
        for (int i = 0; i < getTabCount(); i++) {
            if(getTabIcon(i) != null){
                //noinspection ConstantConditions
                tabLayout.getTabAt(i).setIcon(getTabIcon(i)); //call abstract method getTabIcon that must be implemented by the child
            }

            if(getTabIconTint(i) != null){
                //noinspection ConstantConditions
                tabLayout.getTabAt(i).getIcon().setColorFilter(getTabIconTint(i), PorterDuff.Mode.SRC_IN);//call abstract method getTabIconTint that must be implemented by the child
            }
        }

        //Set gravity of the tabs
        if (getTabGravity() == TabGravityItemType.FILL){
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        }
        else if (getTabGravity() == TabGravityItemType.CENTER){
            tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        }
        //abstract method, in case the child wants to perform additional operations
        viewCreated();
        didSelectTab(tabLayout.getTabAt(0));
        return view;
    }


    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.app.Fragment getItem(int position) {
            return getTabFragment(position);
        }

        @Override
        public int getCount() {
            return getTabCount();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getTabTitle(position);
        }
    }


    public enum TabGravityItemType{
        FILL , // =0
        CENTER // = 1
    }
}
