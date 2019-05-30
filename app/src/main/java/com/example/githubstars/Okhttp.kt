package com.example.githubstars

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)
class Okhttp {
    private val client = OkHttpClient()
    var getJsonUser: ((callBack: ArrayList<ReposData>) -> Unit)? = null
    fun getUserRepo(name: String) {
        val request = Request.Builder()
            .url("https://api.github.com/users/$name/repos")
            .build()
        val call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("Fail", e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val callBack = JsonData().getJson(response)
                getJsonUser?.invoke(callBack)
            }
        })
    }
}

