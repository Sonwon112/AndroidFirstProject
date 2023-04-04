package com.example.firstpersonalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    Button btnSave;
    ImageButton imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        btnSave = (Button) findViewById(R.id.btnSave);
        imgBtn = (ImageButton) findViewById(R.id.imgBtn);

        btnSave.setOnClickListener(view -> {
            Toast.makeText(this, "프로필을 저장하였습니다", Toast.LENGTH_SHORT).show();
            finish();
        });

        imgBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });
    }
}