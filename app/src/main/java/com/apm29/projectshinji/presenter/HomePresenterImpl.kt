package com.apm29.projectshinji.presenter

import com.apm29.projectshinji.model.bean.HomeBean
import com.apm29.projectshinji.model.retro.ServerAPI


/**
 * Created by apm29 on 2017/8/11.
 */
class HomePresenterImpl(val ui: HomeContract.HomeUI<HomeBean>) :HomeContract.HomePresenter{
    init {

    }
    override fun loadData() {
        ServerAPI.initHome(ui::reloadUI, 1, 36, 5711)
    }
}