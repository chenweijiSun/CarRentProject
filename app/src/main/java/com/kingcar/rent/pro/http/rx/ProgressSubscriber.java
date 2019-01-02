package com.kingcar.rent.pro.http.rx;

import android.content.Context;

import com.blankj.utilcode.utils.NetworkUtils;
import com.kingcar.rent.pro.BuildConfig;
import com.kingcar.rent.pro.base.IBaseRefreshView;
import com.kingcar.rent.pro.model.BaseData;
import com.kingcar.rent.pro.utils.jutils.JUtils;
import com.kingcar.rent.pro.widget.CWJLoadingView;

import rx.Subscriber;


/**
 * Created by cwj on 16/9/5.
 */
public class ProgressSubscriber<T extends BaseData> extends Subscriber<T> implements ProgressCancelListener{

    private SubscriberOnNextListener mSubscriberOnNextListener;
    private ProgressDialogHandler mProgressDialogHandler;
    private boolean isShowDialog=true;
    private IBaseRefreshView iView;
    private Context context;
    private CWJLoadingView loadingView;

    public ProgressSubscriber(Context context, SubscriberOnNextListener<T> mSubscriberOnNextListener) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context=context;
//        mProgressDialogHandler = new ProgressDialogHandler(context, this, true);
    }
    public ProgressSubscriber(Context context, boolean isShowDialog, SubscriberOnNextListener<T> mSubscriberOnNextListener) {
        this(context,mSubscriberOnNextListener);
        this.isShowDialog=isShowDialog;
    }
    public ProgressSubscriber(Context context, boolean isShowDialog, IBaseRefreshView iView, SubscriberOnNextListener<T> mSubscriberOnNextListener) {
        this(context,mSubscriberOnNextListener);
        this.isShowDialog=isShowDialog;
        this.iView=iView;
    }
    public ProgressSubscriber(Context context, CWJLoadingView loadingView, IBaseRefreshView iView, SubscriberOnNextListener<T> mSubscriberOnNextListener) {
        this(context,false,mSubscriberOnNextListener);
        this.iView=iView;
        this.loadingView=loadingView;
    }
    public ProgressSubscriber(Context context, CWJLoadingView loadingView, SubscriberOnNextListener<T> mSubscriberOnNextListener) {
        this(context,false,mSubscriberOnNextListener);
        this.loadingView=loadingView;
    }
    private void showProgressDialog(){
        if (mProgressDialogHandler != null && isShowDialog) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog(){
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(mProgressDialogHandler!=null){
                        mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
                        mProgressDialogHandler = null;
                    }
                }
            },1000);
        }
    }

    @Override
    public void onStart() {
//        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
        if(iView!=null){
            iView.stopRefresh();
        }
        if(loadingView!=null){
            loadingView.hideLoading(true,500);
        }
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        if(iView!=null){
            iView.stopRefresh();
        }
        if(!NetworkUtils.isAvailable(context)){
            JUtils.Toast("网络不可用");
        }
        if(BuildConfig.DEBUG){
            JUtils.Toast(e.getMessage());
        }
    }

    @Override
    public void onNext(T t) {
        mSubscriberOnNextListener.onNext(t);
    }

    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
        if(iView!=null){
            iView.stopRefresh();
        }
    }
}
