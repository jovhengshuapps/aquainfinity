package com.jovhengshuapps.aquainfinity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ericalarcon.basicframework.Templates.BFMenu;
import com.ericalarcon.basicframework.Templates.BFMenuItem;
import com.ericalarcon.basicframework.Templates.NavigationActivity;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.jovhengshuapps.aquainfinity.barcode.BarcodeCaptureActivity;

public class ScanCustomerPageFragment extends Fragment {



    int BARCODE_READER_REQUEST_CODE = 1;

    ViewGroup fragmentView;
    Context fragmentContext;

    public ScanCustomerPageFragment() {

    }


    public ScanCustomerPageFragment(Context context) {
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

//                RootFragment rootFragment = new RootFragment(fragmentContext);
//                MainActivity main = (MainActivity) getActivity();
//                main.pushFragment(rootFragment, NavigationActivity.animationType.RIGHT_TO_LEFT,false);
            }
        });


        final MainActivity main = (MainActivity) getActivity();
        main.setTitle("Scan Customer QR");



        BFMenu menu1 = new BFMenu();
        menu1.addItem(new BFMenuItem("Add User",
                R.drawable.user_plus,
                /*BFMenuItem.BFMenuItemType.SHOW_AS_ACTION_IF_ROOM,*/
                BFMenuItem.BFMenuItemType.SHOW_AS_MENUITEM,
                new BFMenuItem.BFMenuItemListener() {
                    @Override
                    public void onClick() {

                        NewCustomerFragment newCustomerFragment = new NewCustomerFragment(fragmentContext);
                        MainActivity main = (MainActivity) getActivity();
                        main.pushFragment(newCustomerFragment, NavigationActivity.animationType.RIGHT_TO_LEFT,false);
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
                        main.finish();
                    }
                }));


        main.replaceActionBarMenu(menu1);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BARCODE_READER_REQUEST_CODE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);

                    Toast.makeText(fragmentContext, "barcode: " + barcode.displayValue,
                            Toast.LENGTH_LONG).show();

                    RootFragment rootFragment = new RootFragment(fragmentContext);
                    MainActivity main = (MainActivity) getActivity();
                    main.pushFragment(rootFragment, NavigationActivity.animationType.RIGHT_TO_LEFT,false);

//                    val barcode = data.getParcelableExtra<Barcode>(BarcodeCaptureActivity.BarcodeObject)
//                            val p = barcode.cornerPoints
//                    mResultTextView.text = barcode.displayValue
                } else {

                    Toast.makeText(fragmentContext, String.format(getString(R.string.no_barcode_captured)),
                            Toast.LENGTH_LONG).show();
                }
            } else {

                Toast.makeText(fragmentContext, String.format(getString(R.string.barcode_error_format),
                        CommonStatusCodes.getStatusCodeString(resultCode)),
                        Toast.LENGTH_LONG).show();
            }
        } else
            super.onActivityResult(requestCode, resultCode, data);
    }


    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_root, container, false);
//    }
}
