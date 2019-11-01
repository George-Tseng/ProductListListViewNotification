package com.tester.productlistlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener{

    //宣告ListView
    private ListView listView0;
    //宣告Adapter(見ProductAdapter.java)
    public ProductAdapter productAdapter0 = null;
    //ArrayList宣告
    public ArrayList<ProductSet> productData = null;
    //宣告Intent、Bundle
    Intent intent0;
    Bundle bundle0;
    //宣告要傳的圖與字串，暫時設為null
    String txtName,txtPrice,txtIntro = "";
    int imgCover;

    @SuppressLint("ResourceType")//新加入的部份
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById方法
        listView0 = (ListView) findViewById(R.id.productList);
        //開始填入ArrayList
        productData = new ArrayList<ProductSet>();
        productData.add(new ProductSet(R.drawable.storage_icon_sshd,getString(R.string.productName8),getString(R.string.productPrice8),getString(R.string.productIntro8)));
        productData.add(new ProductSet(R.drawable.storage_icon_enterprise_hdd,getString(R.string.productName10),getString(R.string.productPrice10),getString(R.string.productIntro10)));
        productData.add(new ProductSet(R.drawable.storage_icon_surveillance_hdd,getString(R.string.productName11),getString(R.string.productPrice11),getString(R.string.productIntro11)));
        productData.add(new ProductSet(R.drawable.storage_icon_nas_hdd,getString(R.string.productName12),getString(R.string.productPrice12),getString(R.string.productIntro12)));
        productData.add(new ProductSet(R.drawable.storage_icon_hdd,getString(R.string.productName13),getString(R.string.productPrice13),getString(R.string.productIntro13)));
        //加入資料中止！開始設定ListView上的Adapter
        productAdapter0 = new ProductAdapter(this,productData);
        listView0.setAdapter(productAdapter0);
        listView0.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //生成Intent、Bundle物件
        intent0 = new Intent();
        bundle0 = new Bundle();
        //調用ProductSet.java中的方法來取得要傳的資料
        imgCover = productData.get(position).getImg();
        txtName = productData.get(position).getName();
        txtPrice = productData.get(position).getPrice();
        txtIntro = productData.get(position).getIntro();
        //使用Bundle物件來進行傳值的設定
        bundle0.putInt("imgCover2", imgCover);
        bundle0.putString("txtName2", String.valueOf(txtName));
        bundle0.putString("txtPrice2", String.valueOf(txtPrice));
        bundle0.putString("txtIntro2", String.valueOf(txtIntro));
        //結束傳值部份
        intent0.putExtras(bundle0);
        //設定跳頁到ResultActivity
        intent0.setClass(MainActivity.this, ResultActivity.class);
        //開始執行Intent物件裡的設定
        startActivity(intent0);
        //結束這個頁面的所有活動
        finish();
    }
}
