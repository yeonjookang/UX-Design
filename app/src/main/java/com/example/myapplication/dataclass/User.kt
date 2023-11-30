package com.example.myapplication.dataclass

data class User(
    var nickname: String,
    var email: String,
    var uId: String
){
    constructor(): this("", "", "")
}
