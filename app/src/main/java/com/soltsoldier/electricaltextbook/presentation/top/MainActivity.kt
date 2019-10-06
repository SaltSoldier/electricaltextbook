package com.soltsoldier.electricaltextbook.presentation.top

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.soltsoldier.electricaltextbook.R
import com.soltsoldier.electricaltextbook.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    /**
     * RecyclerViewの初期設定を行う関数
     */
    private fun initRecyclerView() {

        val chapterList = initChapterList()
        val authenticationAdapter = TopRecyclerViewAdapter(chapterList, this)
        recycler_view.setHasFixedSize(true)
        // 区切り線の設定
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recycler_view.addItemDecoration(itemDecoration)
        // recyclerViewの設定
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = authenticationAdapter
    }

    private fun initChapterList() : List<String>{
        val chapterList: MutableList<String> = mutableListOf()
        chapterList.add("1章 : 電気とは")
        chapterList.add("2章 : 電荷とは")
        chapterList.add("3章 : 電流とは")
        // 好きなだけ増やしてください

        return  chapterList
    }
}
