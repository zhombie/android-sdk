package kz.zhombie.json

import org.json.JSONObject

fun jsonObject(lambda: JSONObject.() -> Unit): JSONObject {
    val jsonObject = JSONObject()
    try {
        jsonObject.apply(lambda)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return jsonObject
}
