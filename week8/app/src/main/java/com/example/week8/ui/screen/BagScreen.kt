package com.example.week8.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week8.R
import com.example.week8.navigation.AppDestination

@Composable
fun BagScreen(
    onBuyClick: () -> Unit //onBuyClick이라는 행동을 외부에서 받아서 사용하겠다.
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Image(
                painter = painterResource(id = R.drawable.bagcircle),
                contentDescription = "장바구니사진",
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "장바구니가 비어 있습니다.",
                color = Color.Black,
                fontSize = 20.sp,
            )
            Text(
                text = "제품을 추가하면 여기에 표시됩니다.",
                color = Color.Black,
                fontSize = 20.sp,
            )

            Spacer(modifier = Modifier.height(400.dp))

            Button(
                onClick = onBuyClick
            ) {
                Text(text = "구매하기")
            }
        }
    }
}