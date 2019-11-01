package com.tester.productlistlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    //通知用的宣告
    String idProduct = "iProducts";
    //Layout的宣告
    Button btnBuy,btnBack;
    ImageView imgCover2;
    TextView txtName2,txtPrice2,txtIntro2;
    //Intent與Bundle
    Intent intent0;
    Bundle bundle0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //findViewById方法
        imgCover2 = findViewById(R.id.imgCover2);
        txtName2 = findViewById(R.id.txtName2);
        txtPrice2 = findViewById(R.id.txtPrice2);
        txtIntro2 = findViewById(R.id.txtIntro2);
        btnBuy = findViewById(R.id.btnBuy);
        btnBack = findViewById(R.id.btnBack);
        //生成Intent、Bundle物件
        intent0 = new Intent();
        bundle0 = getIntent().getExtras();
        //開始接收由Bundle物件傳來的資料
        int imgCover = bundle0.getInt("imgCover2");
        String txtName = bundle0.getString("txtName2");
        String txtPrice = bundle0.getString("txtPrice2");
        String txtIntro = bundle0.getString("txtIntro2");
        //將值帶入元件
        imgCover2.setImageResource(imgCover);
        txtName2.setText(txtName);
        txtPrice2.setText(txtPrice);
        txtIntro2.setText(txtIntro);
        //購買鈕的相關設定
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager0 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                //通知設定
                NotificationChannel channelProduct = new NotificationChannel(idProduct,"channel Product",NotificationManager.IMPORTANCE_HIGH);
                channelProduct.setDescription("成功加入購物車");
                channelProduct.enableLights(true);
                channelProduct.enableVibration(true);
                //依設定建立通知
                notificationManager0.createNotificationChannel(channelProduct);
                NotificationCompat.Builder builder1 = new NotificationCompat.Builder(v.getContext(), idProduct)
                        .setSmallIcon(R.mipmap.storage_icon_2)
                        .setContentTitle("i3C")
                        .setContentText("您已經挑選了一樣儲存產品："+txtName2.getText().toString())
                        .setAutoCancel(true);
                notificationManager0.notify(0,builder1.build());
            }
        });
        //返回鈕的相關設定
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent0.setClass(ResultActivity.this,MainActivity.class);
                startActivity(intent0);
                finish();
            }
        });
    }
}
