package com.diki.idn.databindingdebuging.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.diki.idn.databindingdebuging.R
import com.diki.idn.databindingdebuging.data.ProfileLiveDataViewModel
import com.diki.idn.databindingdebuging.databinding.ProfileScreenBinding
import com.diki.idn.databindingdebuging.databinding.ProfileScreenBindingImpl

class ProfileScreenViewModel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val profileViewModel = ViewModelProviders.of(this).get(ProfileLiveDataViewModel::class.java)

        val bindingLayout: ProfileScreenBindingImpl =
            DataBindingUtil.setContentView(this, R.layout.profile_screen)
        bindingLayout.viewModel = profileViewModel
        bindingLayout.lifecycleOwner = this
    }
}