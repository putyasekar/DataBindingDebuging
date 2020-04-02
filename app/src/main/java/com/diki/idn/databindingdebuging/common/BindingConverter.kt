package com.diki.idn.databindingdebuging.common

import android.view.View
import androidx.databinding.BindingConversion

object ConverterCommonUnit {
    @JvmStatic
    fun isZero(position: Int): Boolean {
        return position == 0
    }
}

object BindingConverterCommonUtil {
    @BindingConversion
    @JvmStatic
    fun booleanToVisibility(isNotVisible: Boolean): Int {
        return if (isNotVisible) View.GONE else View.VISIBLE
    }
}