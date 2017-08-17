package com.apm29.projectshinji.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.apm29.projectshinji.model.bean.HomeBean
import com.apm29.projectshinji.presenter.HomeContract.HomeUI
import com.apm29.projectshinji.presenter.HomePresenterImpl
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.sp
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.textColor
import org.jetbrains.anko.textView


/**
 * Created by apm29 on 2017/8/14.
 */
class HomeFragment : Fragment(), HomeUI<HomeBean> {
    companion object {
        const val tv = 3;
    }

    lateinit var textView: TextView

    override fun reloadUI(data: HomeBean?) {
        if (data != null && data.ads != null)
            textView.text = data.ads[0].title
        else {
            toast("加载数据失败")
        }
    }

    private lateinit var mPresenter: HomePresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = HomePresenterImpl(this)
       // mPresenter.loadData()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            textView = textView("home") {
                id = tv
                textSize = sp(22).toFloat()
                textColor = Color.WHITE
                gravity = Gravity.CENTER
            }
        }.view
    }
}