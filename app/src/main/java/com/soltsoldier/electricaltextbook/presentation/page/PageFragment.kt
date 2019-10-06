package com.soltsoldier.electricaltextbook.presentation.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.soltsoldier.electricaltextbook.R
import com.soltsoldier.electricaltextbook.presentation.base.BaseFragment

class PageFragment : BaseFragment() {

    private var mView: View? = null
    // ページの数
    private var pageNum = 0
    // 選択された章番号
    private var chapterNum = 0

    companion object {
        fun newInstance(chapterNum: Int, pageNum: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            fragment.arguments = args
            fragment.chapterNum = chapterNum
            fragment.pageNum = pageNum

            return fragment
        }
    }

    // ここに章の追加、ページの追加を行なってください
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View? = null
        // チャプターで場合分け
        when (chapterNum) {
            0 -> {
                // ページで場合分け
                when (pageNum) {
                    0 -> view = inflater.inflate(R.layout.fragment_chapter1_page1, container, false)
                    1 -> view = inflater.inflate(R.layout.fragment_chapter1_page2, container, false)
                    2 -> view = inflater.inflate(R.layout.fragment_chapter1_page3, container, false)
                }
            }
            1 -> {
                when (pageNum) {
                    0 -> view = inflater.inflate(R.layout.fragment_chapter2_page1, container, false)
                    1 -> view = inflater.inflate(R.layout.fragment_chapter2_page2, container, false)
                    2 -> view = inflater.inflate(R.layout.fragment_chapter2_page3, container, false)
                }
            }
            2 -> {
                when (pageNum) {
                    0 -> view = inflater.inflate(R.layout.fragment_chapter3_page1, container, false)
                    1 -> view = inflater.inflate(R.layout.fragment_chapter3_page2, container, false)
                    2 -> view = inflater.inflate(R.layout.fragment_chapter3_page3, container, false)
                }
            }
        }
        mView = view
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}