package com.textile.client.forum.ui.fragment


import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.game.base.mvp.BaseFragment
import com.game.base.utils.dip2Px
import com.textile.client.R
import com.textile.client.forum.adapter.TechAdapter
import com.textile.client.forum.contract.CommunityContract
import com.textile.client.forum.model.*
import com.textile.client.forum.presenter.CommunityPresenterImpl
import com.textile.client.forum.ui.activity.ForumActivity
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem
import kotlinx.android.synthetic.main.fragment_newest.*

/**
 * 论坛--最新
 */
class NewestFragment : BaseFragment(), CommunityContract.ICommunityView {
    override fun loadDemandSuccess(data: DemandModel) {

    }

    override fun loadSupplySuccess(data: SupplyModel) {

    }

    override fun loadJobSuccess(data: ApplyJobModel) {

    }

    override fun loadRecruitSuccess(data: RecruitModel) {

    }

    override fun loadTechExcSuccess(data: TechModel) {
        val list = data.list
        if (list.isEmpty()){
            list.add(TechModel.X(
                "http://www.people.com.cn/mediafile/pic/20130608/93/7200316785493904929.jpg",
                2,
                1,
                121,
                "@深圳交警在2月13日晚上6点49分就此事发出第一条微博，微博为一条一女子拍摄的抖音小视频，并附文“玩得开心吗？”视频内容显示，一女子站在一辆白色进口奔驰slk200跑车上随着音乐舞蹈，该车辆停在路边，号牌被遮挡。从视频中可见，该奔驰车为粤B号牌，路上也有深圳出租车行驶。\n" +
                        "晚上9点左右，@深圳交警 第二次发微博：“马上找到她！”",
                System.currentTimeMillis().toString(),
                45645,
                0,
                mutableListOf("https://tse4-mm.cn.bing.net/th?id=OIP.3k9u0IXuYCNGgyOi3cxECwHaLH&w=184&h=276&c=7&o=5&dpr=1.25&pid=1.7",
                    "http://m3.biz.itc.cn/pic/new/n/66/84/Img7978466_n.jpg",
                    "http://himg2.huanqiu.com/attachment2010/2019/0124/09/12/20190124091249349.jpg",
                    "http://www.people.com.cn/mediafile/pic/20130608/93/7200316785493904929.jpg",
                    "http://hashiqi.cndog.net/article/UploadPic/2009-9/24/2009924115130362.jpg",
                    "http://www.hashiqi.com/Uploadpic/200781321027632.jpg",
                    "http://www.weipet.cn/common/images/pic/a349.jpg",
                    "http://img2.biaoqingjia.com/biaoqing/201609/10682a0b8683ebd37a081017691a38f5.gif",
                    "http://imgnews.gmw.cn/attachement/jpg/site2/20160324/3768579176206546059.jpg"),
                "阿驴",
                4654522,
                "156545166"
            ))
        }
        mNewestRv.adapter = TechAdapter(data.list)
    }

    private fun initRv() {
        mNewestRv.layoutManager = LinearLayoutManager(activity)
        mNewestRv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.set(0, 30, 0, 0)
            }
        })
        mNewestRv.setSwipeMenuCreator { leftMenu, rightMenu, position ->
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            val deleteItem = SwipeMenuItem(this@NewestFragment.context)
            deleteItem
                .setBackgroundColorResource(R.color.slideDelColor)
                .setImage(R.drawable.delete)
                .setWidth(this@NewestFragment.context.dip2Px(57))
                .setHeight(height)
                .setText("删除")
                .setTextColorResource(android.R.color.white).textSize = 10
            rightMenu.addMenuItem(deleteItem)
        }
    }

    private val mCommunityPresenter by lazy { CommunityPresenterImpl() }
    private var mStartCode: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mStartCode = it.getInt(ForumActivity.FORUM_START_CODE_KEY)
        }
    }

    override fun initView(view: View) {
        mCommunityPresenter.attachView(this)
        initRv()
    }

    override fun lazyLoadData() {
        loadData()
    }

    private fun loadData() {
        when (mStartCode) {
            ForumActivity.FORUM_TECH_EXCHANGE -> {
                mCommunityPresenter.loadTechExc(mStartCode!!)
            }
            ForumActivity.FORUM_MECHANICAL_DEMAND -> {
                mCommunityPresenter.loadDemand(mStartCode!!)
            }
            ForumActivity.FORUM_MECHANICAL_SUPPLY -> {
                mCommunityPresenter.loadSupply(mStartCode!!)
            }
            ForumActivity.FORUM_JOB_WANTED -> {
                mCommunityPresenter.loadJob(mStartCode!!)
            }
            ForumActivity.FORUM_RECRUIT -> {
                mCommunityPresenter.loadRecruit(mStartCode!!)
            }
            else -> {

            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_newest
    }

    companion object {
        @JvmStatic
        fun newInstance(startCode: Int) =
            NewestFragment().apply {
                arguments = Bundle().apply {
                    putInt(ForumActivity.FORUM_START_CODE_KEY, startCode)
                }
            }
    }
}
