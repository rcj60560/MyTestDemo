package test.demo.luocj.com.myapplication.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import test.demo.luocj.com.myapplication.R;
import test.demo.luocj.com.myapplication.widget.bottomdialog.BaseBottomDialog;
import test.demo.luocj.com.myapplication.widget.bottomdialog.BottomDialog;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class ButtonDialogActivity extends AppCompatActivity {

    private Button btn_buttom_dialog;
    private String TAG = "TAG";
    private BaseBottomDialog bottomDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttom_dialog);
        initView();
    }

    private void initView() {

        btn_buttom_dialog = (Button) findViewById(R.id.btn1);
        btn_buttom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomDialog = BottomDialog.create(getSupportFragmentManager())
                        .setViewListener(new BottomDialog.ViewListener() {
                            @Override
                            public void bindView(View v) {
                                onClickView(v);
                            }
                        })
                        .setLayoutRes(R.layout.dialog_layout)
                        .setDimAmount(0.9f)
                        .setTag("BottomDialog")
                        .setCancelOutside(false)
                        .show();


            }
        });
    }

    private void onClickView(View v) {
        v.findViewById(R.id.iv_weixin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonDialogActivity.this, "weixin", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
