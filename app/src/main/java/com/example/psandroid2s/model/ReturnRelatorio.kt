package com.example.psandroid2s.model

import com.beust.klaxon.*


data class ReturnRelatorio (
    val id: String,

    @Json(name = "co2_vol")
    val co2Vol: Double,

    @Json(name = "ph_vol")
    val phVol: Double,

    @Json(name = "medicao_date")
    val medicaoDate: String,

    val sensor: Sensor
)
