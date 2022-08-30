package com.example.newapp.ui.user

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newapp.R
import com.example.newapp.core.OnItemClickListener
import com.example.newapp.model.GithubUser

class UserAdapter(
    private var onItemViewClick: OnItemClickListener
) :
    RecyclerView.Adapter<GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return GithubUserViewHolder(view, onItemViewClick)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size
}

class GithubUserViewHolder(itemView: View, private val clickListener: OnItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    lateinit var githubUser: GithubUser

    private val tvLogin by lazy { itemView.findViewById<TextView>(R.id.tvUserLogin) }

    fun bind(user: GithubUser) = with(user) {
        githubUser = user
        tvLogin.text = login
        itemView.apply {
            setOnClickListener { clickListener.onItemClick(user) }
        }
    }

    init {
        itemView.apply {
            setOnClickListener { clickListener.onItemClick(githubUser) }
        }
    }
}
