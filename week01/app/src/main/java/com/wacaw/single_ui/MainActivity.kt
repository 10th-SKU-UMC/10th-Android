package com.wacaw.single_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import com.wacaw.single_ui.databinding.ActivityMainBinding
import androidx.core.graphics.toColorInt

class MainActivity : ComponentActivity() {
    // 바인딩 객체 변수 선언
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 바인딩 객체 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)

        // R.layout.activity_main -> binding.root
        setContentView(binding.root)

        // 감정 값 넣기
        binding.emotionHappy.apply {
            icEmotion.setImageResource(R.drawable.ic_happy)
            tvEmotionDesc.text = "더없이 행복한 하루였어요"
        }
        binding.emotionExciting.apply {
            icEmotion.setImageResource(R.drawable.ic_exciting)
            tvEmotionDesc.text = "들뜨고 흥분돼요"
        }
        binding.emotionNormal.apply {
            icEmotion.setImageResource(R.drawable.ic_normal)
            tvEmotionDesc.text = "평범한 하루였어요"
        }
        binding.emotionAnxious.apply {
            icEmotion.setImageResource(R.drawable.ic_anxious)
            tvEmotionDesc.text = "생각이 많아지고 불안해요"
        }
        binding.emotionAngry.apply {
            icEmotion.setImageResource(R.drawable.ic_angry)
            tvEmotionDesc.text = "부글부글 화가 나요"
        }

        // 감정 우표 클릭 이벤트 리스너
        binding.emotionHappy.root.setOnClickListener {
            binding.emotionHappy.tvEmotionDesc.setBackgroundColor(ContextCompat.getColor(this,R.color.emotion_color_happy))
        }
        binding.emotionExciting.root.setOnClickListener {
            binding.emotionExciting.tvEmotionDesc.setBackgroundColor(ContextCompat.getColor(this,R.color.emotion_color_exciting))
        }
        binding.emotionNormal.root.setOnClickListener {
            binding.emotionNormal.tvEmotionDesc.setBackgroundColor(ContextCompat.getColor(this,R.color.emotion_color_normal))
        }
        binding.emotionAnxious.root.setOnClickListener {
            binding.emotionAnxious.tvEmotionDesc.setBackgroundColor(ContextCompat.getColor(this,R.color.emotion_color_anxious))
        }
        binding.emotionAngry.root.setOnClickListener {
            binding.emotionAngry.tvEmotionDesc.setBackgroundColor(ContextCompat.getColor(this,R.color.emotion_color_angry))
        }

    }
}
