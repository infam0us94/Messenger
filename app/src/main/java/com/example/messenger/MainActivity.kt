package com.example.messenger

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.messenger.database.AUTH
import com.example.messenger.database.initFirebase
import com.example.messenger.database.initUser
import com.example.messenger.ui.fragments.MainFragment
import com.example.messenger.ui.fragments.register.EnterPhoneNumberFragment
import com.example.messenger.ui.objects.AppDrawer
import com.example.messenger.utilits.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var mToolbar: Toolbar
    lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        APP_ACTIVITY = this
        initFirebase()
//        initUser()
//        initFields()
//        initFunc()
        initUser() {
            initFields()
            initFunc()
            CoroutineScope(Dispatchers.IO).launch {
                initContacts()
            }
        }
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        if (AUTH.currentUser != null) {
            mAppDrawer.create()
            replaceFragment(MainFragment(), false)
        } else {
            replaceFragment(EnterPhoneNumberFragment(), false)
        }
    }

    private fun initFields() {
        mToolbar = findViewById(R.id.main_toolbar)
        mAppDrawer = AppDrawer()
    }

//    private fun initUser() {
//        REF_DATABASE_ROOT.child(NODE_USERS).child(CURRENT_UID)
//            .addListenerForSingleValueEvent(AppValueEventListener {
//                USER = it.getValue(User::class.java) ?: User()
//                if (USER.username.isEmpty()) {
//                    USER.username = CURRENT_UID
//                }
//            })
//    }

    override fun onStart() {
        super.onStart()
        AppStates.updateState(AppStates.ONLINE)
    }

    override fun onStop() {
        super.onStop()
        AppStates.updateState(AppStates.OFFLINE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (ContextCompat.checkSelfPermission(
                APP_ACTIVITY,
                READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            initContacts()
        }
    }
}
