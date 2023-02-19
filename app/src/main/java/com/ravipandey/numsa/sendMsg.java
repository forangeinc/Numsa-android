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

public class sendMsg extends AppCompatActivity {

    EditText copyEt;
    Button copyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);

        copyEt = findViewById(R.id.copyEt);
        copyBtn = findViewById(R.id.copyBtn);

        String msgView = getIntent().getStringExtra("moveMsg");

        String t = "";

        for (int i = 0; i < msgView.length(); ++i) {
            char ch = msgView.charAt(i);
            if (!t.isEmpty()) {
                t += " ";
            }
            int n = (int)ch - (int)'a' + 1;
            t += String.valueOf(n);
        }

        String out = t.replace("-64","");
//        String result = out.replace("  ", " ");

        copyEt.setText(out);

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copy Successfully", copyEt.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(sendMsg.this, "Copied", Toast.LENGTH_LONG).show(); //for copy button
            }
        });
    }
}