package com.arksana.clubo.anko

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginLeft
import com.arksana.clubo.R
import org.jetbrains.anko.*

class LigaUI : AnkoComponent<ViewGroup> {

    companion object {
        val ivLogoId = 1
        val tvNameId = 2
        val tvDescId = 3
        val layoutId = 4
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        linearLayout {
            id = layoutId
            lparams(wrapContent, wrapContent)
            padding = dip(16)

            imageView{
                id = ivLogoId
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                setImageResource(R.drawable.english_premier_league_1)
            }
            verticalLayout {
                leftPadding = dip(8)
                textView {
                    id = tvNameId
                    layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                    text = "English Premier League"
                    textSize = 16f // <- it is sp, no worries
                    textColor = Color.BLACK
                }

                textView {
                    id = tvDescId
                    layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                    text ="The Premier League (often referred to as the English Premier League (EPL) outside England), is the top level of the English football league system. Contested by 20 clubs, it operates on a system of promotion and relegation with the English Football League (EFL)."
                    textSize = 14f
                    maxLines = 4
                }
            }
        }
    }
}
