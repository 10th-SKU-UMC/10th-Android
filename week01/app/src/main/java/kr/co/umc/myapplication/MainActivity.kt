package kr.co.umc.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.co.umc.myapplication.databinding.ActivityMainBinding
import kr.co.umc.myapplication.presentation.Angry
import kr.co.umc.myapplication.presentation.Exciting
import kr.co.umc.myapplication.presentation.Happy
import kr.co.umc.myapplication.presentation.Idle
import kr.co.umc.myapplication.presentation.MainViewModel
import kr.co.umc.myapplication.presentation.Unselected
import kr.co.umc.myapplication.presentation.Worry

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityMainBinding.inflate(layoutInflater)

        // 정적 UI 및 클릭리스너 세팅
        with(binding) {
            with(lyHappy) {
                ivMood.apply {
                    setImageResource(R.drawable.happy)
                    setOnClickListener { viewModel.onSelect(Happy)}
                }
                tvMood.setText(R.string.very_happy)
            }
            with(lyExciting) {
                ivMood.apply {
                    setImageResource(R.drawable.exciting)
                    setOnClickListener { viewModel.onSelect(Exciting) }
                }
                tvMood.setText(R.string.very_exciting)
            }
            with(lyIdle) {
                ivMood.apply {
                    setImageResource(R.drawable.idle)
                    setOnClickListener { viewModel.onSelect(Idle) }
                }
                tvMood.setText(R.string.just_idle)
            }
            with(lyWorry) {
                ivMood.apply {
                    setImageResource(R.drawable.worry)
                    setOnClickListener { viewModel.onSelect(Worry) }
                }
                tvMood.setText(R.string.very_worry)
            }
            with(lyAngry) {
                ivMood.apply{
                    setImageResource(R.drawable.angry)
                    setOnClickListener { viewModel.onSelect(Angry) }
                }
                tvMood.setText(R.string.very_angry)
            }
        }

        setContentView(binding.root)
        observeSelectedEmotionState()

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // 상태를 구독하고 ui에 반영하는 함수
    private fun observeSelectedEmotionState() {
        lifecycleScope.launch {
            viewModel.selectedEmotionState.collect { state ->

                // 기본값: 모두 블랙
                with(binding) {
                    lyHappy.tvMood.setTextColor(Color.BLACK)
                    lyExciting.tvMood.setTextColor(Color.BLACK)
                    lyIdle.tvMood.setTextColor(Color.BLACK)
                    lyWorry.tvMood.setTextColor(Color.BLACK)
                    lyAngry.tvMood.setTextColor(Color.BLACK)
                    // 상태별 색 적용
                    when (state) {
                        is Happy -> lyHappy.tvMood.setTextColor(getColor(R.color.happy_yellow))
                        is Exciting -> lyExciting.tvMood.setTextColor(getColor(R.color.exciting_blue))
                        is Idle -> lyIdle.tvMood.setTextColor(getColor(R.color.idle_blue))
                        is Worry -> lyWorry.tvMood.setTextColor(getColor(R.color.worry_green))
                        is Angry -> lyAngry.tvMood.setTextColor(getColor(R.color.angry_red))
                        is Unselected -> { }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}