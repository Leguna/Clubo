package com.arksana.clubo.anko

import androidx.recyclerview.widget.RecyclerView

import com.arksana.clubo.main.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainUI : AnkoComponent<MainActivity> {

    lateinit var rv : RecyclerView

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            rv = recyclerView {
                lparams(width = matchParent, height = matchParent)
            }
        }
    }
}