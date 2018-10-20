package com.tugas.apptugas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    String username ="admin";
    String password ="admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //hubungkan id di layout ke java
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin =findViewById(R.id.btn_login);

        //disini kita bikin metode ketika button di klik
        //caranya tinggal ketik yang bawah lalu nanti merah, langsung kita implement method aja
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String inputUsername = etUsername.getText().toString();
               String inputPassword = etPassword.getText().toString();

               //cek login
                //jika keduanya salah
                if (!inputUsername.equals(username)&&!inputPassword.equals(password)){
                    Toast.makeText(getApplicationContext(),"usernama dan password salah!!",Toast.LENGTH_SHORT).show();
                }
                else if (!inputUsername.equals(username)|| !inputPassword.equals(password)){
                    Toast.makeText(getApplicationContext(),"Username atau password salah!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    //agar username atau password saat login tidak nyangkut di set jadi null
                    etUsername.setText(null);
                    etPassword.setText(null);
                    startActivity(new Intent(getApplicationContext(), ListActivity.class));
                }
            }
        });{


        }
    }
}
