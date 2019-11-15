package com.arksana.clubo

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.dip
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.imageView
import java.util.*


class SplashActivity : AppCompatActivity() {

    internal lateinit var timer: Timer
    private val waktu = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var logo: ImageView

        frameLayout {
            imageView {
                scaleX = 1.2f
                scaleY = 1.2f
                setImageResource(R.drawable.splash_bg)
            }
            logo = imageView {
                setImageResource(R.drawable.splash_front)
            }.lparams(height = dip(450)) {
                gravity = Gravity.BOTTOM
            }
        }

        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
        }, waktu.toLong())

        val animation1 = AlphaAnimation(0.2f, 1.0f)
        animation1.duration = 2000
        animation1.fillAfter = true
        logo.startAnimation(animation1)
    }

}
