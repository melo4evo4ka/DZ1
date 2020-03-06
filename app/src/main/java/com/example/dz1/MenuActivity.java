package com.example.dz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_menu1:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.btn_menu2:
                this.finish();
        }
    }
}
