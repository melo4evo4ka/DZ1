package com.example.dz1;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.animation.Animation;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    // btn_get
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
       // startActivityForResult(intent,12345);

        switch (view.getId()){
            case R.id.btn_get:
                startActivityForResult(intent,12345);
                break;
            case R.id.btn_back:
                this.finish();
        }

    }

   @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 12345){
            if (resultCode == RESULT_OK){
                Uri uri = data.getData();
                Bitmap bitmap = null;
                ImageView imageView = findViewById(R.id.imView);
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
                    bitmap = Bitmap.createBitmap(bitmap,0,0,256,256);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bitmap != null){
                        imageView.setImageBitmap(bitmap);
                    } else {
                        imageView.setImageURI(uri);
                    }
                }
                imageView.setBackgroundColor(0b0);
                imageView.setImageURI(uri);
            }else {
                Toast.makeText(this, "image not choose", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
