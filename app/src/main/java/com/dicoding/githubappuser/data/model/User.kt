package com.dicoding.githubappuser.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @field:SerializedName("Login")
    val login: String,
    @field:SerializedName("Id")
    val id : Int,
    @field:SerializedName("Avatar_url")
    val avatar_url: String
)
