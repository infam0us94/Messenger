package com.example.messenger.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.messenger.R
import com.example.messenger.ui.fragments.EnterPhoneNumberFragment
import com.example.messenger.utilits.initFirebase
import com.example.messenger.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        mToolbar = findViewById(R.id.register_toolbar)
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_your_phone)
        replaceFragment(EnterPhoneNumberFragment(),false)
    }
}
