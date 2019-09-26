package com.result.result;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button butcon;
    EditText nabname, naban, nabiot, nabweb;
    TextView result;
    String status = "";
    int i = 1;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butcon = findViewById(R.id.butcon);
        nabname = findViewById(R.id.txtname);
        naban = findViewById(R.id.amarks);
        nabiot = findViewById(R.id.iot);
        nabweb = findViewById(R.id.web);
        result = findViewById(R.id.result);
        butcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.butcon) {
            double android = 0, iot = 0, web = 0;

            if ((TextUtils.isEmpty(nabname.getText().toString()))) {
                nabname.setError("Please enter name");
                return;
            } else if (TextUtils.isEmpty(naban.getText().toString())) {
                naban.setError("please enter the marks of android");
                return;
            } else if (TextUtils.isEmpty(nabiot.getText().toString())) {
                nabiot.setError("Please enter marks of IOT");
                return;
            } else if (TextUtils.isEmpty(nabweb.getText().toString())) {
                nabweb.setError("Please enter marks of WEB");
                return;

            }
            android = Double.parseDouble(naban.getText().toString());
            iot = Double.parseDouble(nabiot.getText().toString());
            web = Double.parseDouble(nabweb.getText().toString());

            if ((android <= 100) && (android >= 0)) {
                if ((iot <= 100) && (iot >= 0)) {
                    if ((web <= 100) && (web >= 0)) {
                        result.append((i + ") " + " Name: " + nabname.getText().toString()) +
                                " | Android: " + (decimalFormat.format(Double.parseDouble(naban.getText().toString()))) + // decimalFormat.format(Double.parseDouble(etname.getText().toString())))
                                " | IOT: " + (decimalFormat.format(Double.parseDouble(nabiot.getText().toString()))) +
                                " | web: " + (decimalFormat.format(Double.parseDouble(nabweb.getText().toString()))) +
                                " | percentage " + percentage() + " | " + status + "\n");
                        Clear();
                        i++;
                    } else {
                        nabweb.setError("Please enter marks of WEB 0 to 100");
                    }

                } else {
                    nabiot.setError("Please enter marks of IOT 0 to 100");

                }
            } else {
                naban.setError("Please enter marks of Android 0 to 100");

            }
        }
    }

    private void Clear() {
        nabname.setText("");
        naban.setText("");
        nabiot.setText("");
        nabweb.setText("");
    }


    private String percentage() {
        double android = 0, iot = 0, web = 0, per = 0;
        android = Double.parseDouble(decimalFormat.format(Double.parseDouble(naban.getText().toString())));
        iot = Double.parseDouble(decimalFormat.format(Double.parseDouble(nabiot.getText().toString())));
        web = Double.parseDouble(decimalFormat.format(Double.parseDouble(nabweb.getText().toString())));


        per = (android + iot + web) / 3;
        if ((android >= 40) && (iot >= 40) && (web >= 40)) {
            status = "Pass";
        } else {
            status = "fail";
        }

        return decimalFormat.format(per);
    }
}

