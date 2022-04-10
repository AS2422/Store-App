package com.asafin24.feature_explorer.domain.repository

import com.asafin24.feature_explorer.domain.model.home.PhonesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getExplorer() : Response<PhonesModel>

//    @GET("detail")
//    suspend fun getDetail() : Response<>

}