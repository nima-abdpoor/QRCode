package com.tinaio.myqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

public class MainActivity extends AppCompatActivity {

    EditText textid;
    Button generate_btn;
    ImageView qr_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewVerifying();
        generate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQRCode();
            }
        });
    }

    private void generateQRCode() {
        qr_image.setVisibility(View.VISIBLE);
        String id = textid.getText().toString();
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point =new Point();
        display.getSize(point);
        int x = point.x;
        int y = point.y;
        int icon = x < y ? x:y;
//        icon*=3/4;
        QRCodeEncoder qrCodeEncoder =new QRCodeEncoder(id ,null,
                Contents.Type.TEXT, BarcodeFormat.QR_CODE.toString()
                ,icon);
        try {
            Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
            qr_image.setImageBitmap(bitmap);
            generate_btn.setVisibility(View.INVISIBLE);
            textid.setVisibility(View.INVISIBLE);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    private void ViewVerifying() {
        textid = findViewById(R.id.id);
        generate_btn = findViewById(R.id.gn_qr_code);
        qr_image = findViewById(R.id.qr_image);
    }
}
