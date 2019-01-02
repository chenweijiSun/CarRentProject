package com.kingcar.rent.pro.base;

import rx.Subscription;

/**
 * 基础presenter
 * Created by cwj
 */
public abstract class BasePresenter<T extends IBaseView>  {

    protected Subscription subscription;
    protected T iView;

    public BasePresenter(T iView) {
        this.iView = iView;
    }

    public void release(){
        if(subscription!=null){
            subscription.unsubscribe();
        }
    }
}
