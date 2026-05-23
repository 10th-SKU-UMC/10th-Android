package kr.co.umc.nike.presentation.profile.model

import kr.co.umc.nike.R

enum class Menu(
    val iconRes: Int,
    val text: String,
) {
    ORDER(R.drawable.order_archive, "주문"),
    PASS(R.drawable.pass_card, "패스"),
    EVENT(R.drawable.event_calendar, "이벤트"),
    SETTINGS(R.drawable.settings, "설정")
}