package com.diki.idn.databindingdebuging.data

import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.diki.idn.databindingdebuging.common.ProfileViewModel

class ProfileLiveDataViewModel : ViewModel() {
    private val _name = MutableLiveData("Name")
    private val _lastName = MutableLiveData("lastName")
    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastname: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes

    val popularity: LiveData<ProfileObservableViewModel.LikesNumber> = Transformations.map(_likes) {
        when {
            it > 9 -> ProfileObservableViewModel.LikesNumber.STAR
            it > 5 -> ProfileObservableViewModel.LikesNumber.POPULAR
            else -> ProfileObservableViewModel.LikesNumber.NORMAL
        }
    }

    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }
}

class ProfileObservableViewModel : ProfileViewModel() {
    val name = ObservableField("Putya Sekar Ayu")
    private val likes = ObservableInt(0)

    enum class LikesNumber {
        NORMAL,
        POPULAR,
        STAR
    }

    fun onLike() {
        likes.increment()
        notifyPropertyChanged(com.diki.idn.databindingdebuging.BR.popularity)
    }

    @Bindable
    fun getPopularity(): LikesNumber {
        return likes.get().let {
            when {
                it > 9 -> LikesNumber.STAR
                it > 5 -> LikesNumber.POPULAR
                else -> LikesNumber.NORMAL
            }
        }
    }
}

private fun ObservableInt.increment() {
    set(get() + 1)
}
