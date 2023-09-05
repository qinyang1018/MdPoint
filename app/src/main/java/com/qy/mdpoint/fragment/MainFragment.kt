package com.qy.mdpoint.fragment

import android.view.View
import androidx.core.view.GravityCompat
import com.qy.mdpoint.base.BaseFragment
import com.qy.mdpoint.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {

    companion object {
        @JvmStatic
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }


    override fun initViews() {
        binding.titleBar
            .setOnLeftTextClickListener(View.OnClickListener {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            })
        binding.add.setOnClickListener {
            start(AddPointFragment.newInstance())
        }
    }
}