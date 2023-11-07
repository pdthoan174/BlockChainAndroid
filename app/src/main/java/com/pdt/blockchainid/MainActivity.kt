package com.pdt.blockchainid
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

import com.lutech.aiart.extentionFunction.startActivityExtension
import com.lutech.aiart.extentionFunction.toast
import com.pdt.blockchainid.R
import com.pdt.blockchainid.adapter.ViewPagerMainAdapter
import com.pdt.blockchainid.databinding.ActivityMainBinding
import com.pdt.blockchainid.utils.Constants


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mExitTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initData()
        onHandle()
//        startActivityExtension(ResultGenerateActivity::class.java,false)
    }

    override fun onResume() {
//        initView()
//        initData()
//        onHandle()
        super.onResume()
    }

    @SuppressLint("ResourceType")
    private fun initView() {
        window.statusBarColor = Color.parseColor(getString(R.color.back_ground))

        val viewPagerAdapter = ViewPagerMainAdapter(this)
        binding.viewPager2.adapter = viewPagerAdapter

        binding.viewPager2.isUserInputEnabled = false
    }

    private fun initData() {

    }

    private fun onHandle() {
        binding.bottomNavigation.selectedItemId = R.id.nav_avatars
        binding.viewPager2.currentItem = 0
        binding.bottomNavigation.setOnItemSelectedListener {
            Log.d(Constants.DEBUG_LOG, "nav_avatars")
            when (it.itemId){
                R.id.nav_avatars -> {
                    Log.d(Constants.DEBUG_LOG, "nav_avatars")
                    binding.viewPager2.currentItem = 0
                    binding.toolbarTitle.setText(R.string.txt_nav_add)
                }
                R.id.nav_generate -> {
                    Log.d(Constants.DEBUG_LOG, "nav_generate")
                    binding.viewPager2.currentItem = 1
                    binding.toolbarTitle.setText(R.string.txt_nav_my)
                }
                else -> {
                    Log.d(Constants.DEBUG_LOG, "nav_avatars")
                    binding.viewPager2.currentItem = 0
                    binding.toolbarTitle.setText(R.string.txt_nav_add)
                }
            }
            true
        }

        binding.btnSettings.setOnClickListener {
        }

        binding.btnPro.setOnClickListener {
        }
    }

    fun gotoGenerateScreen(){

        binding.bottomNavigation.selectedItemId = R.id.nav_generate
        binding.viewPager2.currentItem = 1
        binding.toolbarTitle.setText(R.string.txt_nav_add)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(binding.viewPager2.currentItem != 0){
            binding.bottomNavigation.selectedItemId = R.id.nav_avatars
        }else{
            val pressTime = System.nanoTime()
            if (pressTime - mExitTime < 2e9) {
                finishAffinity()
            } else {
                mExitTime = pressTime
            }
        }
    }

//    override fun sendData(prompt: String?, style: String?) {
//        val f = supportFragmentManager.fragments[1] as GenerateFragment
//        Log.d(Constants.DEBUG_LOG, "Main $prompt $style")
//        Log.d(Constants.DEBUG_LOG, "Main $f")
//        f.setDataFromInspiration(prompt, style)
//    }
}