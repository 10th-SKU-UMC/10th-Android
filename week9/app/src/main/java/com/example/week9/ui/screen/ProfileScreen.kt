package com.example.week9.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.week9.R
import com.example.week9.model.ReqresUser
import com.example.week9.network.ApiClient
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.TextButton
import coil.compose.AsyncImage
import com.example.week9.navigation.AppDestination

@Composable
fun ProfileScreen(navController: NavHostController) {
    var currentUser by remember { mutableStateOf<ReqresUser?>(null) }
    var followingList by remember { mutableStateOf<List<ReqresUser>>(emptyList()) }
    var isLoading by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        isLoading = true
        try {
            val response = ApiClient.productService.getUsers()
            val users = response.data
            if (users.isNotEmpty()) {
                currentUser = users.find{it.id==1}
                followingList = users.filter{it.id!=1}
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            isLoading = false
        }
    }
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        //프로필 부분
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = currentUser?.avatar,
                    contentDescription = "프로필 사진",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = currentUser?.let { "${it.first_name} ${it.last_name}" } ?: "닉네임",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedButton(
                    onClick = { navController.navigate(AppDestination.ProfileEdit) },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .height(44.dp)
                ) {
                    Text(text = "프로필 수정", fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.height(20.dp))

                //주문/패스/이벤트/설정
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    listOf(
                        Pair(R.drawable.order, "주문"),
                        Pair(R.drawable.pass, "패스"),
                        Pair(R.drawable.event, "이벤트"),
                        Pair(R.drawable.set, "설정")
                    ).forEach { (drawable, label) ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable {}
                        ) {
                            Icon(
                                painter = painterResource(id = drawable),
                                contentDescription = label,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = label, fontSize = 12.sp, color = Color.Black)
                        }
                    }
                }
            }
        }
        //멤버 혜택 부분
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .clickable {}
                    .padding(horizontal = 20.dp, vertical = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "나이키 멤버 혜택",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "0개 사용 가능",
                        fontSize = 13.sp,
                        color = Color.Gray
                    )
                }
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "혜택 보기",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        //팔로잉 부분
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(vertical = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "팔로잉 (${followingList.size})",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    TextButton(
                        onClick = {},
                        modifier = Modifier.height(32.dp)
                    ) {
                        Text(
                            text = "편집",
                            fontSize = 13.sp,
                            color=Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                val pagerState=rememberPagerState(pageCount={followingList.size})
                HorizontalPager(
                    state=pagerState,
                    pageSize= PageSize.Fixed(96.dp),
                    // :한 페이지의 너비를 96dp로 고정해서, 팔로잉프로필들이 가로로 여러개 보이게 함
                    contentPadding=PaddingValues(horizontal=20.dp),
                    pageSpacing=12.dp,
                    modifier=Modifier.fillMaxWidth()
                ){ page->
                    val user=followingList[page]
                    Column(horizontalAlignment=Alignment.CenterHorizontally){
                        AsyncImage(
                            model=user.avatar,
                            contentDescription = "${user.first_name} ${user.last_name} 프로필",
                            contentScale=ContentScale.Crop,
                            modifier= Modifier
                                .size(80.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.LightGray)
                        )
                        Spacer(modifier=Modifier.height(4.dp))
                        Text(
                            text=user.first_name,
                            fontSize=11.sp,
                            color=Color.Gray
                        )
                    }
                }
            }
        }
        //회원가입일
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "회원 가입일: 2025년 9월",
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
        }
    }
}