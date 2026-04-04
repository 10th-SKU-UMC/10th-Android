package kr.co.umc.nike

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kr.co.umc.nike.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // 루트엔 top/side만
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            // BottomNav엔 bottom만
            binding.mainBnv.setPadding(0, 0, 0, systemBars.bottom)
            insets
        }

        // 바텀 내비게이션 세팅
        val navController = supportFragmentManager
            .findFragmentById(R.id.fragment_container)!!
            .findNavController()
        binding.mainBnv.setupWithNavController(navController)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}