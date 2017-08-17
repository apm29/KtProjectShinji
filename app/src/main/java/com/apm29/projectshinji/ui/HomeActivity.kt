package com.apm29.projectshinji.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.view.ViewManager
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.apm29.projectshinji.R
import com.apm29.projectshinji.ui.fragment.HomeFragment
import com.apm29.projectshinji.view.NoScrollViewPager
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick


class HomeActivity : BaseActivity() {
    lateinit var vLayout: LinearLayout
    lateinit var viewPager: NoScrollViewPager
    lateinit var footerLayout: LinearLayout
    companion object {
        val  VIEW_PAGER=1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val lParamsFooter: RadioGroup.LayoutParams = RadioGroup.LayoutParams(wrapContent, matchParent)
        lParamsFooter.weight = 1f
        val homePagerAdapter: FragmentPagerAdapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                when(position){
                    0->return HomeFragment()
                    1->return HomeFragment()
                    2->return HomeFragment()
                    3->return HomeFragment()
                }
                return HomeFragment()
            }


            override fun getCount(): Int {
                return 4
            }

        }
        val scrollView = scrollView {
            lparams {
                scrollBarSize = 0
            }

            vLayout = verticalLayout {
                viewPager = noScrollViewPager {
                    id=VIEW_PAGER
                    lparams {
                        backgroundColor = ContextCompat.getColor(this@HomeActivity, R.color.button_material_dark)
                        height = resources.displayMetrics.heightPixels - dip(50) - getStatusBarSize()
                        width = matchParent
                    }

                    adapter = homePagerAdapter
                }
                footerLayout = linearLayout {
                    backgroundColor = resources.getColor(R.color.white_color)
                    orientation = LinearLayout.HORIZONTAL
                    lparams {
                        height = dip(50)
                        width = matchParent
                    }

                    radioGroup {
                        lparams {
                            height= matchParent
                            width= matchParent
                        }
                        orientation=RadioGroup.HORIZONTAL
                        radioButton {
                            text="首页"
                            footerStyle()
                        }.lparams(lParamsFooter)
                        radioButton {
                            text="商城"
                            footerStyle()
                        }.lparams(lParamsFooter)
                        radioButton {
                            text="消息"
                            footerStyle()
                        }.lparams(lParamsFooter)
                        radioButton {
                            text="我的"
                            footerStyle()
                        }.lparams(lParamsFooter)
                    }
                }
            }
        }
        setContentView(scrollView)
    }

    private fun @AnkoViewDslMarker RadioButton.footerStyle() {
        gravity = Gravity.CENTER
        textColor = resources.getColor(R.color.white_color)
        buttonDrawable=null
        width= (resources.displayMetrics.widthPixels/4f+0.5f).toInt()
        backgroundDrawable=if (isChecked){
            ColorDrawable(Color.WHITE)
        }else{
            ColorDrawable(Color.LTGRAY)
        }
        onClick {
            when(text){
                "首页"->viewPager.currentItem=0
                "商城"->viewPager.currentItem=1
                "消息"->viewPager.currentItem=2
                "我的"->viewPager.currentItem=3
            }
            isChecked=true
        }
    }

    /**
     * 自定义ViewPager的初始化函数
     */
    inline fun ViewManager.noScrollViewPager(theme: Int = 0, init: NoScrollViewPager.() -> Unit): NoScrollViewPager {
        return ankoView({ NoScrollViewPager(it) }, theme, init)
    }

    //扩展方法 fun 类名.方法名(参数列表){函数体}
    fun View.getStatusBarSize() = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"))
}
