package com.example.liujinxing.mypicassoapplication.view;

import java.util.zip.Inflater;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.liujinxing.mypicassoapplication.R;
import com.squareup.picasso.Picasso;

/**
 * Created by liujinxing on 2017/9/8.
 */

public class PicassoView extends LinearLayout{
    private Context mContext;
    public PicassoView(Context context) {
        super(context);
        mContext = context;
        initView();
    }


    public PicassoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.view_picasso,null);
        ImageView picassoIv = (ImageView) layout.findViewById(R.id.iv_picasso);

        //1.图片异步加载
        String url = "http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=0&pn=0&spn=0&di=182281250470&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=1060387669%2C1498970204&os=3626511987%2C1744795126&simid=3379801103%2C457455490&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fimg3.redocn.com%2Ftupian%2F20150312%2Fhaixinghezhenzhubeikeshiliangbeijing_3937174.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Ff7vwt_z%26e3B6j15vg_z%26e3Bv54AzdH3Ffitstwg2p7AzdH3Fnln0809_z%26e3Bip4s&gsm=0";
        Picasso.with(mContext).load(url).into(picassoIv);
    }
}
