package com.exemple.messenger.ui.fragments


import androidx.fragment.app.Fragment
import com.exemple.messenger.MainActivity
import com.exemple.messenger.R
import com.exemple.messenger.activities.RegisterActivity
import com.exemple.messenger.utilits.AUTH
import com.exemple.messenger.utilits.AppTextWatcher
import com.exemple.messenger.utilits.replaceActivity
import com.exemple.messenger.utilits.showToast
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment(val phoneNumber: String, val id: String) :
    Fragment(R.layout.fragment_enter_code) {


    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = phoneNumber
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                showToast("Добро пожаловать")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else showToast(task.exception?.message.toString())
        }
    }
}
