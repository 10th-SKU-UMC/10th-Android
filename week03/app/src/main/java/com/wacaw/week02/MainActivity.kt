package com.wacaw.week02

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.wacaw.week02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // 첫 화면 지정 : HomeFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragmentContainer, HomeFragment())
            .commit()


        // bottom_nav : fragment 전환
        binding.mainBnv.setOnItemSelectedListener { item ->
            when(item.itemId){ // 클릭된 아이템ID 식별
                // fragment_1 : 매인
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction() // FragmentManager에게 화면 변경 요청
                        .replace(R.id.main_fragmentContainer, HomeFragment()) // (교체) 이전 fragment-> 새 fragment
                        .commit() // (반영) 변경 사항 확정
                    true // setOnItemSelectedListener 응답 : 메뉴 아이콘 'Selected' 상태로 업데이트
                }
                // fragment_2 : 구매
                R.id.purchaseFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragmentContainer, PurchaseFragment())
                        .commit()
                    true
                }
                // fragment_3 : 위시리스트
                R.id.wishlistFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragmentContainer, WishlistFragment())
                        .commit()
                    true
                }
                // fragment_4 : 장바구니
                R.id.shoppingCartFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragmentContainer, ShoppingCartFragment())
                        .commit()
                    true
                }// fragment_5 : 프로필
                R.id.profileFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragmentContainer, ProfileFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }


}
