package com.jovhengshuapps.aquainfinity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ericalarcon.basicframework.Templates.NavigationActivity;

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        castViews();
    }


    private void castViews(){

        Button btnSignIn = (Button) findViewById(R.id.buttonSignin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignIn();
            }
        });


    }

    public void showSignIn() {

        final Dialog dialog = new Dialog(SignInActivity.this); // Context, this, etc.
        dialog.setContentView(R.layout.login_view);
        Button submitSignIn = (Button) dialog.findViewById(R.id.buttonSubmitSignIn);
        submitSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.hide();
                dialog.dismiss();
                Intent intentToMain = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intentToMain);
            }
        });
        dialog.show();
    }




}
