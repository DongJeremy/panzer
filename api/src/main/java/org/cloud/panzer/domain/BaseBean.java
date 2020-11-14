package org.cloud.panzer.domain;

public class BaseBean<T> {
    private int code;
    private T datas;

    public BaseBean(int code, T datas) {
        this.code = code;
        this.datas = datas;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }
}
