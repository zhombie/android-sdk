package kz.garage.json

import org.json.JSONArray

inline fun <reified T> JSONArray?.toMutableList(): MutableList<T> {
    if (this == null) return mutableListOf()

    val list = mutableListOf<T>()
    for (i in 0 until length()) {
        val item = this[i]
        if (item is T) {
            list.add(item)
        }
    }
    return list
}