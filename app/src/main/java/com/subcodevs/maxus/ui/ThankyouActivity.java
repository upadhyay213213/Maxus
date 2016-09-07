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
public class ThankyouActivity extends Activity implements View.OnClickListener{

    private Button mViewFinanceApp,mBackToHomePage;
    private RelativeLayout relativeLayout;
    private TextView home;
    private TextView services;
    private TextView financialApp;
    private TextView contactUSMenu;
    private boolean first=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou_screen);
        initializeUiView();
    }

    private void initializeUiView(){
        mViewFinanceApp = (Button) findViewById(R.id.viewFinancilApp);
        mViewFinanceApp.setOnClickListener(this);
        mBackToHomePage = (Button) findViewById(R.id.gotoHomePageId);
        mBackToHomePage.setOnClickListener(this);

        findViewById(R.id.homeBackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThankyouActivity.this.finish();
                startActivity(new Intent(ThankyouActivity.this, HomeScreen.class));
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
                startActivity(new Intent(ThankyouActivity.this, HomeScreen.class));
            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(ThankyouActivity.this, MaxusActivity.class));
            }
        });
        financialApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(ThankyouActivity.this, FinanceActivity.class));

            }
        });
        contactUSMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(ThankyouActivity.this, ContactUS.class));
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.viewFinancilApp:
                ThankyouActivity.this.finish();
                startActivity(new Intent(ThankyouActivity.this,FinanceActivity.class));
                break;
            case R.id.gotoHomePageId:
                this.finish();
                startActivity(new Intent(ThankyouActivity.this,HomeScreen.class));
                break;
        }
    }
}
