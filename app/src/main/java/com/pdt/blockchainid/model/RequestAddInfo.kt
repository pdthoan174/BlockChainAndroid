package com.pdt.blockchainid.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestAddInfo {
    @SerializedName("id")
    @Expose
    var id: Long? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("sex")
    @Expose
    var sex: String? = null

    @SerializedName("add")
    @Expose
    var add: String? = null
}