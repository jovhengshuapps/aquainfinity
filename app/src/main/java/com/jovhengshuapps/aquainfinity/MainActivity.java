package com.jovhengshuapps.aquainfinity;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.ericalarcon.basicframework.Templates.BFMenu;
import com.ericalarcon.basicframework.Templates.BFMenuItem;
import com.ericalarcon.basicframework.Templates.NavigationActivity;

public class MainActivity extends NavigationActivity {
    @Override
    public Fragment firstFragment() {
        //return the first fragment that will be shown
        //jump to the TabsFragment of ListFragment sections
        //of this document to see how to do it
        //(or you can create your own simple Fragment, of course)



        BFMenu menu1 = new BFMenu();


//        menu1.addItem(new BFMenuItem("View Customer Details",
//                R.mipmap.dummy_file_icon,
//                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
//                new BFMenuItem.BFMenuItemListener() {
//                    @Override
//                    public void onClick() {
//
//                    }
//                }));
//        menu1.addItem(new BFMenuItem("Take New Order",
//                R.mipmap.dummy_file_icon,
//                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
//                new BFMenuItem.BFMenuItemListener() {
//                    @Override
//                    public void onClick() {
//
//                    }
//                }));
//        menu1.addItem(new BFMenuItem("View Transaction History",
//                R.mipmap.dummy_file_icon,
//                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
//                new BFMenuItem.BFMenuItemListener() {
//                    @Override
//                    public void onClick() {
//
//                    }
//                }));
        menu1.addItem(new BFMenuItem("My Profile",
                R.mipmap.dummy_file_icon,
                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
                new BFMenuItem.BFMenuItemListener() {
                    @Override
                    public void onClick() {

                    }
                }));
        menu1.addItem(new BFMenuItem("Sign Out",
                R.mipmap.dummy_file_icon,
                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
                new BFMenuItem.BFMenuItemListener() {
                    @Override
                    public void onClick() {

                    }
                }));


        this.addActionBarMenu(menu1);



        return new ScanCustomerPageFragment(this);
    }


    @Override
    public Boolean showBackButtonInFirstFragment() {
        //show back button already in the first Fragment
        //set to True if this activity is called by another Activity
        //the back button will then pop back to the previous Activity

        return false;
    }

    @Override
    public Boolean showMasterDetailLayoutInTablets() {
        //set to false if you don't want a master-detail layout in tablets

        return false;
    }




}
