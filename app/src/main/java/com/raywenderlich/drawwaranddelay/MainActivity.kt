package com.raywenderlich.drawwaranddelay

import android.os.Bundle
import android.os.Looper
import android.view.Gravity
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.drawwaranddelay.databinding.ActivityMainBinding
import com.raywenderlich.drawwaranddelay.ui.DrawerAdapter
import com.raywenderlich.drawwaranddelay.ui.ImgClick
import com.raywenderlich.drawwaranddelay.ui.LooperViewModel
import com.raywenderlich.drawwaranddelay.ui.gallery.GalleryFragment
import com.raywenderlich.drawwaranddelay.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: DrawerAdapter

    private val viewModel: LooperViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindRec()
        viewModel.repatedTask()

        setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)






    }


    private fun bindRec(){

        adapter = DrawerAdapter(makeItems())
        binding.navRecycler.layoutManager = LinearLayoutManager(this)
        binding.navRecycler.adapter = adapter
        adapter.imgClick = {
            Toast.makeText(this, "not yet", Toast.LENGTH_SHORT).show()
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
    }



    private fun makeItems():List<NavData>{
        return listOf(NavData(R.mipmap.beaver,"Beaver"),
            NavData(R.mipmap.bee,"Bee"),
            NavData(R.mipmap.bird,"Bird"),
            NavData(R.mipmap.butterfly,"ButterFly"),
            NavData(R.mipmap.cat,"Cat"),
            NavData(R.mipmap.cow,"Cow"),
            NavData(R.mipmap.crab,"Crab"),
            NavData(R.mipmap.elephant,"Elephant"),
            NavData(R.mipmap.frog,"Frog"),
            NavData(R.mipmap.giraffe,"Giraffe"),
            NavData(R.mipmap.hen,"Hen")
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }




}