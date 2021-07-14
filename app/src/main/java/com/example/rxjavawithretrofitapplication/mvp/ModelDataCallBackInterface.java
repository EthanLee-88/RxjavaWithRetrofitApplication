package com.example.rxjavawithretrofitapplication.mvp;

/**
 * Created by Ethan Lee on 19/7/20.
 */
public interface ModelDataCallBackInterface <T>{
    void onDataResult(T result);
}
