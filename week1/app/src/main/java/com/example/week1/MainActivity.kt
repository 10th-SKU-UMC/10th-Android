package com.example.week1

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.week1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val allTexts=listOf(
            binding.tvHappyDesc,
            binding.tvExcitedDesc,
            binding.tvSosoDesc,
            binding.tvAnxietyDesc,
            binding.tvAngryDesc
        )

        binding.btnHappy.setOnClickListener{
            changeStatus(binding.tvHappyDesc, allTexts,"#FFEFB6")
        }
        binding.btnExcited.setOnClickListener{
            changeStatus(binding.tvExcitedDesc, allTexts,"#CEE7F5" )
        }
        binding.btnSoso.setOnClickListener {
            changeStatus(binding.tvSosoDesc, allTexts, "#BEC3ED")
        }
        binding.btnAnxiety.setOnClickListener {
            changeStatus(binding.tvAnxietyDesc, allTexts, "#B1D3B9")
        }
        binding.btnAngry.setOnClickListener {
            changeStatus(binding.tvAngryDesc, allTexts, "#EB8B8B")
        }
    }
    private fun changeStatus(selectedText: TextView, allTexts: List<TextView>, colorCode: String) {
        for (text in allTexts) {
            text.setTextColor(Color.BLACK)
        }
        selectedText.setTextColor(Color.parseColor(colorCode))
    }
}
