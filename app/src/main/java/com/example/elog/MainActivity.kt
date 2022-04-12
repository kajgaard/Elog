package com.example.elog

//import androidx.navigation.ui.AppBarConfiguration.Builder.build
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.example.elog.R
import androidx.navigation.NavController
import com.example.elog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mAppBarConfiguration: AppBarConfiguration? = null
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setSupportActionBar(binding!!.appBarMain.toolbar)

        val drawer = binding!!.drawerLayout
        //mit
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN)
        drawer.setScrimColor(0x00000000)
        val navigationView = binding!!.navView
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = AppBarConfiguration.Builder(
                R.id.nav_oversigt, R.id.nav_afrejse, R.id.nav_fangst, R.id.nav_melding, R.id.nav_landing)
                .build()
        val navController = findNavController(this, R.id.nav_host_fragment_content_main)
        setupActionBarWithNavController(this, navController, mAppBarConfiguration!!)
        setupWithNavController(navigationView, navController)
    }
}