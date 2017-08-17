package com.apm29.projectshinji.ui

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.apm29.projectshinji.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.coroutines.onMenuItemClick
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class LoginActivity : AppCompatActivity() {
    companion object static {
        val ID_TOOLBAR: Int = 1
        val ID_USER_EDIT: Int = 2
        val ID_PSD_EDIT: Int = 3
        val ID_BTN_LOGIN: Int = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        relativeLayout {

            var mToolbar = toolbar() {
                id = ID_TOOLBAR
                title = "登录"
                backgroundColor = ContextCompat.getColor(this@LoginActivity, R.color.colorPrimary)

                popupTheme = R.style.Base_ThemeOverlay_AppCompat_Light

                popupTheme = R.style.Base_ThemeOverlay_AppCompat_Light
                inflateMenu(R.menu.main)

                setNavigationIcon(R.drawable.back)

                onMenuItemClick {
                    menuItem ->
                    val itemId = menuItem!!.itemId
                    when (itemId) {
                        R.id.menu_main -> {
                            toast("main")
                        }
                    }
                }



                lparams {
                    width = matchParent
                    height = wrapContent
                }

                setNavigationOnClickListener {
                    finish()
                }
            }

            var mUserEdit = editText {
                id = ID_USER_EDIT
                hint = "请输入同户名"
                maxLines = 1


            }.lparams {
                width = matchParent
                height = wrapContent
                margin = dip(8)
                centerInParent()
            }

            var mPsdEdit = editText {
                id = ID_PSD_EDIT
                hint = "请输入密码"
                maxLines = 1
                maxWidth = 16


            }.lparams {
                width = matchParent
                height = wrapContent
                margin = dip(8)
                below(ID_USER_EDIT)
            }


            var mButton = button("登录") {
                id = ID_BTN_LOGIN

                onClick {
                    var username = mUserEdit.text.toString()
                    var password = mPsdEdit.text.toString()

                    //mPresenter!!.login(username,password)
                }


            }.lparams {
                width = matchParent
                height = wrapContent
                margin = dip(8)
                below(ID_PSD_EDIT)
            }
        }

//        作者：程烧麦
//        链接：http://www.jianshu.com/p/60cadddce489
//        來源：简书
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    }

}

