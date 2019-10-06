package com.soltsoldier.electricaltextbook.presentation.textbook

import android.os.Bundle
import com.soltsoldier.electricaltextbook.R
import com.soltsoldier.electricaltextbook.presentation.base.BaseActivity

class ChapterActivity : BaseActivity() {
    private var mChapterName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)
        mChapterName = intent.getStringExtra("chapterName")
        setTitle(mChapterName)
    }
}