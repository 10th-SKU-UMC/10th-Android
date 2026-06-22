package com.wontwothree.week09.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wacaw.week09.ui.theme.Week09Theme

@Composable
fun CustomButton(
    text :String,
    onClick: () -> Unit,

){
    OutlinedButton(
        onClick=onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black,
        ),
        contentPadding = PaddingValues(horizontal = 51.dp, vertical =16.dp ),
        border = BorderStroke(1.dp, Color(0xFFE4E4E4))
    ){
        Text(text, fontSize = 16.sp, fontStyle = FontStyle.Normal)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Week09Theme(){
        CustomButton(
            "Button",
            {}
        )
    }
}
