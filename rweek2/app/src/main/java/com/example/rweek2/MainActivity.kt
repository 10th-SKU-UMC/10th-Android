package com.example.rweek2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rweek2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       supportFragmentManager
           .beginTransaction()
           .replace(binding, BuyFragment())
           .commit
        binding.buy.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(binding.frameFragment.id, BuyFragment())
                .commit()
        }
    }
}