package com.example.week5

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.week5.databinding.FragmentProfileBinding
import kotlinx.coroutines.launch

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentProfileBinding.bind(view)

        binding.rvFollowing.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        getMyProfile()
        getFollowingList()
    }

    private fun getMyProfile() {
        lifecycleScope.launch {
            try {
                val response = ApiClient.profileService.getUser(1)

                if (response.isSuccessful) {
                    val user = response.body()?.data ?: return@launch

                    binding.tvNickname.text = "${user.first_name} ${user.last_name}"

                    Glide.with(requireContext())
                        .load(user.avatar)
                        .circleCrop()
                        .into(binding.imgProfile)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getFollowingList() {
        lifecycleScope.launch {
            try {
                val response = ApiClient.profileService.getUsers(page = 1)

                if (response.isSuccessful) {
                    val users = response.body()?.data ?: emptyList()

                    binding.tvFollowing.text = "팔로잉 (${users.size})"
                    binding.rvFollowing.adapter = FollowingAdapter(users)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
