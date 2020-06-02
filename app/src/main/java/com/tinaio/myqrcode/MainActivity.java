package com.tinaio.myqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText textid;
    Button generate_btn;
    ImageView qr_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewVerifying();
    }

    private void ViewVerifying() {
        textid = findViewById(R.id.id);
        generate_btn = findViewById(R.id.gn_qr_code);
        qr_image = findViewById(R.id.qr_image);
    }
}
