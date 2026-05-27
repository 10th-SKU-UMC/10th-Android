package com.example.and_practice.presentation.ui.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.and_practice.R

@Composable
fun CartRoute(
    onNavigateToPurchase: () -> Unit,
    viewModel: CartViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    CartScreen(
        uiState = uiState,
        onNavigateToPurchase = onNavigateToPurchase
    )
}

@Composable
fun CartScreen(
    uiState: CartUiState,
    onNavigateToPurchase: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_bagcircle),
                    contentDescription = "Empty cart",
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(26.dp))
                Text(
                    text = uiState.emptyMessage,
                    style = TextStyle(
                        color = Color(0xFF000000),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 16.8.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onNavigateToPurchase,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 2.dp, end = 2.dp, bottom = 21.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000),
                    contentColor = Color(0xFFFFFFFF)
                )
            ) {
                Text(
                    text = uiState.orderButtonText,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 19.2.sp
                    )
                )
            }
        }
    }
}
