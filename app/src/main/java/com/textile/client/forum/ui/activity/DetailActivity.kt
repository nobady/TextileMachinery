package com.textile.client.forum.ui.activity

import cn.jzvd.Jzvd
import com.game.base.mvp.BaseActivity
import com.game.base.utils.setFullScreen
import com.game.base.utils.toast
import com.textile.client.R
import com.textile.client.forum.contract.DetailContract
import com.textile.client.forum.model.DetailModel
import com.textile.client.forum.presenter.DetailPresenterImpl
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity(), DetailContract.IDetailView {
    override fun loadDetail(data: DetailModel) {
        data?.run {
            toast(name ?: "NULl")
        }
    }

    companion object {
        const val ITEM_ID_KEY = "item_id_key"
    }

    private lateinit var mItemId: String
    private val mDetailPresenter by lazy { DetailPresenterImpl() }
    override fun startLoad() {
        mDetailPresenter.loadDetail(mItemId)
    }

    override fun initView() {
        setFullScreen()
        mDetailPresenter.attachView(this)
        mItemId = intent.getStringExtra(ITEM_ID_KEY)
        val mutableListOf = mutableListOf(
            "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4",
            "https://tse4-mm.cn.bing.net/th?id=OIP.3k9u0IXuYCNGgyOi3cxECwHaLH&w=184&h=276&c=7&o=5&dpr=1.25&pid=1.7",
            "http://m3.biz.itc.cn/pic/new/n/66/84/Img7978466_n.jpg",
            "http://himg2.huanqiu.com/attachment2010/2019/0124/09/12/20190124091249349.jpg",
            "http://www.people.com.cn/mediafile/pic/20130608/93/7200316785493904929.jpg",
            "http://hashiqi.cndog.net/article/UploadPic/2009-9/24/2009924115130362.jpg",
            "http://www.hashiqi.com/Uploadpic/200781321027632.jpg",
            "http://www.weipet.cn/common/images/pic/a349.jpg",
            "http://img2.biaoqingjia.com/biaoqing/201609/10682a0b8683ebd37a081017691a38f5.gif",
            "http://imgnews.gmw.cn/attachement/jpg/site2/20160324/3768579176206546059.jpg"
        )
        mDetailTopView.setUrls(ArrayList(mutableListOf))
    }

    override fun initData() {

    }

    override fun layoutId(): Int {
        return R.layout.activity_detail
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }

}
