package com.textile.client.me.utils

import android.support.v4.app.Fragment
import com.textile.client.me.ui.fragment.*

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