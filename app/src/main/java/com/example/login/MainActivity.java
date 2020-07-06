package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private PinView pinView;
    private Button next , log;
    private TextView toptext,textU;
    private TextView employee;
    private ConstraintLayout first,second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toptext = findViewById(R.id.toptext);
        pinView = findViewById(R.id.pinView);
        next = findViewById(R.id.button);

        employee = findViewById(R.id.employee1);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        textU = findViewById(R.id.textView3);

        first.setVisibility(first.VISIBLE);
        second.setVisibility(second.INVISIBLE);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (next.getText().equals("GET OTP")) {
            String name = employee.getText().toString();

            if (TextUtils.isEmpty(name)){
                Toast.makeText(MainActivity.this,"Please enter you Employee ID",Toast.LENGTH_SHORT).show();
            }else {

                next.setText("LOG IN");
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);
            }

        }else if (next.getText().equals("LOG IN")) {
            String OTP = pinView.getText().toString();
            if (OTP.equals("2007")){
                pinView.setLineColor(Color.GREEN);
                textU.setText("OTP Verified");
                textU.setTextColor(Color.GREEN);


            }else {
                pinView.setLineColor(Color.RED);
                textU.setText("Incorrect OTP");
                textU.setTextColor(Color.RED);
            }
        }
    }
}
