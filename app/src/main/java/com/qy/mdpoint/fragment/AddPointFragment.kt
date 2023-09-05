package com.qy.mdpoint.fragment

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.TimeUtils
import com.loper7.date_time_picker.dialog.CardDatePickerDialog
import com.qy.mdpoint.base.BaseFragment
import com.qy.mdpoint.databinding.FragmentAddPointBinding

class AddPointFragment : BaseFragment<FragmentAddPointBinding>() {

    companion object {
        @JvmStatic
        fun newInstance(): AddPointFragment {
            return AddPointFragment()
        }
    }

    override fun initViews() {
        binding.titleBar.setOnLeftTextClickListener {
            pop()
        }

        binding.llDate.setOnClickListener {
            CardDatePickerDialog.builder(_mActivity)
                .setOnChoose {millisecond->
                    LogUtils.d(millisecond)
                    binding.tvDate.text=TimeUtils.millis2String(millisecond)
                }.build().show()
        }
    }
}