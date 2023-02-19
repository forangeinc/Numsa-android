package com.ravipandey.numsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class receiveMsg extends AppCompatActivity {

    EditText copyEt;
    Button copyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);

        copyEt = findViewById(R.id.copyEt);
        copyBtn = findViewById(R.id.copyBtn);

        String msgView = getIntent().getStringExtra("moveMsg");

        String s = "0abcdefghijklmnopqrstuvwxyz";

        String[] numbersArray = msgView.split(" ");

        StringBuilder result = new StringBuilder();
        for (String number : numbersArray)
        {
            if (number.isEmpty())
            {
                result.append(" ");
            } else
            {
                int num = Integer.parseInt(number);
                result.append((char)('A' + num - 1));
            }
        }

//        String[] txt = msgView.split(" ");
//        StringBuilder result = new StringBuilder();
//
//        for (String text : txt) {
//            int num = Integer.parseInt(text);
//            if(num>0&&num<=26) {
//                result.append((char)(num+64));
//            } else {
//                return;
//            }
//        }

        copyEt.setText(result.toString());

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copy Successfully", copyEt.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(receiveMsg.this, "Copied", Toast.LENGTH_LONG).show(); //for copy button
            }
        });
    }
}