package com.example.myapplication.dataclass

data class Message(
    var message: String?,
    var sendId: String?
){
    constructor(): this("", "")
}
