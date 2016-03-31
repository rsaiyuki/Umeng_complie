package crazzecoder.umeng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.share);
        if (button != null)
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //微信    wx12342956d1cab4f9,a5ae111de7d9ea137e88a5e02c07c94d
                    PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
                    //豆瓣RENREN平台目前只能在服务器端配置
                    //新浪微博
                    PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
                    //易信
                    PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
                    PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
                    PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
                    PlatformConfig.setAlipay("2015111700822536");
                    PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
                    PlatformConfig.setPinterest("1439206");
                    UMImage image = new UMImage(MainActivity.this,"http://www.umeng.com/images/pic/social/integrated_3.png");
                    /**shareboard  need the platform all you want and callbacklistener,then open it**/
                    new ShareAction(MainActivity.this).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)
                            .withText("来自友盟分享面板")
                            .withMedia(image)
                            .setCallback(umShareListener)
                            .open();
                }
            });
    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {

            Toast.makeText(MainActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MainActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };
}
