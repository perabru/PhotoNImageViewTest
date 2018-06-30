package com.brunopera.photonimageviewtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


//https://inducesmile.com/android/display-captured-photo-in-imageview-using-android-camera-application/
public class MainActivity extends AppCompatActivity {


    private ImageView imgPhoto ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button btnPhoto = (Button) findViewById(R.id.btnPhoto);

        imgPhoto = (ImageView) findViewById(R.id.imgPhoto);

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,7777);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)

    {
        if(requestCode ==  7777 && resultCode== RESULT_OK ){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgPhoto.setImageBitmap(photo);
        }
    }



}
