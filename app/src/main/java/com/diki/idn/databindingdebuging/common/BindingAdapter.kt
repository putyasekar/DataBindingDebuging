package com.diki.idn.databindingdebuging.common

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import com.diki.idn.databindingdebuging.R
import com.diki.idn.databindingdebuging.data.ProfileObservableViewModel

object BindingAdapter {
    @BindingAdapter("app:popularityIcon")
    @JvmStatic
    fun popularityIcon(imageView: ImageView, popularity: ProfileObservableViewModel.LikesNumber) {

        val color = getAssociatedColor(popularity, imageView.context)
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
        imageView.setImageDrawable(getDrawablePopularity(popularity, imageView.context))
    }

    fun tintPopularity(
        progressBar: ProgressBar,
        popularity: ProfileObservableViewModel.LikesNumber
    ) {
        val color = getAssociatedColor(popularity, progressBar.context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            progressBar.progressTintList = ColorStateList.valueOf(color)
        }
    }

    @BindingAdapter("app:hideIfZero")
    @JvmStatic
    fun hideIfZero(view: View, position: Int) {
        view.visibility = if (position == 0) View.GONE
        else View.VISIBLE
    }

    private fun getDrawablePopularity(
        popularity: ProfileObservableViewModel.LikesNumber,
        context: Context
    ): Drawable? {
        return when (popularity) {
            ProfileObservableViewModel.LikesNumber.NORMAL -> {
                ContextCompat.getDrawable(context, R.drawable.ic_person)
            }
            ProfileObservableViewModel.LikesNumber.POPULAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot)
            }
            ProfileObservableViewModel.LikesNumber.STAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot)
            }
        }
    }

    private fun getAssociatedColor(
        popularity: ProfileObservableViewModel.LikesNumber,
        context: Context
    ): Int {
        return when (popularity) {
            ProfileObservableViewModel.LikesNumber.NORMAL -> ContextCompat.getColor(
                context,
                R.color.normal
            )
            ProfileObservableViewModel.LikesNumber.POPULAR -> ContextCompat.getColor(
                context,
                R.color.popular
            )
            ProfileObservableViewModel.LikesNumber.STAR -> ContextCompat.getColor(
                context,
                R.color.star
            )
        }
    }
}