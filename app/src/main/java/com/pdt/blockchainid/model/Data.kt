package com.pdt.blockchainid.model

data class Data(
    val address: String,
    val address_entities: AddressEntities,
    val address_prob: String,
    val dob: String,
    val dob_prob: String,
    val doe: String,
    val doe_prob: String,
    val home: String,
    val home_prob: String,
    val id: String,
    val id_prob: String,
    val name: String,
    val name_prob: String,
    val nationality: String,
    val nationality_prob: String,
    val overall_score: String,
    val sex: String,
    val sex_prob: String,
    val type: String,
    val type_new: String
)