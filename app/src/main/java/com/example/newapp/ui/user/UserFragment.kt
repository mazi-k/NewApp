package com.example.newapp.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.newapp.App
import com.example.newapp.GITHUB_USER
import com.example.newapp.core.OnBackPressedListener
import com.example.newapp.databinding.FragmentUserBinding
import com.example.newapp.repository.impls.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener {
    companion object {
        fun getInstance(bundle: Bundle): UserFragment {
            return UserFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var binding: FragmentUserBinding
    private lateinit var userId: String

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userId = arguments?.getString(GITHUB_USER).toString()
        with(binding) {
            login.text = userId
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun someAction() {
        Toast.makeText(requireContext(), "TOAST", Toast.LENGTH_LONG).show()
    }
}