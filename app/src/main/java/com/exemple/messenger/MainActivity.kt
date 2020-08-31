package com.exemple.messenger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.exemple.messenger.ui.fragments.ChatFragment
import com.exemple.messenger.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {

    private lateinit var mToolbar: Toolbar
    private lateinit var mAppDrawer: AppDrawer

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
        setSupportActionBar(mToolbar)
        mAppDrawer.create()
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.dataContainer,
                ChatFragment()
            ).commit()
    }


    private fun initFields() {
        mToolbar = findViewById(R.id.mainToolbar)
        mAppDrawer = AppDrawer(this, mToolbar)
    }
}
