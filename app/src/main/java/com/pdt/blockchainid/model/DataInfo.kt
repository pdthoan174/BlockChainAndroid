package com.pdt.blockchainid.model

data class DataInfo(
    val data: List<Data>,
    val errorCode: Int,
    val errorMessage: String
)