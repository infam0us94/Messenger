package com.exemple.messenger.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.exemple.messenger.MainActivity
import com.exemple.messenger.R
import com.exemple.messenger.activities.RegisterActivity
import com.exemple.messenger.utilits.AUTH
import com.exemple.messenger.utilits.replaceActivity
import com.exemple.messenger.utilits.replaceFragment

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }
}
