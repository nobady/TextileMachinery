package com.textile.client.mall.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.game.base.mvp.BaseFragment

import com.textile.client.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MallFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MallFragment : BaseFragment() {

    override fun initView(view: View) {
    }

    override fun lazyLoadData() {
    }

    override fun getLayoutId() = R.layout.fragment_mall

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MallFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            MallFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
