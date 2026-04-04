package com.example.pract

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pract.ui.theme.PractTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val profileList=arrayListOf(
            Profiles(R.drawable.man, "홍드로이드",27,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman, "이다은",20,"백수"),
            Profiles(R.drawable.woman, "김지우",21,"치과의사"),
            Profiles(R.drawable.man, "홍길동",58,"전기통닭판매"),
            Profiles(R.drawable.man, "오정민",23,"오수생"),
            Profiles(R.drawable.woman, "신연지",22,"간호사"),
            Profiles(R.drawable.man, "이재명",64,"대통령"),
            Profiles(R.drawable.man, "이성근",54,"총장"),
        )
        setContentView(R.layout.activity_main)
        val rv_profile=findViewById<RecyclerView>(R.id.rv_profile)
        rv_profile.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rv_profile.setHasFixedSize(true)

        rv_profile.adapter= ProfileAdapter(profileList)
    }
}