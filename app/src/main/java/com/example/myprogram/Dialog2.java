package com.example.myprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Dialog2 extends AppCompatActivity implements View.OnClickListener {

    TextView textView, textView2, back;
    Button btn_cancel, btn_ok;

    int colorBack = R.color.white;
    int colorText = R.color.black;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog2);



//        textView = findViewById(R.id.textView);
//        textView.setOnClickListener(this);
//
//        back = findViewById(R.id.back);


//        textView2 = findViewById(R.id.textView2);
//        textView2.setOnClickListener( this);

        btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);

        btn_ok = findViewById(R.id.btn_okay);
        btn_ok.setOnClickListener(this);


        colorBack = getIntent().getIntExtra("COLOR_BACK", R.color.white);
        colorText = getIntent().getIntExtra("COLOR_TEXT", R.color.black);

        textView.setTextColor(getResources().getColor(colorText));
        back.setBackgroundColor(getResources().getColor(colorText));

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
