package kr.co.umc.nike.presentation.util

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize

/**
 * [Modifier]의 배경에 무한히 반복되는 쉬머(shimmer) 효과 애니메이션을 적용합니다.
 * 주로 UI 컴포넌트가 데이터를 불러오는 동안 보여줄 로딩 플레이스홀더(placeholder)로 사용됩니다.
 *
 * 이 효과는 컴포넌트의 영역을 가로질러 수평으로 이동하는 선형 그라데이션을 생성하며,
 * 무한히 반복되는 트랜지션을 통해 움직임을 구현합니다.
 *
 */
fun Modifier.shimmerEffect(): Modifier = composed {

    // 현재 컴포넌트의 실제 크기를 저장하는 상태
    // gradient의 이동 범위 계산에 사용됨
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

    // 무한 반복 애니메이션 트랜지션 생성
    val transition = rememberInfiniteTransition(label = "shimmer")

    // shimmer gradient의 시작 X 좌표
    // 왼쪽 바깥(-2배 width)에서 시작하여
    // 오른쪽 바깥(+2배 width)까지 이동
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),

        // 1초 동안 애니메이션을 반복 실행
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        ),
        label = ""
    )

    // linearGradient 브러시를 배경에 적용
    background(
        brush = Brush.linearGradient(

            // 밝은 회색 -> 어두운 회색 -> 밝은 회색
            // 중앙이 더 밝게 지나가며 shimmer 느낌 생성
            colors = listOf(
                Color(0xFFB8B5B5),
                Color(0xFF8F8B8B),
                Color(0xFFB8B5B5),
            ),

            // gradient 시작 위치
            // startOffsetX 값이 계속 변하면서 shimmer가 이동함
            start = Offset(startOffsetX, 0f),

            // gradient 끝 위치
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    )
        // 실제 배치된 컴포넌트의 크기를 측정
        // size 상태 업데이트 → gradient 이동 범위 계산 가능
        .onGloballyPositioned {
            size = it.size
        }
}