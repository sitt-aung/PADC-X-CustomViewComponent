package com.sa.padc_x_customviewcomponent_sa.data.vos

import com.google.gson.annotations.SerializedName

data class UserVO(
    @SerializedName("id") var id : Int = 0,
    @SerializedName("user_name") var userName : String = "",
    @SerializedName("email") var email: String = ""
)