package com.miaozi.basedialog.dialog;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * created by panshimu
 * on 2019/8/21
 */
public class MyAlertHelper{
    private View mView;
    private SparseArray<WeakReference<View>> mViews = new SparseArray<>();
    public MyAlertHelper(Context mContext, int mLayoutId) {
        this.mView = LayoutInflater.from(mContext).inflate(mLayoutId,null);
    }
    public MyAlertHelper(Context mContext, View mView) {
        this.mView = mView;
    }
    public View getContentView(){
        return this.mView;
    }

    /**
     * 获取view
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getViewById(int viewId){
        WeakReference<View> weakReference = mViews.get(viewId);
        View view = null;
        if(weakReference != null){
            view = weakReference.get();
        }
        if(view == null){
            view = this.mView.findViewById(viewId);
            mViews.put(viewId,new WeakReference<View>(view));
        }
        return (T) view;
    }
}
