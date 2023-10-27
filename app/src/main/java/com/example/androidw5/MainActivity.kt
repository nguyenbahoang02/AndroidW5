package com.example.androidw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = arrayListOf<ItemModel>()
        for (i in 1..17) {
            val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            itemList.add(
                ItemModel(
                    chars[Random().nextInt(chars.length)] + "caythuehi3" + String.format("%03d", i) + "@gmail.com",
                    "Tài khoản bị khóa",
                    "Tài khoản của bạn bị khóa vì chúng tôi nghi ngờ bạn đang tham gia vào những hành động bất chính",
                    String.format(
                        "%02d:%02d %s",
                        Random().nextInt(12) + 1,
                        Random().nextInt(60),
                        if (Random().nextBoolean()) "AM" else "PM"
                    )
                )
            )
        }
        val adapter = ItemAdapter(itemList)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter
    }
}