package com.jovhengshuapps.aquainfinity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ericalarcon.basicframework.Templates.BFMenu;
import com.ericalarcon.basicframework.Templates.BFMenuItem;
import com.ericalarcon.basicframework.Templates.NavigationActivity;
import com.jovhengshuapps.aquainfinity.barcode.BarcodeCaptureActivity;

public class DefaultPageFragment extends Fragment {



    int BARCODE_READER_REQUEST_CODE = 1;

    ViewGroup fragmentView;
    Context fragmentContext;

    public DefaultPageFragment() {

    }


    public DefaultPageFragment(Context context) {
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
            fragmentView = (ViewGroup) localInflater.inflate(R.layout.fragment_defaultpage, null, false);
        } catch (InflateException e) {

        }

        castViews();

        return fragmentView;
    }

    private void castViews(){
        Button btnScan = (Button) fragmentView.findViewById(R.id.buttonScanQR);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent barcodeIntent = new Intent(fragmentContext, BarcodeCaptureActivity.class);
                startActivityForResult(barcodeIntent, BARCODE_READER_REQUEST_CODE);
            }
        });




        BFMenu menu1 = new BFMenu();


        menu1.addItem(new BFMenuItem("View Customer Details",
                R.mipmap.dummy_file_icon,
                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
                new BFMenuItem.BFMenuItemListener() {
                    @Override
                    public void onClick() {

                    }
                }));
        menu1.addItem(new BFMenuItem("Take New Order",
                R.mipmap.dummy_file_icon,
                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
                new BFMenuItem.BFMenuItemListener() {
                    @Override
                    public void onClick() {

                    }
                }));
        menu1.addItem(new BFMenuItem("View Transaction History",
                R.mipmap.dummy_file_icon,
                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
                new BFMenuItem.BFMenuItemListener() {
                    @Override
                    public void onClick() {

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

        MainActivity main = (MainActivity) fragmentContext;
        main.replaceActionBarMenu(menu1);

    }


    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_root, container, false);
//    }
}
