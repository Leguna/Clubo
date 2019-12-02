package com.arksana.clubo.utils

import org.jetbrains.anko.db.RowParser

class MyRowParser : RowParser<Triple<Int, String, String>> {
    override fun parseRow(columns: Array<Any?>): Triple<Int, String, String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}