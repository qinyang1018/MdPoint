package com.qy.mdpoint.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.base.ViewBindingUtil
import com.gyf.immersionbar.ktx.immersionBar
import com.kaopiz.kprogresshud.KProgressHUD
import com.weikaiyun.fragmentation.SupportFragment

/**
 * 当前类注释：基类Fragment
 * Created by Qyang on 2020-02-04
 */
abstract class BaseFragment<VB : ViewBinding> : SupportFragment() {

    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    //    var hud: KProgressHUD
    val loading: KProgressHUD by lazy {
        KProgressHUD.create(_mActivity)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ViewBindingUtil.inflateWithGeneric(this, inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initImmersionBar()
        initTitle()
        initViews()
    }

    open fun initImmersionBar() {
        immersionBar {
            statusBarDarkFont(true)
            statusBarView(setStatusBarView())
        }
    }

    private fun initTitle() {
//        if (toolbar != null) {
//            _mActivity.setSupportActionBar(toolbar)
//            if (_mActivity.supportActionBar != null) {
//                _mActivity.supportActionBar!!.setDisplayShowTitleEnabled(false)
//            }
//        }
    }


    protected open fun setStatusBarView(): Int {
        return 0
    }

    override fun pop() {
        super.pop()
        hideSoftInput()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     *
     * @return
     */
    protected abstract fun initViews()

}