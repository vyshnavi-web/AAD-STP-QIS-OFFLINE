package com.example.loginregpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginregpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
DbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
    helper=new DbHelper(this);
    }

    public void loginEvent(View view) {
        Cursor c=helper.retriveData();
        StringBuilder record1=new StringBuilder();
        StringBuilder record2=new StringBuilder();
        while (c.moveToNext()){
            record1.append(c.getString(1));
            record2.append(c.getString(2));

        }
        if (binding.etUsername.getText().toString().equals(record1)||binding.etPassword.getText().toString().equals("sai")){
            Toast.makeText(this, "welcome ", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Faild", Toast.LENGTH_SHORT).show();
        }

    }

    public void registerEvent(View view) {
        /*Intent :An Intetion to perfom navigating for one activity/screen to another activty/screen*/
   /*two types
   * 1.Explicit Intent :startActivity(new Intent(this,desti.clss));
   * 2.Implicit Intent */
        startActivity(new Intent(this,RegisterActivity.class));
    }
}