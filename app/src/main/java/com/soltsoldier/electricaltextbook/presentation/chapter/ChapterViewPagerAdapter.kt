package com.soltsoldier.electricaltextbook.presentation.chapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentManager
import com.soltsoldier.electricaltextbook.presentation.page.PageFragment


class ChapterViewPagerAdapter(fm: FragmentManager, chapterNum: Int, pageNum: Int) :
    FragmentPagerAdapter(fm) {

    // ページの数
    private val pageNum = pageNum
    // 選択された章番号
    private val chapterNum = chapterNum

    override fun getItem(position: Int): Fragment {
        return PageFragment.newInstance(chapterNum, position)
    }

    override fun getCount(): Int {
        return pageNum
    }
}