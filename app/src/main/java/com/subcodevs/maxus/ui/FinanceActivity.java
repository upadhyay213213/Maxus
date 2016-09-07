package com.subcodevs.maxus.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.subcodevs.maxus.R;

/**
 * Created by nupadhay on 5/15/2016.
 */
public class FinanceActivity extends FragmentActivity {
    private RelativeLayout relativeLayout;
    private TextView home;
    private TextView services;
    private TextView financialApp;
    private TextView contactUSMenu;
    private boolean first=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.financial_app);
        initializeUI();
    }

    private void initializeUI(){
        findViewById(R.id.informationFinanceID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Information dialog = Information.newInstance();
                dialog.show(getFragmentManager(), "dialog.inf.finance");
            }
        });
        findViewById(R.id.homeBackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FinanceActivity.this.finish();
                startActivity(new Intent(FinanceActivity.this, HomeScreen.class));
            }
        });


        findViewById(R.id.benfitCalculator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinanceActivity.this,BenifitCalcutor.class));
            }
        });


        relativeLayout= (RelativeLayout) findViewById(R.id.menuHomeID);
        relativeLayout.setVisibility(View.GONE);
        findViewById(R.id.headerHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(first) {
                    relativeLayout.setVisibility(View.VISIBLE);
                    first=false;
                }else{
                    relativeLayout.setVisibility(View.GONE);
                    first=true;
                }
            }
        });
        home=(TextView)relativeLayout.findViewById(R.id.home);
        services=(TextView)relativeLayout.findViewById(R.id.services);
        financialApp=(TextView)relativeLayout.findViewById(R.id.financialApp);
        contactUSMenu=(TextView)relativeLayout.findViewById(R.id.contactUSMenu);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(FinanceActivity.this, HomeScreen.class));
            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(FinanceActivity.this, MaxusActivity.class));
            }
        });
        financialApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(FinanceActivity.this, FinanceActivity.class));

            }
        });
        contactUSMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(FinanceActivity.this, ContactUS.class));
            }
        });
    }

}
