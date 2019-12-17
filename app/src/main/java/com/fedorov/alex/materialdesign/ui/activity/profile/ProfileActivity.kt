package com.fedorov.alex.materialdesign.ui.activity.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.fedorov.alex.materialdesign.App
import com.fedorov.alex.materialdesign.R
import com.fedorov.alex.materialdesign.presentation.presenter.ProfilePresenter
import com.fedorov.alex.materialdesign.presentation.view.ProfileView
import com.fedorov.alex.materialdesign.ui.activity.BottomActivity
import com.fedorov.alex.materialdesign.ui.activity.settings.SettingsActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.app_bar_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class ProfileActivity : MvpAppCompatActivity(), ProfileView {

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(
                context,
                ProfileActivity::class.java
            )
        }
    }

    @InjectPresenter
    internal lateinit var presenter: ProfilePresenter

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme((application as App).currentTheme)

        setContentView(R.layout.activity_profile)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_fruits, R.id.nav_vegetables, R.id.nav_nature
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.apply_theme_orange -> presenter.onClickApplyTheme(R.style.AppThemeOrange)
            R.id.apply_theme_purple -> presenter.onClickApplyTheme(R.style.AppTheme)
            R.id.show_progressBar -> presenter.onClickShowProgressBar()
            R.id.hide_progressBar -> presenter.onClickHideProgressBar()
            R.id.action_settings -> presenter.onClickOpenSettings()
            R.id.action_activity_bottom -> this.startActivity(BottomActivity.newInstance(this))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }

    override fun showProgressBar() {
        // Disable screen touchable.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
        progressbar_layout.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        // Enable screen touchable.
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        progressbar_layout.visibility = View.INVISIBLE
    }

    override fun openSettings() {
        this.startActivity(SettingsActivity.newInstance(this))
    }

    override fun applyTheme(id: Int) {
        (application as App).currentTheme = id
        recreate()
        // How to fix it?
        finish()
    }
}