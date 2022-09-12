package com.ugurd.cargoapp

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class upsKargo (
    var takipNo: String? = "",
    var urunNo:String? = "",
    var hareketNo:String? = "",
    var islemTarihi:String? = "",
    var hareketYeri:String? = "",
    var islem:String? = "",
    var user:String?){
}