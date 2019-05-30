package com.example.githubstars

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val okhttp = Okhttp()
    val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener {
            val name = et_search.text.toString()
//            val name = "SLow0726"
            okhttp.getUserRepo(name)
            getObject()
        }
    }


    fun getObject() {
        okhttp.getJsonUser = {
            intent(it)
        }
    }

    fun intent(userObject: ArrayList<ReposData>) {
        val intent = Intent(this, ShowActivity::class.java)
        val obj = gson.toJson(userObject)
        intent.putExtra("UserData", obj)
        startActivity(intent)

    }


}
