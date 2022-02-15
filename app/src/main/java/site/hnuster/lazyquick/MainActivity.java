package site.hnuster.lazyquick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context thisContext = this;
    private long exitTime = 0;
    private ImageView userPortraitImg;
    private Button userStatusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * 为了设置沉浸式状态栏，由于其余方法太麻烦，这里使用以下方法：
        * 1.主题配置页面将状态栏设置透明
        * 2.Activity里设置topContent内间距将状态栏部分填满
        * 3.设置topContent为纯色，模拟沉浸式状态栏
        */
        LinearLayout topContent = findViewById(R.id.top_content);
        topContent.setPadding(5,getStatusBarHeight(),5,5);
        //检查登录状态
    }

    /**
     *@author putik-663
     *@Time 2022/2/15
     *@Description 初始化各组件
     */
    public void initComponent(){
       userPortraitImg = findViewById(R.id.user_portrait);
       userStatusBtn = findViewById(R.id.user_status);
    }

    /**
     *@author putik-663
     *@Time 2022/2/15
     *@Description 每次页面onRestart时都再次检查网络连接以及登录状态
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        //1.检查网络连接
        if (!checkNetworkStatus()){
            Toast.makeText(thisContext, "网络连接异常", Toast.LENGTH_SHORT).show();
        }else {
            //2.网络连接无误则检查登录状态并更新资料
            if (checkLoginStatus()){
                //TODO
                //userPortraitImg.setImageBitmap();
                //userStatusBtn.setText(username);
            }
        }
        System.out.println("初始化完毕...");
    }

    /**
     *@author putik-663
     *@Time 2022/2/15
     *@Description 用户误触返回键友好提示，当用户本次点击返回键与上一次点击的时间间隔超过两秒，则提示用户是否确定退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(thisContext, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     *@author putik-663
     *@Time 2022/2/15
     *@Description 利用反射获取状态栏高度
     */
    public int getStatusBarHeight() {
        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     *@author putik-663
     *@Time 2022/2/15
     *@Description 检查网络连接状态
     */
    //TODO 目前还不了解原理
    public boolean checkNetworkStatus(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        //直接返回是否连接的布尔值
        return networkInfo != null && networkInfo.isConnected();
    }

    /**
     *@author putik-663
     *@Time 2022/2/15
     *@Description 检查本地登录状态记录
     */
    public boolean checkLoginStatus(){
        return true;
    }
}