package com.fedorov.alex.materialdesign.ui.activity

import android.app.Activity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.fedorov.alex.materialdesign.R
import com.fedorov.alex.materialdesign.presentation.presenter.LoginPresenter
import com.fedorov.alex.materialdesign.presentation.view.LoginView
import com.fedorov.alex.materialdesign.ui.activity.profile.ProfileActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class LoginActivity : MvpAppCompatActivity(), LoginView {

    @InjectPresenter
    internal lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            hideSoftKeyboard()
            presenter.checkLogin(txtLogin.text.toString())
        }

        btnFinish.setOnClickListener{
            presenter.closeApp()
        }
    }

    override fun onLoginSuccess() {
        this.startActivity(ProfileActivity.newInstance(this))
    }

    override fun onLoginFail() {
        Snackbar.make(findViewById(android.R.id.content), "Please fill login", Snackbar.LENGTH_LONG)
            .show()
    }

    override fun closeApp() {
        finish()
    }

    private fun hideSoftKeyboard() {
        if (currentFocus == null) return
        val inputMethodManager = getSystemService(
            Activity.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            currentFocus!!.windowToken,
            0
        )
    }
}