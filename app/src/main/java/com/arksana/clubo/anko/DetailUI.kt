package com.arksana.clubo.anko

import android.graphics.Color
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.arksana.clubo.DetailAnkoActivity
import com.arksana.clubo.R
import org.jetbrains.anko.*


class DetailUI : AnkoComponent<DetailAnkoActivity> {

    lateinit var image: ImageView
    lateinit var judul: TextView
    lateinit var desc: TextView

    override fun createView(ui: AnkoContext<DetailAnkoActivity>) = with(ui) {
        scrollView {

            verticalLayout {
                id = LigaUI.layoutId
                lparams(wrapContent, wrapContent)
                padding = dip(16)

                image = imageView {
                    id = LigaUI.ivLogoId
                    layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                    setImageResource(R.drawable.english_premier_league_1)
                }
                judul = textView {
                    id = LigaUI.tvNameId
                    layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                    textSize = 16f // <- it is sp, no worries
                    textColor = Color.BLACK
                }

                desc = textView {
                    id = LigaUI.tvDescId
                    layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                    textSize = 14f
                    maxLines = 10
                }

            }
        }
    }
}