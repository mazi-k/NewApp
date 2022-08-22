package com.example.newapp.ui.user

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newapp.R
import com.example.newapp.model.GithubUser

class UserAdapter() :
    RecyclerView.Adapter<GithubUserViewHolder>() {

    private lateinit var onItemClick: ((GithubUser) -> Unit)

    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return GithubUserViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        val user = users[position]

        holder.bind(users[position])

        holder.itemView.setOnClickListener {
            onItemClick.invoke(user)
        }
    }

    override fun getItemCount() = users.size

    fun setOnItemClickListener(gh: (GithubUser) -> Unit) {
        onItemClick = gh
    }
}

class GithubUserViewHolder(itemView: View, private val clickListener: (GithubUser) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    lateinit var githubUser: GithubUser

    private val tvLogin by lazy { itemView.findViewById<TextView>(R.id.tvUserLogin) }

    fun bind(user: GithubUser) = with(user) {
        tvLogin.text = login
        githubUser = user
        itemView.setOnClickListener {
            itemView.setOnClickListener { v: View? ->
                clickListener.invoke(githubUser)
            }
        }
    }

    init {
        itemView.setOnClickListener {
            itemView.setOnClickListener { v: View? ->
                clickListener.invoke(githubUser)
            }
        }
    }
}
