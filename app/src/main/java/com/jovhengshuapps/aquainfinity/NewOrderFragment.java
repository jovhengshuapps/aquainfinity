package com.jovhengshuapps.aquainfinity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ScrollView;

import com.ericalarcon.basicframework.Templates.BFMenu;
import com.ericalarcon.basicframework.Templates.BFMenuItem;

public class NewOrderFragment extends Fragment {

    ViewGroup fragmentView;
    Context fragmentContext;

    public NewOrderFragment() {

    }


    public NewOrderFragment(Context context) {
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
            fragmentView = (ViewGroup) localInflater.inflate(R.layout.fragment_neworder, null, false);
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
                new BFMenuItem.BFMenuItemListener() {
                    @Override
                    public void onClick() {

                        MainActivity main = (MainActivity) fragmentContext;
                        main.pop();
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


        Button buttonCancel = (Button) fragmentView.findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity main = (MainActivity) fragmentContext;
                hideKeyboard(main);
            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity main = (MainActivity) fragmentContext;
        hideKeyboard(main);
    }


    public static void hideKeyboard(MainActivity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View currentFocusedView = activity.getCurrentFocus();
        if (currentFocusedView != null) {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
