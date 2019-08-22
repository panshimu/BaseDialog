package com.miaozi.basedialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.miaozi.basedialog.R;

/**
 * created by panshimu
 * on 2019/8/21
 */
public class MyAlertDialog extends Dialog {
    private MyAlertHelper mAlertHelper;
    public MyAlertDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }
    protected void setAlertHelper(MyAlertHelper mAlertHelper){
        this.mAlertHelper = mAlertHelper;
    }
    public View getViewById(int viewId){
        return mAlertHelper.getViewById(viewId);
    }

    public static class Builder{
        private AlertParams P;
        private Context mContext;
        private int mThemeId;
        public Builder(Context context){
            this(context,R.style.dialog);
        }
        public Builder(Context context,int themeId){
            this.mContext = context;
            this.mThemeId = themeId;
            P = new AlertParams(context,themeId);
        }
        public Builder setContentView(int layoutId){
            P.mLayoutId = layoutId;
            return this;
        }
        public Builder setContentView(View view){
            P.mView = view;
            return this;
        }
        public Builder setAnimations(int animations){
            P.mAnimation = animations;
            return this;
        }
        public Builder setWidth(int width){
            P.mWidth = width;
            return this;
        }
        public Builder setHeight(int height){
            P.mHeight = height;
            return this;
        }
        public Builder fullWidth(){
            P.mWidth = ViewGroup.LayoutParams.MATCH_PARENT;
            return this;
        }
        public Builder setCanceledOnTouchOutside(boolean canceled){
            P.mCancelable = canceled;
            return this;
        }
        public MyAlertDialog create(){
            MyAlertDialog dialog = new MyAlertDialog(mContext,mThemeId);
            dialog.setCancelable(P.mCancelable);
            //绑定数据
            P.apply(dialog);
            //点击空白处消失
            if(P.mCancelable){
                dialog.setCanceledOnTouchOutside(true);
            }
            return dialog;
        }
    }
}
