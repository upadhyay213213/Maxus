package com.subcodevs.maxus.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.subcodevs.maxus.R;

/**
 * Created by nupadhay on 5/15/2016.
 */
public class ContactUS extends Activity {

    private EditText mName, mEmail, mPhone, mComment;
    private Button mSubmitButtonID;
    private String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private RelativeLayout relativeLayout;
    private TextView home;
    private TextView services;
    private TextView financialApp;
    private TextView contactUSMenu;
    private boolean first=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        intializeUiView();
    }

    private void intializeUiView() {
        findViewById(R.id.informationContactID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InformationContact dialog = InformationContact.newInstance();
                dialog.show(getFragmentManager(), "dialog.infcontact.finance");
            }
        });

        findViewById(R.id.homeBackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactUS.this.finish();
                startActivity(new Intent(ContactUS.this, HomeScreen.class));
            }
        });
        mSubmitButtonID = (Button) findViewById(R.id.submitButtonID);
        mName = (EditText) findViewById(R.id.contactUSNameID);
        mEmail = (EditText) findViewById(R.id.contactUSEmailID);
        mPhone = (EditText) findViewById(R.id.contactUSPhoneID);
        mComment = (EditText) findViewById(R.id.contactUSCommentID);

        mSubmitButtonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateDetails(mName.getText().toString(), mEmail.getText().toString(), mPhone.getText().toString(), mComment.getText().toString())) {
                    startActivity(new Intent(ContactUS.this, ThankyouActivity.class));
                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    emailIntent.setType("vnd.android.cursor.item/email");
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"nandan@subcodevs.com"});
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Enquiry Email");
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Name: " + mName.getText().toString() + "Email: " + mEmail.getText().toString() + "Phone Number: " + mPhone.getText().toString() + "Comment: " + mComment.getText().toString());
                    startActivity(Intent.createChooser(emailIntent, "Send mail using..."));
                }

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
                startActivity(new Intent(ContactUS.this, HomeScreen.class));
            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(ContactUS.this, MaxusActivity.class));
            }
        });
        financialApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(ContactUS.this, FinanceActivity.class));

            }
        });
        contactUSMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first=false;
                relativeLayout.setVisibility(View.GONE);
                startActivity(new Intent(ContactUS.this, ContactUS.class));
            }
        });
    }


    private boolean validateDetails(String name, String email, String phone, String comment) {

        if (name.toString().length() != 0 || email.toString().length() != 0 || phone.toString().length() != 0 || comment.toString().length() != 0) {

            if (email.toString().length() != 0) {
                if (email.trim().matches(emailPattern)) {
                    return true;
                } else {
                    makeToast("Please enter a valid email address");
                    return false;
                }
            } else {
                return true;
            }

        } else {
            makeToast("Please enter at least one field");
            return false;
        }

    }

    private void makeToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
