package com.sa.padc_x_customviewcomponent_sa.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.sa.padc_x_customviewcomponent_sa.persistence.typeconverters.CommentListTypeConverter
import com.sa.padc_x_customviewcomponent_sa.persistence.typeconverters.LikeUsersTypeConverter

@Entity(tableName = "news")
@TypeConverters(LikeUsersTypeConverter::class, CommentListTypeConverter::class)
data class NewsVO(
    @PrimaryKey
    @SerializedName("id") var id: Int = 0,
    @SerializedName("title") var title: String = "",
    @SerializedName("hero_image") var heroImage: String = "",
    @SerializedName("description") var description: String = "",
    @Embedded
    @SerializedName("publication") var publication: PublicationVO? = null,
    @SerializedName("liked_users") var likedUsers: ArrayList<UserVO> = arrayListOf(),
    @SerializedName("comments") var comments: ArrayList<CommentVO> = arrayListOf()
)