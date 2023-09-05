package  com.zxy.mompda.base

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.LogUtils
import com.dylanc.viewbinding.base.ViewBindingUtil
import com.gyf.immersionbar.ktx.immersionBar
import com.kaopiz.kprogresshud.KProgressHUD
import com.weikaiyun.fragmentation.SupportActivity


/**
 * 当前类注释：基类Activity
 * Created by Qyang on 2020-02-04
 */
abstract class BaseActivity<VB : ViewBinding> : SupportActivity() {

    lateinit var binding: VB

    private var mContentView: View? = null


    val loading: KProgressHUD by lazy {
        KProgressHUD.create(this)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
    }


    protected abstract fun initView(savedInstanceState: Bundle?)

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewBindingUtil.inflateWithGeneric(this, layoutInflater)
        setContentView(binding.root)
        initImmersionBar()
        initTitle()
        initView(savedInstanceState)
    }

    private fun initTitle() {
//        if (toolbar != null) {
//            setSupportActionBar(toolbar)
//            if (supportActionBar != null) {
//                supportActionBar!!.setDisplayShowTitleEnabled(false)
//            }
//        }
    }

    open fun initImmersionBar() {
        immersionBar{
//            titleBar(toolbar)
            statusBarDarkFont(true)
//            statusBarColor(R.themes.colorPrimary)
//            navigationBarColor(R.color.colorPrimary)
        }
    }

    fun hideSoftInput() {
        val view = window.decorView
        if (view?.context == null) return
        val imm = view.context
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}