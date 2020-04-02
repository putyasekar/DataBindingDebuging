package com.diki.idn.databindingdebuging

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableInt
import com.diki.idn.databindingdebuging.data.ProfileObservableField

class ObservableFieldProfileScreen : AppCompatActivity() {
    private val observableFieldProfile =
        ProfileObservableField("Putya", "Sekar Ayu", ObservableInt(0))

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}