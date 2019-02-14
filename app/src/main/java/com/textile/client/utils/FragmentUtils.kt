package com.textile.client.utils

import android.support.v4.app.Fragment
import com.textile.client.forum.ui.fragment.*
import com.textile.client.me.ui.fragment.collection.*

/**
 * Created by bo on 2019/1/12.
 */
class FragmentUtils {
    companion object {
        fun getCollectionFragment(position: Int): Fragment {
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

        fun getForumFragment(position: Int, startCode: Int): Fragment {
            var fragment: Fragment
            when (position) {
                0 -> {
                    fragment = NewestFragment.newInstance(startCode)
                }
                1 -> {
                    fragment = RapierFragment.newInstance(startCode)
                }
                2 -> {
                    fragment = DabbleFragment.newInstance(startCode)
                }
                3 -> {
                    fragment = SpraySteamFragment.newInstance(startCode)
                }
                4 -> {
                    fragment = MechFragment.newInstance(startCode)
                }
                5 -> {
                    fragment = ReformFragment.newInstance(startCode)
                }
                else -> {
                    fragment = NewestFragment.newInstance(startCode)
                }
            }
            return fragment
        }
    }
}