package test.demo.luocj.com.myapplication.bean;

import java.io.Serializable;

/**
 * Created by luocj515 on 2017/7/12.
 * 项目名称：MyTestDemo
 * 类描述：
 * 创建人：hasee
 * 创建时间：2017/7/12 22:56
 * 修改备注：
 */

class BaseBean implements Serializable {
    public String msg;
    public int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
