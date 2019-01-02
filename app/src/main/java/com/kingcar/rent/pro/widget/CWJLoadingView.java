package com.kingcar.rent.pro.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kingcar.rent.pro.R;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by cwj on 16/10/21.
 */

public class CWJLoadingView extends FrameLayout {


    @Bind(R.id.loading_view2)
    ImageView loadingView;
    @Bind(R.id.kit_loading)
    FrameLayout kitLoading;

    public CWJLoadingView(Context context) {
        super(context);
        if (isInEditMode()) {
            return;
        }
        init();
    }

    public CWJLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) {
            return;
        }
        init();
    }

    public CWJLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) {
            return;
        }
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CWJLoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (isInEditMode()) {
            return;
        }
        init();
    }


    private void init() {
        inflate(getContext(), R.layout.kit_loading_view, this);
        ButterKnife.bind(this, this);
//        setBackgroundResource(R.color.default_page_bgcolor);
        setClickable(true);
//        Glide.with(getContext()).load(R.mipmap.loading).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(loadingView);

    }

    public void release() {
        if (loadingView != null) {
            Glide.clear(loadingView);
            loadingView.setImageDrawable(null);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        ButterKnife.unbind(this);
        super.onDetachedFromWindow();
    }

    public void hideLoadingNoAnmation() {
        setVisibility(View.GONE);
        release();
    }

    public void hideLoading(boolean isRelease) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            this.animate().setDuration(200).alpha(0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    setVisibility(View.GONE);
                }
            });
        } else {
            setVisibility(View.GONE);
        }
        if (isRelease) {
            release();
        }
    }

    public void hideLoading(boolean isRelease, long delayMillis) {
        if(getVisibility()==GONE)
            return;
        postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    hideLoading(isRelease);
                } catch (Exception e) {

                }
            }
        }, delayMillis);
    }


}
