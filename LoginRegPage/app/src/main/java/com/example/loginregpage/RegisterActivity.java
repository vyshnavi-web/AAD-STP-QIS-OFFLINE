package com.example.loginregpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginregpage.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
ActivityRegisterBinding binding;
DbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_register);
   helper=new DbHelper(this);
    }

    public void saveData(View view) {
        ContentValues cn=new ContentValues();
        cn.put(helper.col_1,binding.etRegUsername.getText().toString());
        cn.put(helper.col_2,binding.etRegPassword.getText().toString());
        //cn.put(helper.COL_2,binding.etRegEmail.getText().toString());
        long row=helper.savaData(cn);
        Toast.makeText(this, binding.etRegUsername.getText().toString()
                +"Inserted Sucessfully: "+row, Toast.LENGTH_SHORT).show();
    }
}