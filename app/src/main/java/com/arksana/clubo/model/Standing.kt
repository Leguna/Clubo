package com.arksana.clubo.model


import com.google.gson.annotations.SerializedName

data class Standing(
    @SerializedName("table")
    val table: List<Table?>? = null
)

data class Table(
    @SerializedName("name")
    val name: String? = null, // New York Knicks
    @SerializedName("teamid")
    val teamid: String? = null, // 134862
    @SerializedName("played")
    val played: Int? = null, // 82
    @SerializedName("goalsfor")
    val goalsfor: Int? = null, // 8575
    @SerializedName("goalsagainst")
    val goalsagainst: Int? = null, // 9330
    @SerializedName("goalsdifference")
    val goalsdifference: Int? = null, // -755
    @SerializedName("win")
    val win: Int? = null, // 17
    @SerializedName("draw")
    val draw: Int? = null, // 0
    @SerializedName("loss")
    val loss: Int? = null, // 65
    @SerializedName("total")
    val total: Int? = null // 51
)