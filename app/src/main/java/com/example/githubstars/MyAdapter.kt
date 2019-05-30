package com.example.githubstars

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview.view.*

class MyAdapter(private val list: ArrayList<ReposData>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = this.list.count()

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repoName = itemView.tv_title
        val language = itemView.tv_language
        val stargazers_count = itemView.tv_starCount
        val watchers_count = itemView.tv_view
        fun bind(data: ReposData) {
//            Glide.with(itemView.context).load(content.imageUri).into(image)
            repoName.text = data.repoName
            language.text = data.language
            stargazers_count.text = data.stargazers_count
            watchers_count.text = data.watchers_count

        }
    }

}
