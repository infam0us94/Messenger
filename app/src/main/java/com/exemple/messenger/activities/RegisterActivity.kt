package com.exemple.messenger.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.exemple.messenger.R
import com.exemple.messenger.ui.fragments.EnterPhoneNumberFragment
import com.exemple.messenger.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun onStart() {
        super.onStart()
        mToolbar = findViewById(R.id.registerToolbar)
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_your_phone)
        replaceFragment(EnterPhoneNumberFragment())
    }
}
