package com.tester.productlistlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    //宣告item-view.xml中的元件
    private ImageView imgCover;
    private TextView txtName,txtPrice,txtIntro;
    //宣告LayoutInflater
    private LayoutInflater layoutInflater0;
    //宣告ArrayList
    public ArrayList<ProductSet> productList;

    //建構子，參數要補上context
    public ProductAdapter(Context context0, ArrayList<ProductSet> productList) {
        this.productList = productList;
        layoutInflater0 = (LayoutInflater) context0.getSystemService(context0.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    //算資料總數
    public int getCount() {
        return productList.size();
    }

    @Override
    //取得元件位置
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView0, ViewGroup parent) {

        ProductSet myProduct = (ProductSet) getItem(position);
        //使用layoutinflater依據item_view.xml產生layout
        convertView0 = layoutInflater0.inflate(R.layout.item_view,null);
        //findViewById方法
        imgCover = convertView0.findViewById(R.id.imgCover);
        txtName = convertView0.findViewById(R.id.txtName);
        txtPrice = convertView0.findViewById(R.id.txtPrice);
        txtIntro = convertView0.findViewById(R.id.txtIntro);
        //將值帶入元件
        imgCover.setImageResource(myProduct.getImg());
        txtName.setText(myProduct.getName());
        txtPrice.setText(myProduct.getPrice());
        txtIntro.setText(myProduct.getIntro());
        //將完成設定的View回傳給使用者
        return convertView0;
    }
}

