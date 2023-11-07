package com.pdt.blockchainid.api

import com.pdt.blockchainid.model.ListInfo
import com.pdt.blockchainid.model.ReponseSuccess
import com.pdt.blockchainid.model.RequestAddInfo
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @POST("products")
    fun addInfo(
        @Body info: RequestAddInfo
    ):Call<ReponseSuccess>
//
    @GET("products")
    fun getListInfo():Call<ListInfo>
////    @GET("v1/24a5ace7-6d47-45d1-abcb-68f06d8662ff")
////    // them token vao header
////    fun getListCategoryWallpaper():Call<CategoryWallpaperResponse>
//
//    @GET("search/photos")
//    fun getListWallpaper(@Query("page") page: Int,
//                         @Query("query") query: String,
//                         @Query("orientation") orientation: String,
//                         @Query("per_page") per_page:Int,
//                         @Query("license") license:String
//    ): Call<WallpaperResponse>
}