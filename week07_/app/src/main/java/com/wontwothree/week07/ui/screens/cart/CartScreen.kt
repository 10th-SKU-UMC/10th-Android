package com.wontwothree.week07.ui.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wontwothree.week07.R
import com.wontwothree.week07.ui.theme.Week07Theme

@Composable
fun CartScreen(onOrderBtnClick:()->Unit){
    Box(modifier = Modifier.fillMaxSize())
        {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_bag_circle),
                    contentDescription = "장바구니 아이콘",
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                )
                Spacer(Modifier.height(27.dp))
                Text("장바구니가 비어 있습니다.", fontSize = 16.sp)
                Text("제품을 추가하면 여기에 표시됩니다.", fontSize = 16.sp)
            }
            Button(
                onClick = onOrderBtnClick,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(51.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "주문하기", fontSize = 16.sp)
            }
        }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Week07Theme(){
        CartScreen({})
    }
}
