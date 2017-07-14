package test.demo.luocj.com.myapplication.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import test.demo.luocj.com.myapplication.R;

/**
 * Created by luocj515 on 2017/7/6.
 * 项目名称：MyTestDemo
 * 类描述：
 * 创建人：hasee
 * 创建时间：2017/7/6 23:08
 * 修改备注：
 */

class TestActivity extends AppCompatActivity {
    private String TAG;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ImageView imageview1 = (ImageView) findViewById(R.id.image1);
        ImageView imageview = (ImageView) findViewById(R.id.imageview);

        imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: "+1111);
            }
        });
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: "+222);
            }
        });


    }
}
