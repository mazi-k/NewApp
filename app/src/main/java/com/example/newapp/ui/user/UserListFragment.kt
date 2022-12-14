package com.example.newapp.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapp.App
import com.example.newapp.core.OnBackPressedListener
import com.example.newapp.core.OnItemClickListener
import com.example.newapp.databinding.FragmentUserListBinding
import com.example.newapp.model.GithubUser
import com.example.newapp.repository.impls.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserListFragment : MvpAppCompatFragment(), UserListView, OnBackPressedListener {

    companion object {
        fun getInstance(): UserListFragment {
            return UserListFragment()
        }
    }

    private lateinit var viewBinding: FragmentUserListBinding

    private val adapter = UserAdapter(object : OnItemClickListener {
        override fun onItemClick(user: GithubUser) {
            presenter.onItemChoose(user)
        }
    })
    private val presenter: UserListPresenter by moxyPresenter {
        UserListPresenter(GithubRepositoryImpl(), App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsers.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun showLoading() {
        viewBinding.waitBanner.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        viewBinding.waitBanner.visibility = View.GONE
    }

    override fun onBackPressed() = presenter.onBackPressed()

}
