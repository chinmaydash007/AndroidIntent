package com.lilexample.androidintents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MediaActivity extends AppCompatActivity
        implements View.OnClickListener {

    private final static int GET_IMAGE_CAPTURE = 1000;

    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        findViewById(R.id.btnStartCamera).setOnClickListener(this);
        findViewById(R.id.btnOpenURL).setOnClickListener(this);
        findViewById(R.id.btnCapturePic).setOnClickListener(this);
        findViewById(R.id.btnSendText).setOnClickListener(this);

        imgView = (ImageView) findViewById(R.id.imgCapturePic);
    }

    @Override
    public void onClick(View v) {
        int btnClick = v.getId();

        if (btnClick == R.id.btnStartCamera) {
            Intent i = new Intent();
            i.setAction(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA_SECURE);

            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        } else if (btnClick == R.id.btnCapturePic) {

            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


            if (i.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(i, GET_IMAGE_CAPTURE);
            }
        } else if (btnClick == R.id.btnSendText) {
            final String message = "This is a text message";

            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("sms:8895762881"));
            i.putExtra("sms_body", message);
            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        } else if (btnClick == R.id.btnOpenURL) {
            String url = "http://www.google.com";

            Uri webpage = Uri.parse(url);
            Intent i = new Intent(Intent.ACTION_VIEW, webpage);

            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            imgView.setImageBitmap(bitmap);

        }
    }
}
