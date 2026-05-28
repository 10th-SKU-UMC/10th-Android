package kr.co.umc.nike.presentation.bag.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * 화면 하단에서 주로 사용되는 재사용 가능한 액션 버튼 컴포넌트입니다.
 * 검은색 배경에 흰색 텍스트, 둥근 모서리가 적용된 가로 전체 너비의 버튼을 표시합니다.
 *
 * @param text 버튼에 표시될 텍스트 레이블.
 * @param onClick 버튼을 클릭했을 때 호출될 콜백 함수.
 * @param modifier 버튼에 적용할 [Modifier].
 */
@Composable
fun BottomActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
    ) {
        Text(text)
    }
}