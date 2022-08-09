package uz.gita.findwordappMBF.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import uz.gita.findwordappMBF.R
import uz.gita.findwordappMBF.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(binding.root)

        navController =
            (supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment).findNavController()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}