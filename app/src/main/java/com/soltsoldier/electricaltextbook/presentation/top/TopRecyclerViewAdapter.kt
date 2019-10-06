package com.soltsoldier.electricaltextbook.presentation.top

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.soltsoldier.electricaltextbook.R
import com.soltsoldier.electricaltextbook.presentation.textbook.ChapterActivity

class TopRecyclerViewAdapter(chapterList: List<String>, context: Context) :
    RecyclerView.Adapter<TopRecyclerViewAdapter.ViewHolder>() {

    private val mChapter: List<String> = chapterList
    private val mContext: Context = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var chapterName: TextView = itemView.findViewById(R.id.chapter_name) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chapter, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.chapterName.text = mChapter.get(position)
        holder.chapterName.setOnClickListener{
            val intent = Intent(mContext, ChapterActivity::class.java)
            // 章の名前だけ受け渡しておく（次のページのAppbarタイトルに設定）
            intent.putExtra("chapterName", mChapter.get(position))
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = mChapter.size
}