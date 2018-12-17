package com.example.eren.a12bir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class uyeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uye);


        final EditText uyeName = (EditText) findViewById(R.id.ad);
        final EditText uyeLastName = (EditText) findViewById(R.id.soyad);
        final EditText uyePhone = (EditText) findViewById(R.id.numberid);
        final EditText uyeMail = (EditText) findViewById(R.id.posta);
        final EditText uyePassword = (EditText) findViewById(R.id.sifre);
        Button btnKaydet = (Button) findViewById(R.id.uyeol);
        Log.d("Click","No");

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = uyeName.getText().toString();
                String lastname = uyeLastName.getText().toString();
                String phone = uyePhone.getText().toString();
                String mail = uyeMail.getText().toString();
                String password = uyePassword.getText().toString();
                Database vt = new Database(uyeActivity.this);
                vt.addData(name, lastname, phone,mail,password);

                Log.d("Click","Yes");
            }

        });



        final Button button = (Button) findViewById(R.id.uyeol);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });



    }
}
