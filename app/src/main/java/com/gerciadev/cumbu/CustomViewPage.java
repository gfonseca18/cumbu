package com.gerciadev.cumbu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

import java.util.jar.Attributes;

/**
 * Created by gerciafonseca on 14/09/2021
 */
public class CustomViewPage extends ViewPager {
    private boolean enabled;

    public CustomViewPage(Context context, AttributeSet attrs){
        super(context,attrs);
        this.enabled= true;

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.enabled){
            return super.onTouchEvent(ev);
        }
        return false;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.enabled){
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }
    public void setPagingEnabled(boolean enabled){

        this.enabled = enabled;
    }

}
