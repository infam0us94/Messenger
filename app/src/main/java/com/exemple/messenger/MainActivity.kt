package com.exemple.messenger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.exemple.messenger.activities.RegisterActivity
import com.exemple.messenger.ui.fragments.ChatFragment
import com.exemple.messenger.ui.objects.AppDrawer
import com.exemple.messenger.utilits.AUTH
import com.exemple.messenger.utilits.initFirebase
import com.exemple.messenger.utilits.replaceActivity
import com.exemple.messenger.utilits.replaceFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mToolbar: Toolbar
    lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if (AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatFragment(),false)
        } else {
            replaceActivity(RegisterActivity())
        }
    }


    private fun initFields() {
        mToolbar = findViewById(R.id.mainToolbar)
        mAppDrawer = AppDrawer(this, mToolbar)
        AUTH = FirebaseAuth.getInstance()
        initFirebase()
    }
}
