package com.arksana.clubo.main

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.arksana.clubo.R
import com.arksana.clubo.main.mainactivity.MyPagerAdapter
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = MyPagerAdapter(supportFragmentManager)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val tabs = findViewById<TabLayout>(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        viewPager.offscreenPageLimit = 3
        viewPager.adapter = pagerAdapter
    }

    override fun onBackPressed() {
        val builder =
            AlertDialog.Builder(this, R.style.AlertDialogStyle)
        builder.setMessage(getString(R.string.dialogexit))
            .setPositiveButton(
                getString(R.string.Yes)
            ) { _: DialogInterface?, _: Int -> finishAffinity() }
            .setNegativeButton(
                getString(R.string.No)
            ) { dialog: DialogInterface, _: Int -> dialog.cancel() }
        val alertDialog = builder.create()
        alertDialog.show()
    }

}
