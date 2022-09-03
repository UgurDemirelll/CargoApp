package com.ugurd.cargoapp

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class pttKargo(
    var takipNo: String = "",
    var urunNo:Int? = 0,
    var hareketNo:Int? = 0,
    var islemTarihi:String? = "",
    var hareketYeri:String? = "",
    var islem:String? = "",
    var user:String?){
}