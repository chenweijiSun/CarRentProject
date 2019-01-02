package com.kingcar.rent.pro.http.rx;


import com.kingcar.rent.pro.BuildConfig;
import com.kingcar.rent.pro.base.IBaseRefreshView;
import com.kingcar.rent.pro.model.BaseData;
import com.kingcar.rent.pro.utils.jutils.JUtils;

import rx.Subscriber;


/**
 * Created by cwj on 16/9/5.
 */
public class MySubscriber<T extends BaseData> extends Subscriber<T> implements ProgressCancelListener{

    private SubscriberOnNextListener mSubscriberOnNextListener;
    private IBaseRefreshView iView;

    public MySubscriber( SubscriberOnNextListener<T> mSubscriberOnNextListener) {
        this(null,mSubscriberOnNextListener);
    }

    public MySubscriber(IBaseRefreshView iView, SubscriberOnNextListener mSubscriberOnNextListener){
        this.iView=iView;
        this.mSubscriberOnNextListener=mSubscriberOnNextListener;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onCompleted() {
        if(iView!=null){
            iView.stopRefresh();
        }
    }

    @Override
    public void onError(Throwable e) {
        if(iView!=null){
            iView.stopRefresh();
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
