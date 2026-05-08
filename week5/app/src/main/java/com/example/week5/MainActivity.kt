package com.example.week5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
        private set
    lateinit var db: ProductDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = ProductDatabase.getDatabase(this)

        // 초기 상품 삽입을 먼저 끝내고 그 다음에 Fragment 표시 (race condition 방지)
        Thread {
            insertInitialProducts()
            runOnUiThread {
                if (savedInstanceState == null) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, HomeFragment())
                        .commit()
                }
            }
        }.start()

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

    private fun insertInitialProducts() {
        val dao = db.productDao()
        if (dao.getAllProducts().isEmpty()) {
            dao.insertProduct(
                ProductEntity(
                    imgRes = R.drawable.air_jordan,
                    title = "Air Jordan XXXVI",
                    price = getString(R.string.us_185),
                    description = "Best seller shoes",
                    isBestSeller = true,
                    category = "sale"
                )
            )
            dao.insertProduct(
                ProductEntity(
                    imgRes = R.drawable.air_force,
                    title = "Nike Air Force 1'07",
                    price = "US$115",
                    description = "Classic Nike shoes",
                    isBestSeller = true,
                    isInBag = true,
                    category = null
                )
            )
            dao.insertProduct(
                ProductEntity(
                    imgRes = R.drawable.socks,
                    title = "Nike Everyday Plus Cushioned",
                    price = "US$10",
                    description = "Comfortable socks",
                    isWishlisted = true,
                    category = "sale"
                )
            )
            dao.insertProduct(
                ProductEntity(
                    imgRes = R.drawable.nikeelitecrew,
                    title = "Nike Elite Crew",
                    price = "US$16",
                    description = "Sports socks",
                    category = null
                )
            )
            dao.insertProduct(
                ProductEntity(
                    imgRes = R.drawable.jordan1mid,
                    title = "Air Jordan 1 Mid",
                    price = "US$125",
                    description = "Jordan shoes",
                    isWishlisted = true,
                    category = null
                )
            )
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
