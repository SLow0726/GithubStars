package com.example.githubstars

import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject


class JsonData {
    fun getJson(response: Response):ArrayList<ReposData> {
        val resStr = response.body()!!.string()
        val itemList = JSONArray(resStr)
        val reposDataList = arrayListOf<ReposData>()
        for (i in 0 until itemList.length()) {
            val item = itemList[i] as JSONObject
            val reposData = ReposData(
                "${item.get("name")}",
                "${item.get("language")}",
                "${item.get("stargazers_count")}",
                "${item.get("watchers_count")}"

            )
            reposDataList.add(reposData)
        }
        return reposDataList
    }
}