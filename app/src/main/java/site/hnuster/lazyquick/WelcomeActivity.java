package site.hnuster.lazyquick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends AppCompatActivity {

    private static boolean run = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (run){
            Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
            //数据传递
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_welcome);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println("初始化中...");
                /*
                    1.检查网络连接
                    2.检查登录状态
                 */
                System.out.println("初始化完毕...");
                run = true;
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                //数据传递
                startActivity(intent);
                finish();
            }
        },3000);
    }
}