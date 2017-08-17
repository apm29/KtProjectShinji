package com.apm29.projectshinji.view

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.MotionEvent


/**
 * Created by apm29 on 2017/8/14.
 */
class NoScrollViewPager(context:Context):ViewPager(context){
    public fun NoScrollViewPager():Unit{

    }
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
}