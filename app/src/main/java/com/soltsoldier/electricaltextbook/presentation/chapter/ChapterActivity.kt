package com.soltsoldier.electricaltextbook.presentation.chapter

import android.os.Bundle
import android.support.v4.app.Fragment
import com.soltsoldier.electricaltextbook.R
import com.soltsoldier.electricaltextbook.presentation.base.BaseActivity
import com.soltsoldier.electricaltextbook.presentation.page.PageFragment
import kotlinx.android.synthetic.main.activity_chapter.*

class ChapterActivity : BaseActivity() {
    private var mChapterName: String = ""
    private var mChapterNum: Int = 0
    private var mPageNum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)
        mChapterName = intent.getStringExtra("chapterName")
        mChapterNum = intent.getIntExtra("chapterNum", 0)
        initChapterPages()
    }

    private fun initChapterPages() {
        // appbarのタイトル変更
        setTitle(mChapterName)
        detectPageNum()
        // 初期Fragmentの設定
        replaceFragment(PageFragment.newInstance(mChapterNum, 0))
        // pager adapterの設定
        val mPagerAdapter = ChapterViewPagerAdapter(supportFragmentManager, mChapterNum, mPageNum)
        viewpager.adapter = mPagerAdapter
    }

    /**
     * fragmentを入れ替える関数
     * @param fragment 変更させたいfragmentのinstance
     */
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.viewpager, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    // 章ごとのページ数をここで設定
    private fun detectPageNum() {
        when(mPageNum){
            0 -> mPageNum = 3
            1 -> mPageNum = 3
            2 -> mPageNum = 3
        }
    }
}