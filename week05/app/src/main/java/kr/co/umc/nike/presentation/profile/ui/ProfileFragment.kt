package kr.co.umc.nike.presentation.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import coil3.load
import coil3.request.crossfade
import coil3.request.error
import coil3.request.fallback
import coil3.request.placeholder
import dagger.hilt.android.AndroidEntryPoint
import kr.co.umc.nike.R
import kotlinx.coroutines.launch
import kr.co.umc.nike.databinding.FragmentProfileBinding
import kr.co.umc.nike.presentation.profile.adapter.ProfileRVAdapter
import kr.co.umc.nike.presentation.profile.adapter.ProfileRVDecorator
import kr.co.umc.nike.presentation.profile.viewmodel.ProfileViewModel
import kr.co.umc.nike.presentation.util.UiState
import timber.log.Timber

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var profileRVAdapter: ProfileRVAdapter
    private lateinit var profileRVDecorator: ProfileRVDecorator

    private val placeholder by lazy {
        AppCompatResources.getDrawable(requireContext(), R.drawable.img_rv_placeholder)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        observeProfileState()
    }

    private fun setRecyclerView() {
        profileRVAdapter = ProfileRVAdapter()
        profileRVDecorator = ProfileRVDecorator(16)

        binding.rvFollowingUsers.apply {
            adapter = profileRVAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(profileRVDecorator)
        }
        // 더미 데이터 (API 연동 전 테스트용)
//        val dummyList = List(5) { i ->
//            Profile(id = i, email = "", name = "", avatar = "")
//        }
//        profileRVAdapter.submitList(dummyList)
        Timber.d("리사이클러뷰 세팅 완료")
    }

    private fun observeProfileState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.profileState.collect { state ->
                    when (state) {
                        is UiState.Idle -> Unit

                        is UiState.Loading -> {
                            Timber.d("프로필 로딩 중")
                            binding.rvFollowingUsers.visibility = View.INVISIBLE
                            binding.pbRvLoading.visibility = View.VISIBLE
                        }

                        is UiState.Success -> {
                            binding.rvFollowingUsers.visibility = View.VISIBLE
                            binding.pbRvLoading.visibility = View.GONE
                            binding.tvNickName.text = state.data[0].name
                            val ph = placeholder
                            binding.ivProfile.load(state.data[0].avatar) {
                                crossfade(true)
                                placeholder(ph)
                                fallback(ph)
                                error(ph)
                            }
                            profileRVAdapter.submitList(state.data.drop(1))
                            Timber.d("프로필 로드 성공: ${state.data.size}명")
                        }

                        is UiState.Error -> {
                            Timber.e("프로필 로드 실패: ${state.message}")
                        }
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
