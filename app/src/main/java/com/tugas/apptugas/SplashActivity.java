package com.tugas.apptugas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //atur layar supaya gak ada nama atau titlenya (Step1)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //atur suapaya layar full
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        //untuk delay activitynya atau waktu lamanya splash screen
        new Handler().postDelayed(new Runnable() { //(step2 tapi yang bawah belom bisa di set kalo step 3 belom di buat)
            @Override
            public void run() {
                finish();
                //ini adalah cara dimana ketika kita sudah selesai dengan splash screennya, kita mau masuk ke aktivity mana
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        },3500);// bisa pake step3 atau langsung isi lama delaynya di step 2 ini (3500 = 3,5 detik)

    }
}
