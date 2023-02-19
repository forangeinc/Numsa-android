package com.ravipandey.numsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class sendpage extends AppCompatActivity {

    EditText msgEt;
    Button conBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendpage);

        msgEt = findViewById(R.id.msgEt);
        conBtn = findViewById(R.id.conBtn);

        conBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txt = msgEt.getText().toString();

                Intent intent = new Intent(sendpage.this, sendMsg.class);

                intent.putExtra("moveMsg", txt.toLowerCase(Locale.ROOT));

                startActivity(intent);
            }
        });

    }
}