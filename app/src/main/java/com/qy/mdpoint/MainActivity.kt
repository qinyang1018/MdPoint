package com.qy.mdpoint

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import com.qy.mdpoint.databinding.ActivityMainBinding
import com.qy.mdpoint.fragment.MainFragment
import com.weikaiyun.fragmentation.SupportHelper
import com.zxy.mompda.base.BaseActivity


class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var mainFragment: MainFragment? = null

    override fun initView(savedInstanceState: Bundle?) {

        mainFragment = SupportHelper.findFragment(supportFragmentManager, MainFragment::class.java)
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance()
            mainFragment?.let {
                loadRootFragment(R.id.container, it)
            }
        }
    }

}