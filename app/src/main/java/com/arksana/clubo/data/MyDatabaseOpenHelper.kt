package com.arksana.clubo.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.arksana.clubo.data.Match.Companion.KEY_AWAY_TEAM
import com.arksana.clubo.data.Match.Companion.KEY_DATE
import com.arksana.clubo.data.Match.Companion.KEY_HOME_TEAM
import com.arksana.clubo.data.Match.Companion.KEY_ID
import com.arksana.clubo.data.Match.Companion.KEY_NAME
import com.arksana.clubo.data.Match.Companion.KEY_PHOTO_AWAY
import com.arksana.clubo.data.Match.Companion.KEY_PHOTO_HOME
import com.arksana.clubo.data.Match.Companion.KEY_ROUND
import com.arksana.clubo.data.Match.Companion.KEY_SCORE_AWAY
import com.arksana.clubo.data.Match.Companion.KEY_SCORE_HOME
import com.arksana.clubo.data.Match.Companion.KEY_TIME
import com.arksana.clubo.data.Match.Companion.MATCH_TABLE
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper private constructor(ctx: Context) :
    ManagedSQLiteOpenHelper(ctx, "db-clubo", null, 2) {
    init {
        instance = this
    }

    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context) = instance
            ?: MyDatabaseOpenHelper(ctx.applicationContext)
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(
            MATCH_TABLE, true,
            KEY_ID to INTEGER + PRIMARY_KEY + UNIQUE,
            KEY_NAME to TEXT,
            KEY_SCORE_HOME to TEXT,
            KEY_SCORE_AWAY to TEXT,
            KEY_PHOTO_HOME to TEXT,
            KEY_PHOTO_AWAY to TEXT,
            KEY_HOME_TEAM to TEXT,
            KEY_AWAY_TEAM to TEXT,
            KEY_DATE to TEXT,
            KEY_ROUND to TEXT,
            KEY_TIME to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(MATCH_TABLE, true)
    }
}

