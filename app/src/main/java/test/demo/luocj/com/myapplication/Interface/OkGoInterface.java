package test.demo.luocj.com.myapplication.Interface;

import com.lzy.okgo.request.BaseRequest;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by wz on 2017/5/1.
 */

public interface OkGoInterface {
    void onError(Call call, Response response, Exception e);

    void onAfter(String s, Exception e);

    void onSuccess(String s, Call call, Response response);

    void onStart(BaseRequest request);
}
