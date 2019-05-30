package com.example.githubstars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {
    val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        val userData = intent.getStringExtra("UserData")
//        Log.i("********","$userData")
        val reposList = gson.fromJson<ArrayList<ReposData>>(userData)

        recyclerView.adapter = MyAdapter(reposList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
