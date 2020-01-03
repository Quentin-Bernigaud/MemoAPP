package com.android.example.recyclerview

import com.squareup.moshi.Json

data class TokenResponse(
    @field:Json(name = "token")
    val token: String
)