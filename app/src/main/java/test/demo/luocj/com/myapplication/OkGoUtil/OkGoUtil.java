package test.demo.luocj.com.myapplication.OkGoUtil;

import android.app.ProgressDialog;
import android.content.Context;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;

import okhttp3.Call;
import okhttp3.Response;
import test.demo.luocj.com.myapplication.Interface.OkGoInterface;

/**
 * Created by luocj515 on 2017/7/12.
 * 项目名称：MyTestDemo
 * 类描述：
 * 创建人：hasee
 * 创建时间：2017/7/12 23:23
 * 修改备注：
 */

public class OkGoUtil {
    private OkGoInterface okGoInterface;
    private Context context;
    private ProgressDialog progressDialog;

    public OkGoUtil(Context context) {
        this.context = context;
    }

    //获取ip请求的方法.还有其他一系列的请求都在这个类里面写对应的方法调用
    public void doNet(final OkGoInterface httpUtilsInterface) {
//        http://api.tianapi.com/social/?key=861a794733dd2b057e415d822bef9586&num=10
        this.okGoInterface = httpUtilsInterface;
//        String url = "http://api.tianapi.com/social/";
        String url = "http://api.tianapi.com/social/?key=861a794733dd2b057e415d822bef9586&num=10";
        OkGo.post(url).execute(new StringCallback() {
            @Override
            public void onBefore(BaseRequest request) {
                super.onBefore(request);
                progressDialog = new ProgressDialog(context);
                progressDialog.show();
                httpUtilsInterface.onStart(request);
            }

            @Override
            public void onSuccess(String s, Call call, Response response) {
                httpUtilsInterface.onSuccess(s, call, response);
            }

            @Override
            public void onAfter(String s, Exception e) {
                super.onAfter(s, e);
                httpUtilsInterface.onAfter(s, e);
                progressDialog.dismiss();
            }

            @Override
            public void onError(Call call, Response response, Exception e) {
                super.onError(call, response, e);
                httpUtilsInterface.onError(call, response, e);
                progressDialog.dismiss();
            }

        });
    }
}
