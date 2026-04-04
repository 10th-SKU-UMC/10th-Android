package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView

class MainActivity: AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean{
        when (item.itemId)
        {
            R.id.access-> Toast.makeText(applicationContext,"접근성", Toast.LENGTH_SHORT).show()
            R.id.email-> Toast.makeText(applicationContext,"이메일", Toast.LENGTH_SHORT).show()
            R.id.message-> Toast.makeText(applicationContext,"메시지", Toast.LENGTH_SHORT).show()
        }
        layout_drawer.closeDrawers()
        return false
    }
}