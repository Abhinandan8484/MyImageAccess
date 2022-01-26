package com.example.myimageaccess;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    Button btnch;
    ImageView imgview1;
    int SELECT_IMAGE=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnch=findViewById(R.id.btnchoose);
        imgview1=findViewById(R.id.imgview1);

        btnch.setOnClickListener(view -> {

            openImageChooser();

        });

    }

    public void openImageChooser() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), SELECT_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if (requestCode==SELECT_IMAGE){
                final Uri selectedImageUri=data.getData();
                Log.i("imageUrl: ",selectedImageUri.toString());
                if (null!=selectedImageUri){
                    imgview1.setImageURI(selectedImageUri);

                }
                else{
                    Toast.makeText(this, "Image not Selected Successfully", Toast.LENGTH_LONG).show();
                }

            }
        }
}
}