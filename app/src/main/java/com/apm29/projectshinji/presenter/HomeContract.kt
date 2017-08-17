package com.apm29.projectshinji.presenter


/**
 * Created by apm29 on 2017/8/11.
 */
interface HomeContract {
    interface HomePresenter:BasePresenter{
    }
    interface  HomeUI<in T>{
        fun reloadUI(data:T?)
    }
}