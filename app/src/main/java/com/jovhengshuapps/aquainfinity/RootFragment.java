package com.jovhengshuapps.aquainfinity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ericalarcon.basicframework.Templates.BFMenu;
import com.ericalarcon.basicframework.Templates.NavigationActivity;

public class RootFragment extends Fragment {

//    Button buttonSignIn;



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

        Button btnSignIn = (Button) fragmentView.findViewById(R.id.buttonSignin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DefaultPageFragment defaultPageFragment = new DefaultPageFragment(fragmentContext);

                MainActivity nav =((MainActivity)getActivity());
                nav.pushFragment(defaultPageFragment,NavigationActivity.animationType.RIGHT_TO_LEFT,false);

//                ((MainActivity)fragmentContext).pushFragment(defaultPageFragment, NavigationActivity.animationType.RIGHT_TO_LEFT, true);
            }
        });


        MainActivity nav =((MainActivity)getActivity());
        //nav.replaceActionBarMenu(new BFMenu());
    }

}
