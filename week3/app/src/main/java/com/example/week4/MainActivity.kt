package com.example.week4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, HomeFragment())
                .commit()
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            changeFragment(item.itemId)
            true
        }

        supportFragmentManager.addOnBackStackChangedListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.main_container)

            when (currentFragment) {
                is HomeFragment -> binding.bottomNavigation.menu.findItem(R.id.menu_home).isChecked = true
                is WishlistFragment -> binding.bottomNavigation.menu.findItem(R.id.menu_wishlist).isChecked = true
                is BagFragment -> binding.bottomNavigation.menu.findItem(R.id.menu_bag).isChecked = true
                is ProfileFragment -> binding.bottomNavigation.menu.findItem(R.id.menu_profile).isChecked = true
            }
        }
    }

    fun changeFragment(menuId: Int) {
        val fragment = when (menuId) {
            R.id.menu_home -> HomeFragment()
            R.id.menu_buy -> BuyFragment()
            R.id.menu_wishlist -> WishlistFragment()
            R.id.menu_bag -> BagFragment()
            R.id.menu_profile -> ProfileFragment()
            else -> return
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
    }

    fun moveToDetail() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, DetailFragment())
            .addToBackStack(null)
            .commit()
    }
}