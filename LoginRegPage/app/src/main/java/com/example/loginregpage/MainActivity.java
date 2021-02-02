package com.example.loginregpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loginregpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
    }

    public void loginEvent(View view) {
    }

    public void registerEvent(View view) {
        /*Intent :An Intetion to perfom navigating for one activity/screen to another activty/screen*/
   /*two types
   * 1.Explicit Intent :startActivity(new Intent(this,desti.clss));
   * 2.Implicit Intent */
        startActivity(new Intent(this,RegisterActivity.class));
    }
}