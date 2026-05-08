package com.wacaw.week02

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.wacaw.week02.data.remote.ApiClient
import com.wacaw.week02.databinding.FragmentProfileBinding
import com.bumptech.glide.Glide
import com.wacaw.week02.adapter.FollowersAdapter
import com.wacaw.week02.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var followersAdapter: FollowersAdapter
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        followersAdapter = FollowersAdapter(emptyList())
        binding.llFollower.adapter = followersAdapter

        // UI 업데이트
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                launch {
                    viewModel.userList.collect { userList ->
                        if (userList.isNotEmpty()) {
                            val firstUser = userList[0]
                            binding.tvNickname.text = "${firstUser.first_name} ${firstUser.last_name}"
                            Glide.with(this@ProfileFragment)
                                .load(firstUser.avatar)
                                .circleCrop()
                                .into(binding.ivAvatar)

                            val followingList = userList.drop(1)
                            followersAdapter.setList(followingList)
                            binding.tvFollowerCount.text = "팔로잉 (${followingList.size})"
                        }
                    }
                }

                launch {
                    viewModel.error.collect { errorMsg ->
                        errorMsg?.let { Log.e("API_ERROR", it) }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}