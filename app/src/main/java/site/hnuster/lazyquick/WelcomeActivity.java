package site.hnuster.lazyquick;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 *@author putik-663
 *@Time 2022/2/15
 *@Description 欢迎界面，未来可能考虑利用在此界面延迟的三秒为主界面预加载资源，现在还不知道要干啥
 */
public class WelcomeActivity extends AppCompatActivity {

    //run用于判断用户是否第一次启动本页面，故设置为静态
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
                run = true;
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}