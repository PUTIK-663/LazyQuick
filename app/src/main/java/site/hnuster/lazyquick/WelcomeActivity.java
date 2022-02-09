package site.hnuster.lazyquick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println("初始化完毕...");
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}