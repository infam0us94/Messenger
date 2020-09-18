package com.example.messenger.ui.fragments


import androidx.fragment.app.Fragment
import com.example.messenger.utilits.APP_ACTIVITY

open class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
    }
}
