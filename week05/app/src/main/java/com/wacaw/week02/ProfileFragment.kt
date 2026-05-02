package com.wacaw.week02

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.wacaw.week02.data.remote.ApiClient
import com.wacaw.week02.databinding.FragmentProfileBinding
import com.bumptech.glide.Glide
import com.wacaw.week02.adapter.FollowersAdapter
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var followersAdapter: FollowersAdapter

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

        // 코루틴
        viewLifecycleOwner.lifecycleScope.launch{
            try {
                // 비동기 통신 호출
                val response = ApiClient.userService.getUser()

                if (response.isSuccessful) {
                    val userResponse = response.body()
                    val userList = userResponse?.data ?: emptyList()

                    if (userList.isNotEmpty()) {
                        // 상단 프로필
                        val firstUser = userList[0]
                        binding.tvNickname.text = "${firstUser.first_name} ${firstUser.last_name}"
                        Glide.with(this@ProfileFragment)
                            .load(firstUser.avatar)
                            .circleCrop()
                            .into(binding.ivAvatar)

                        // 리사이클러뷰, 전체 유저 리스트
                        val followingList = userList.drop(1)
                        followersAdapter.setList(followingList)

                        // 팔로잉 숫자
                        binding.tvFollowerCount.text = "팔로잉 (${followingList.size})"
                    }
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", e.message ?: "Unknown Error")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}