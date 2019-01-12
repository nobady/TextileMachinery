package com.yang.mac.memodule.utils

import android.support.v4.app.Fragment
import com.yang.mac.memodule.ui.fragment.*

/**
 * Created by bo on 2019/1/12.
 */
class FragmentUtils {
    companion object {
        fun getFragment(position: Int): Fragment {
            var fragment: Fragment
            when (position) {
                0 -> {
                    fragment = TechExcFragment.newInstance()
                }
                1 -> {
                    fragment = DemandFragment.newInstance()
                }
                2 -> {
                    fragment = SupplyFragment.newInstance()
                }
                3 -> {
                    fragment = JobWantFragment.newInstance()
                }
                else -> {
                    fragment = RecruitFragment.newInstance()
                }
            }
            return fragment
        }
    }
}