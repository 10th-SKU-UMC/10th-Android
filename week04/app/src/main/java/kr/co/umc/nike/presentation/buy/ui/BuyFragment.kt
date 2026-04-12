package kr.co.umc.nike.presentation.buy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kr.co.umc.nike.databinding.FragmentBuyBinding
import kr.co.umc.nike.presentation.buy.adapter.GoodsVPAdapter

class BuyFragment : Fragment() {

    private var _binding: FragmentBuyBinding? = null
    private val binding get() = _binding!!
    private lateinit var goodsVPAdapter: GoodsVPAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goodsVPAdapter = GoodsVPAdapter(this)
        binding.vpFragmentContainer.adapter = goodsVPAdapter

        TabLayoutMediator(binding.tblGoodsOnSale, binding.vpFragmentContainer) { tab, position ->
            tab.text = when (position) {
                0 -> "전체"
                1 -> "Tops & T-Shirts"
                2 -> "sale"
                else -> ""
            }
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}