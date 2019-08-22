package com.miaozi.basedialog.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * created by panshimu
 * on 2019/8/21
 */
public class AlertParams {
    //内容布局
    public View mView;
    //内容布局Id
    public int mLayoutId;
    public Context mContext;
    public int mThemeId;
    public int mHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
    public int mWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
    public int mAnimation;
    public int mGravity = Gravity.CENTER;
    public boolean mCancelable;
    public AlertParams(Context context,int mThemeId){
        this.mContext = context;
        this.mThemeId = mThemeId;
    }
    /**
     * 设置数据
     */
    public void apply(MyAlertDialog dialog) {

        //设置布局
        MyAlertHelper myAlertHelper = null;
        if(mLayoutId != 0){
            myAlertHelper = new MyAlertHelper(mContext,mLayoutId);
        }
        if(mView != null){
            myAlertHelper = new MyAlertHelper(mContext,mView);
        }

        if(myAlertHelper == null){
            throw new IllegalArgumentException("请先设置布局dialog.setContentView");
        }

        dialog.setAlertHelper(myAlertHelper);

        //设置布局
        dialog.setContentView(myAlertHelper.getContentView());

        Window window = dialog.getWindow();

        WindowManager.LayoutParams attributes = window.getAttributes();

        attributes.width = mWidth;

        attributes.height = mHeight;

        window.setAttributes(attributes);

        if(mAnimation != 0){
            window.setWindowAnimations(mAnimation);
        }

        window.setGravity(mGravity);

    }
}
