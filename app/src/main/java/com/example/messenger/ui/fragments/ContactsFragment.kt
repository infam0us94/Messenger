package com.example.messenger.ui.fragments


import androidx.fragment.app.Fragment
import com.example.messenger.R
import com.example.messenger.utilits.APP_ACTIVITY


class ContactsFragment : Fragment(R.layout.fragment_contacts) {
    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Контакты"
    }
}