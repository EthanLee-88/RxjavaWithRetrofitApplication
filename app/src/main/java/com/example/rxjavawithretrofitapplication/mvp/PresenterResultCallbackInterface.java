package com.example.rxjavawithretrofitapplication.mvp;

import org.json.JSONObject;

/**
 * Created by Ethan Lee on 19/7/20.
 */
public interface PresenterResultCallbackInterface {

    void onPresenterDataResult(JSONObject result);
    boolean isAlive();
}
