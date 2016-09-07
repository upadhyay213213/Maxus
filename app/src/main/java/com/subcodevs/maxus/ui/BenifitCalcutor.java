package com.subcodevs.maxus.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.subcodevs.maxus.R;
import com.subcodevs.maxus.constants.Contants;
import com.subcodevs.maxus.db.DataBaseQuery;
import com.subcodevs.maxus.db.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by nupadhay on 5/15/2016.
 */
public class BenifitCalcutor extends Activity {

    private RelativeLayout mRel2, mRel3, mRel4;
    private RelativeLayout mRel1;
    private ArrayList<String> mCommonLaw = new ArrayList<>();
    private Spinner mSp1, mSp2, mSp3, mSp4;
    private TextView textBussiness;
    private EditText bussinessEditText;
    private EditText commonLawEditText;
    private EditText comoensationEditText;
    private EditText ageEditText;
    private String commanLaw;
    private String busnisessName;
    private String compensation;
    private String ageSelected;
    private Button mCalculate;
    private ImageView mInformationBenifactor;
    private RelativeLayout relativeLayout;
    private TextView home;
    private TextView services;
    private TextView financialApp;
    private TextView contactUSMenu;
    private boolean first=true;

    private Integer[] mAgeArray = {30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90};
    private Integer[] mCompensationArray = {55000, 60000, 65000, 70000, 75000, 80000, 85000, 90000, 95000, 100000, 105000, 110000, 115000, 120000, 125000, 130000, 135000, 140000, 145000, 150000, 155000, 160000, 165000, 170000
            , 175000, 180000, 185000, 190000, 195000, 200000, 205000, 210000, 215000, 220000, 225000
            , 230000, 235000, 240000, 245000, 250000, 255000, 260000, 265000};
    private String[] mBussinessArray = {
            "Other",
            "Actuaries"
            , "Architects"
            , "Attorneys at Law"
            , "Chiropractor"
            , "Dentist"
            , "Draftsmen"
            , "Osteopaths"
            , "Other licensed practitioner ,of the healing arts"
            , "Performing Arts"
            , "Physician"
            , "Psychologists"
            , "Public Accountants"
            , "Public Engineers"
            , "Social or Physical Scientists"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benefit_calculator);
        initializeUiView();
    }

    private void initializeUiView() {
        DatabaseHelper.init(this);
        findViewById(R.id.homeBackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BenifitCalcutor.this.finish();
                startActivity(new Intent(BenifitCalcutor.this, HomeScreen.class));
            }
        });

        findViewById(R.id.informationBenifactor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Information dialog = Information.newInstance();
                dialog.show(getFragmentManager(), "dialog.inf.finance");
            }
        });
        mCalculate = (Button) findViewById(R.id.calculate);
        ageEditText = (EditText) findViewById(R.id.ageEditTextID);
        comoensationEditText = (EditText) findViewById(R.id.comoensationEditTextID);
        commonLawEditText = (EditText) findViewById(R.id.commonLawEditTextID);
        bussinessEditText = (EditText) findViewById(R.id.bussinessEditTextID);
        mSp1 = (Spinner) findViewById(R.id.bussinessSpinnerID);
        mSp2 = (Spinner) findViewById(R.id.CommonLawSpinnerID);
        mSp3 = (Spinner) findViewById(R.id.compensationSpinnerID);
        mSp4 = (Spinner) findViewById(R.id.ageSpinnerID);


        mRel1 = (RelativeLayout) findViewById(R.id.bussinessRelID);
        mRel2 = (RelativeLayout) findViewById(R.id.commonLawRelID);
        mRel3 = (RelativeLayout) findViewById(R.id.compensationRelID);
        mRel4 = (RelativeLayout) findViewById(R.id.agerelID);
        mCommonLaw.add("None");
        mCommonLaw.add("1-25");
        mCommonLaw.add("26 or more");



        mSp1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                busnisessName = parent.getItemAtPosition(position).toString();
                bussinessEditText.setText(busnisessName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSp2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                commanLaw = parent.getItemAtPosition(position).toString();
                commonLawEditText.setText(commanLaw);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSp3.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                compensation = parent.getItemAtPosition(position).toString();
                comoensationEditText.setText("$ " + compensation);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSp4.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ageSelected = parent.getItemAtPosition(position).toString();
                ageEditText.setText(ageSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> businessApdapter = new ArrayAdapter<String>(BenifitCalcutor.this, android.R.layout.simple_spinner_item, mBussinessArray); //selected item will look like a spinner set from XML
        businessApdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSp1.setAdapter(businessApdapter);


        final ArrayAdapter<String> commonLaw = new ArrayAdapter<String>(BenifitCalcutor.this, android.R.layout.simple_spinner_item, mCommonLaw); //selected item will look like a spinner set from XML
        commonLaw.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSp2.setAdapter(commonLaw);


        final ArrayAdapter<Integer> compensation = new ArrayAdapter<Integer>(BenifitCalcutor.this, android.R.layout.simple_spinner_item, mCompensationArray); //selected item will look like a spinner set from XML
        compensation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSp3.setAdapter(compensation);


        final ArrayAdapter<Integer> age = new ArrayAdapter<Integer>(BenifitCalcutor.this, android.R.layout.simple_spinner_item, mAgeArray); //selected item will look like a spinner set from XML
        age.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSp4.setAdapter(age);


        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calculation=calculate();
                Intent intent = new Intent(BenifitCalcutor.this,CalulationresultScreen.class);
                intent.putExtra("calculation",calculation);
                startActivity(intent);
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
                startActivity(new Intent(BenifitCalcutor.this, HomeScreen.class));
            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(BenifitCalcutor.this, MaxusActivity.class));
            }
        });
        financialApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(BenifitCalcutor.this, FinanceActivity.class));

            }
        });
        contactUSMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(BenifitCalcutor.this, ContactUS.class));
            }
        });


    }

    private String calculate() {
        String calculation = "";
        if (commanLaw.equals("None")) {
            calculation = DataBaseQuery.getCalculationNon(ageSelected, Contants.formatCompensation(compensation));
        }else
        if (busnisessName.equals("Other") && commanLaw.equals("1-25")) {
            calculation = DataBaseQuery.getCalculation(ageSelected, Contants.formatCompensation(compensation));
        }else
        if (!busnisessName.equals("Other") && commanLaw.equals("1-25")) {
            calculation = DataBaseQuery.getCalculationNon(ageSelected, Contants.formatCompensation(compensation));
        }else
        if (commanLaw.equals("26 or more")) {
            calculation = DataBaseQuery.getCalculation(ageSelected, Contants.formatCompensation(compensation));
        }
        return calculation;
    }
}
