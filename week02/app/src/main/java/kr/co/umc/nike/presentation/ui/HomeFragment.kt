package kr.co.umc.nike.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import kr.co.umc.nike.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var backPressedTime: Long = 0
    private val backPressInterval: Long = 2000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBackPressHandler()
    }

    /**
     * 뒤로가기 버튼을 두 번 눌러야 종료되도록 설정
     */
    private fun setupBackPressHandler() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            // 현재 시간과 이전에 뒤로가기를 누른 시간의 차이 계산
            if (System.currentTimeMillis() - backPressedTime <= backPressInterval) {
                // 2초 이내에 다시 뒤로가기를 누르면 앱 종료
                requireActivity().finish()
            } else {
                // 첫 번째 뒤로가기: 토스트 메시지 표시
                backPressedTime = System.currentTimeMillis()
                Toast.makeText(
                    requireContext(),
                    "뒤로 버튼을 한 번 더 누르면 종료됩니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
