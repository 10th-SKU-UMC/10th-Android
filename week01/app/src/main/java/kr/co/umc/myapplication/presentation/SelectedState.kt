package kr.co.umc.myapplication.presentation

sealed class SelectedState

object Unselected : SelectedState()
object Happy : SelectedState()
object Exciting : SelectedState()
object Idle : SelectedState()
object Worry : SelectedState()
object Angry : SelectedState()
