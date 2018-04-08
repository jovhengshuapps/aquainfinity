package com.jovhengshuapps.aquainfinity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ericalarcon.basicframework.Templates.BFMenu;
import com.ericalarcon.basicframework.Templates.BFMenuItem;
import com.ericalarcon.basicframework.Templates.NavigationActivity;

public class RootFragment extends Fragment {

    ViewGroup fragmentView;
    Context fragmentContext;

    public RootFragment() {

    }


    public RootFragment(Context context) {
        this.fragmentContext = context;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater localInflater = inflater.cloneInContext(fragmentContext);

        if (fragmentView != null) {
            ViewGroup parent = (ViewGroup) fragmentView.getParent();
            if (parent != null)
                parent.removeView(fragmentView);
        }
        try {
            fragmentView = (ViewGroup) localInflater.inflate(R.layout.fragment_root, null, false);
        } catch (InflateException e) {

        }

        castViews();

        return fragmentView;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_root, container, false);
//    }

    private void castViews(){


        BFMenu menu1 = new BFMenu();


        menu1.addItem(new BFMenuItem("View Customer Details",
                R.mipmap.dummy_file_icon,
                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
                null).disabled(true));
        menu1.addItem(new BFMenuItem("Take New Order",
                R.mipmap.dummy_file_icon,
                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
                new BFMenuItem.BFMenuItemListener() {
                    @Override
                    public void onClick() {

                        RootFragment rootFragment = new RootFragment(fragmentContext);
                        MainActivity main = (MainActivity) getActivity();
                        main.pushFragment(rootFragment, NavigationActivity.animationType.RIGHT_TO_LEFT,false);
                    }
                }));
        menu1.addItem(new BFMenuItem("View Transaction History",
                R.mipmap.dummy_file_icon,
                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
                new BFMenuItem.BFMenuItemListener() {
                    @Override
                    public void onClick() {
                        Log.d("TEST","NA CLICK AKO");
                    }
                }));
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

        MainActivity main = (MainActivity) getActivity();
        //MainActivity main = (MainActivity) fragmentContext;
        main.replaceActionBarMenu(menu1);


        main.setTitle("Customer Details");

        Button button = (Button) fragmentView.findViewById(R.id.buttonNewOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity main = (MainActivity) getActivity();
                NewOrderFragment rootFragment = new NewOrderFragment(fragmentContext);
                main.pushFragment(rootFragment, NavigationActivity.animationType.RIGHT_TO_LEFT,false);
            }
        });




    }

}
