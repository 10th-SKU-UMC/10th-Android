package kr.co.umc.nike.presentation.feat_home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.umc.nike.R
import kr.co.umc.nike.databinding.FragmentHomeBinding
import kr.co.umc.nike.presentation.feat_home.adapter.NewGoodsRVAdapter
import kr.co.umc.nike.presentation.feat_home.adapter.NewGoodsRVDecorator
import kr.co.umc.nike.presentation.feat_home.model.NewGood

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
        setDummyData()
    }

    private fun setDummyData() {
        val goodsList = mutableListOf<NewGood>(
            NewGood(
                R.drawable.img_air_jordan,
                "Air Jordan XXXVI",
                "US\$185"
            ),
            NewGood(
                R.drawable.img_air_force,
                "Nike Air Force 1 '07",
                "US\$115"
            ),
        )

        val adapter = NewGoodsRVAdapter(goodsList)
        val decorator = NewGoodsRVDecorator()
        binding.apply {
            rvNewGoods.adapter = adapter
            rvNewGoods.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvNewGoods.addItemDecoration(decorator)
        }
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