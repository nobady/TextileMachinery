package com.textile.client.search

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import com.game.base.mvp.BaseActivity
import com.textile.client.R
import com.textile.client.search.contract.SearchContract
import com.textile.client.search.presenter.SearchPresenterImpl
import kotlinx.android.synthetic.main.search_bar.*

class SearchActivity : BaseActivity(), SearchContract.ISearchView {
    override fun searchSuccess(data: ArrayList<String>) {

    }

    private val mSearchPresenter by lazy { SearchPresenterImpl() }

    companion object {

    }

    private var mStartCode: Int = 0
    private lateinit var mSearchEditText: EditText

    override fun startLoad() {

    }

    override fun initView() {
        mSearchPresenter.attachView(this)

        mSearchEditText = findViewById(R.id.query)
        initTitle()
        initEvent()
    }

    private fun initTitle() {
        when (mStartCode) {

            else -> {

            }
        }

    }

    private fun initEvent() {
        mSearchEditText.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                val keyWord = mSearchEditText.text.toString().trim()
                if (keyWord.isEmpty()) {

                } else {
                    mSearchPresenter.searchUser(keyWord)
                }
                return@OnEditorActionListener true
            }
            false
        })
        search_back.setOnClickListener {
            finish()
        }
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_search
    }
}
