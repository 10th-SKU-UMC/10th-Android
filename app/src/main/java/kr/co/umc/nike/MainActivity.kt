package kr.co.umc.nike

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
import kr.co.umc.nike.databinding.ActivityMainBinding
import kr.co.umc.nike.presentation.MainViewModel
import kr.co.umc.nike.presentation.SelectedState

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityMainBinding.inflate(layoutInflater)

        // 정적 UI 세팅
        with(binding) {
            with(lyHappy) {
                ivMood.setImageResource(R.drawable.happy)
                ivMood.setOnClickListener { viewModel.onSelect(SelectedState.Happy)}
                tvMood.setText(R.string.very_happy)
            }
            with(lyExciting) {
                ivMood.setImageResource(R.drawable.exciting)
                ivMood.setOnClickListener { viewModel.onSelect(SelectedState.Exciting) }
                tvMood.setText(R.string.very_exciting)
            }
            with(lyIdle) {
                ivMood.setImageResource(R.drawable.idle)
                ivMood.setOnClickListener { viewModel.onSelect(SelectedState.Idle) }
                tvMood.setText(R.string.just_idle)
            }
            with(lyWorry) {
                ivMood.setImageResource(R.drawable.worry)
                ivMood.setOnClickListener { viewModel.onSelect(SelectedState.Worry) }
                tvMood.setText(R.string.very_worry)
            }
            with(lyAngry) {
                ivMood.setImageResource(R.drawable.angry)
                ivMood.setOnClickListener { viewModel.onSelect(SelectedState.Angry) }
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

    private fun observeSelectedEmotionState() {
        lifecycleScope.launch {
            viewModel.selectedEmotionState.collect { state ->
                when(state) {
                    is SelectedState.Happy -> {
                        binding.lyHappy.tvMood.setTextColor(Color.YELLOW)

                        binding.lyExciting.tvMood.setTextColor(Color.BLACK)
                        binding.lyIdle.tvMood.setTextColor(Color.BLACK)
                        binding.lyWorry.tvMood.setTextColor(Color.BLACK)
                        binding.lyAngry.tvMood.setTextColor(Color.BLACK)
                    }
                    is SelectedState.Exciting -> {
                        binding.lyExciting.tvMood.setTextColor(Color.CYAN)

                        binding.lyHappy.tvMood.setTextColor(Color.BLACK)
                        binding.lyIdle.tvMood.setTextColor(Color.BLACK)
                        binding.lyWorry.tvMood.setTextColor(Color.BLACK)
                        binding.lyAngry.tvMood.setTextColor(Color.BLACK)
                    }
                    is SelectedState.Idle -> {
                        binding.lyIdle.tvMood.setTextColor(Color.BLUE)

                        binding.lyHappy.tvMood.setTextColor(Color.BLACK)
                        binding.lyExciting.tvMood.setTextColor(Color.BLACK)
                        binding.lyWorry.tvMood.setTextColor(Color.BLACK)
                        binding.lyAngry.tvMood.setTextColor(Color.BLACK)
                    }
                    is SelectedState.Worry -> {
                        binding.lyWorry.tvMood.setTextColor(Color.GREEN)

                        binding.lyHappy.tvMood.setTextColor(Color.BLACK)
                        binding.lyExciting.tvMood.setTextColor(Color.BLACK)
                        binding.lyIdle.tvMood.setTextColor(Color.BLACK)
                        binding.lyAngry.tvMood.setTextColor(Color.BLACK)
                    }
                    is SelectedState.Angry -> {
                        binding.lyAngry.tvMood.setTextColor(Color.RED)

                        binding.lyHappy.tvMood.setTextColor(Color.BLACK)
                        binding.lyExciting.tvMood.setTextColor(Color.BLACK)
                        binding.lyIdle.tvMood.setTextColor(Color.BLACK)
                        binding.lyWorry.tvMood.setTextColor(Color.BLACK)
                    }
                    is SelectedState.Unselected -> {
                        binding.lyHappy.tvMood.setTextColor(Color.BLACK)
                        binding.lyExciting.tvMood.setTextColor(Color.BLACK)
                        binding.lyIdle.tvMood.setTextColor(Color.BLACK)
                        binding.lyWorry.tvMood.setTextColor(Color.BLACK)
                        binding.lyAngry.tvMood.setTextColor(Color.BLACK)
                    }
                    else -> {}
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}