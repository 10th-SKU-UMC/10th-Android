package com.wacaw.week09.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.wacaw.week09.R
import com.wacaw.week09.ui.theme.Week09Theme
import com.wontwothree.week09.domain.model.User
import com.wontwothree.week09.ui.components.CustomButton
import com.wontwothree.week09.ui.screens.profile.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel()
) {
    val user by viewModel.user.collectAsState()
    val following by viewModel.following.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(71.dp))

        // 프로필 사진
        AsyncImage(
            model = user?.avatar,
            contentDescription = "프로필 사진",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(84.dp)
                .clip(CircleShape)
        )

        Spacer(Modifier.height(30.dp))

        // 닉네임
        if(user!=null) {
            Text(
                text = "${user?.firstName} ${user?.lastName}",
                fontSize = 20.sp
            )
        }
        Spacer(Modifier.height(30.dp))

        // 프로필 수정 버튼
        CustomButton(
            text = "프로필 수정",
            onClick = {})
        Spacer(Modifier.height(40.dp))

        // 프로필 메뉴
        ProfileMenuRow()
        Spacer(Modifier.height(24.dp))
        HorizontalDivider(
            thickness = 7.dp,
            color = Color(0xFFF6F6F6))

        // 나이키 멤버 혜택
        NikeMemberBenefit()
        HorizontalDivider(
            thickness = 7.dp,
            color = Color(0xFFF6F6F6))

        // 팔로잉 리스트
        FollowingSection(followingList = following)
        Spacer(Modifier.height(96.dp))

        // 회원가입일
        Text(
            text = "회원 가입일: 2025년 9월",
            fontSize = 12.sp,
            color = Color(0xFF767676),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(color = Color(0xFFF6F6F6))
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
    }
}

@Composable
fun FollowingSection(followingList: List<User>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("팔로잉 (${followingList.size-1})", fontSize = 14.sp)
        Text("편집", fontSize = 12.sp, color = Color(0xFF767676))
    }
    Spacer(Modifier.height(18.dp))

    val showNum =3
    // 첫 번째 아이템을 제외하고 showNum(3)개씩 묶음
    val chunkedList = followingList.drop(1).chunked(showNum)
    val pagerState = rememberPagerState(pageCount = { chunkedList.size })

    if (chunkedList.isNotEmpty()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
        ) { pageIndex ->
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                // chunkedList 돌아가며 이미지 출력
                chunkedList[pageIndex].forEach { user ->
                    AsyncImage(
                        model = user.avatar,
                        contentDescription = "${user.firstName} 프로필",
                        modifier = Modifier
                            .size(106.dp)
                            .weight(1f)
                    )
                }
                repeat(showNum - chunkedList[pageIndex].size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun ProfileMenuRow(){
    data class MenuItem(val icon: Int, val label: String )

    val items = listOf(
        MenuItem(R.drawable.ic_order,"주문"),
        MenuItem(R.drawable.ic_pass,"패스"),
        MenuItem(R.drawable.ic_event,"이벤트"),
        MenuItem(R.drawable.ic_setting,"설정")
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        items.forEach {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id=it.icon),
                    contentDescription = it.label,
                    modifier = Modifier
                        .size(24.dp),
                    tint = Color(0xFFBABABA)
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    it.label,
                    fontSize = 12.sp
                )


            }
        }
    }
}

@Composable
fun NikeMemberBenefit() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp, horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment =  Alignment.CenterVertically
    ) {
        Column{
            Text("나이키 멤버 혜택", fontSize = 16.sp)
            Text("0개 사용 가능", fontSize = 12.sp, color = Color(0xFF767676))
        }
        Text(">")
    }
}

@Preview(showBackground = true,showSystemUi= true,)
@Composable
fun ProfileScreenPreview() {
    Week09Theme(){
        ProfileScreen()
    }
}
