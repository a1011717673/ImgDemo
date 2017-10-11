package com.example.liujinxing.mypicassoapplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liujinxing.mypicassoapplication.model.User;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;

import static android.R.id.list;
import static java.util.Collections.sort;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mSortListTv;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initContentView();
//        Picasso.with(getApplication()).load("").into(mIv);
    }

    private void initContentView() {
        mSortListTv = (TextView) findViewById(R.id.tv_sort_list);
        mIv = (ImageView) findViewById(R.id.iv_main);
        mSortListTv.setOnClickListener(this);

    }

    //Picasso使用，
    //优点：使用简单、方便；Square公司的产品，与Restofit或者oKHttp搭配兼容性好些，占用体积小
    //缺点:功能简单；性能与Glide、Fresco相比较差
    //自身无实现本地缓存，用的是Okhttp的缓存
    private void setPicasso(){
        //图片异步加载

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_sort_list:
//                sortList();
//                sorSet();
                sortListHasMultiElements();
                break;
            default:
                break;
        }
    }

    private void sortList() {//仅排序list
        Integer[] str1 = {1, 4, 4, 3, 5, 87, 8};
        List<Integer> list = Arrays.asList(str1);
        //利用Collections工具进行排序,只会排序，不会去重
        Collections.sort(list);
        List<Integer> newList = new ArrayList<>();
        for (Integer itemStr : list
                ) {
            if (!newList.contains(itemStr)) {
                newList.add(itemStr);
            }
        }
        System.out.print("去重" + newList.toString());
        Log.i("去重", newList.toString());
    }

    //使用List和Set来操作
    public void sorSet() {
        Integer[] str = {1, 2, 4, 4, 4, 3, 66, 43, 56};
        List<Integer> list = Arrays.asList(str);
        Set<Integer> set = new HashSet<>(list);
        List<Integer> newList = new ArrayList<>();
        newList.addAll(set);
        Log.i("去重", newList.toString());
        Collections.sort(newList);
        Log.i("排序", newList.toString());

    }

    //List排序
    private void sortListHasMultiElements() {
        Integer[] str = {1, 2, 4, 4, 4, 3, 66, 43, 56};
//        List<Integer> list = Arrays.asList(str);
        List<User> list = new ArrayList<>();
        int size = str.length;
        for (int i = 0; i <size; i++) {
            User userBean = new User();
            userBean.year = str[i];
            list.add(userBean);
        }
//        Log.i("添加", list.toString());
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int year1 = o1.year;
                int year2 = o2.year;
                //Java String.compareTo(),字符串相等返回0，升序排列<0,降序排列>0。
                //String 是字符串,它的比较用compareTo方法,它从第一位开始比较,如果遇到不同的字符,则马上返回这两个字符的ascii值差值..返回值是int类型
//                return year1-year2; //数字比较的话可以直接比较大小
                return String.valueOf(year1).compareTo(String.valueOf(year2));
            }
        };
        Collections.sort(list, comparator);
//        Log.i("排序", list.toString());
    }
}
