package com.pdt.blockchainid.model

class ListInfo : ArrayList<ListInfoItem>()

data class ListInfoItem(
    val add: String,
    val id: Long,
    val name: String,
    val sex: String
)