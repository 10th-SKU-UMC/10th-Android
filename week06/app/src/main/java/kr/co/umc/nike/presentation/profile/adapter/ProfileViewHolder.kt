package kr.co.umc.nike.presentation.profile.adapter

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.request.crossfade
import coil3.request.error
import coil3.request.fallback
import coil3.request.placeholder
import kr.co.umc.nike.R
import kr.co.umc.nike.databinding.ItemFollowingUserBinding
import kr.co.umc.nike.presentation.profile.model.Profile
import timber.log.Timber

class ProfileViewHolder(
    val binding: ItemFollowingUserBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(profile: Profile) {
        val placeholder = AppCompatResources.getDrawable(binding.root.context, R.drawable.img_rv_placeholder)

        binding.ivFollowingUser.load(profile.avatar) {
            crossfade(true)
            placeholder(placeholder)
            fallback(placeholder)
            error(placeholder)
        }
        Timber.d("리사이클러뷰 이미지 로딩 완료")

    }

}