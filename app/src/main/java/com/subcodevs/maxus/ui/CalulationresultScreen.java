package com.subcodevs.maxus.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.subcodevs.maxus.R;

/**
 * Created by nupadhay on 5/17/2016.
 */
public class CalulationresultScreen extends Activity {

    private Button mRecalculate,mConsultation;
    private TextView mResultText;
    private String mResult;
    private RelativeLayout relativeLayout;
    private TextView home;
    private TextView services;
    private TextView financialApp;
    private TextView contactUSMenu;
    private boolean first=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation_result);
        mResult = getIntent().getStringExtra("calculation");
        initializeUiView();
    }

    private void initializeUiView(){
        mResultText = (TextView) findViewById(R.id.resultTextID);
        mResultText.setText("$"+mResult);
        mRecalculate = (Button) findViewById(R.id.recalculate);
        mRecalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalulationresultScreen.this.finish();
                startActivity(new Intent(CalulationresultScreen.this, BenifitCalcutor.class));
            }
        });

        mConsultation = (Button) findViewById(R.id.getconsulation);
        mConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalulationresultScreen.this.finish();
                startActivity(new Intent(CalulationresultScreen.this, ContactUS.class));

            }
        });

        findViewById(R.id.homeBackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalulationresultScreen.this.finish();
                startActivity(new Intent(CalulationresultScreen.this, HomeScreen.class));
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
                startActivity(new Intent(CalulationresultScreen.this, HomeScreen.class));
            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(CalulationresultScreen.this, MaxusActivity.class));
            }
        });
        financialApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(CalulationresultScreen.this, FinanceActivity.class));

            }
        });
        contactUSMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(CalulationresultScreen.this, ContactUS.class));
            }
        });
    }




}
