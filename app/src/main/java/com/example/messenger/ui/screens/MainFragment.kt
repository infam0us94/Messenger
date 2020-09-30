package com.example.messenger.ui.screens

import androidx.fragment.app.Fragment
import com.example.messenger.R
import com.example.messenger.utilits.APP_ACTIVITY
import com.example.messenger.utilits.hideKeyboard

/* Главный фрагмент, содержит все чаты, группы и каналы с которыми взаимодействует пользователь*/

class MainFragment : Fragment(R.layout.fragment_chat) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Messanger"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
    }
}
