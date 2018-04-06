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
//                Intent barcodeIntent = new Intent(fragmentContext, BarcodeCaptureActivity.class);
//                startActivityForResult(barcodeIntent, BARCODE_READER_REQUEST_CODE);

                RootFragment rootFragment = new RootFragment(fragmentContext);
                MainActivity main = (MainActivity) getActivity();
                main.pushFragment(rootFragment, NavigationActivity.animationType.RIGHT_TO_LEFT,false);
            }
        });





    }


    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_root, container, false);
//    }
}
