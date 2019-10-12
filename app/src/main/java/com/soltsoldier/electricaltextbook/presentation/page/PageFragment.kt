package com.soltsoldier.electricaltextbook.presentation.page

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.soltsoldier.electricaltextbook.R
import com.soltsoldier.electricaltextbook.presentation.base.BaseFragment
import com.soltsoldier.electricaltextbook.presentation.chapter.ChapterActivity
import com.soltsoldier.electricaltextbook.presentation.linkword.Chapter1Page1
import kotlinx.android.synthetic.main.fragment_chapter2_page1.view.*


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
                    0 -> {
                        view = inflater.inflate(R.layout.fragment_chapter2_page1, container, false)
                        val setText1 = view!!.chapter2_page1_text1.text.toString()
                        val setText2 = view!!.chapter2_page1_text2.text.toString()
                        // リンクを貼りたい文章の数だけ実行してください
                        view.chapter2_page1_text1.text = setLink(setText1)
                        view.chapter2_page1_text1.movementMethod = LinkMovementMethod.getInstance()
                        view.chapter2_page1_text2.text = setLink(setText2)
                        view.chapter2_page1_text2.movementMethod = LinkMovementMethod.getInstance()
                    }
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

    // 文字列にリンクをはる
    fun setLink(baseText: String): SpannableStringBuilder {
        val chapter1Page1 = Chapter1Page1()
        val sb = SpannableStringBuilder()
        sb.append(baseText)

        // リンクを貼る文字のパターンだけ行う
        for (linkWord in chapter1Page1.linkWord) {
            var spanStart = 0
            while (spanStart != -1) {
                // 文字列検索
                spanStart = baseText.indexOf(linkWord.key, spanStart)

                // 文字列不一致の場合whileから脱出
                if (spanStart == -1) break

                // リンクを飛ばす文字列に加工を加える
                // アンダーライン追記
                sb.setSpan(UnderlineSpan(), spanStart, spanStart + linkWord.key.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                // 太字に
                sb.setSpan(StyleSpan(Typeface.BOLD), spanStart, spanStart + linkWord.key.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                // クリックアクション追加
                sb.setSpan(object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        // クリックした時にページ遷移を組み込む
                        val intent = Intent(view!!.context, ChapterActivity::class.java)
                        // 章の名前と章の番号を渡しておく
                        intent.putExtra("chapterName", linkWord.key + "とは")
                        intent.putExtra("chapterNum", linkWord.value)
                        view!!.context.startActivity(intent)
                    }
                }, spanStart, spanStart + linkWord.key.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                // 検索indexの更新
                spanStart += linkWord.key.length
            }
        }
        return sb
    }
}