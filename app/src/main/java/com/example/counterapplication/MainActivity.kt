package com.example.counterapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var b: Boolean = true
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun start(view : View){
        b=true
        var t = findViewById<View>(R.id.txtCounter) as TextView

        Thread(Runnable {
            while (b){
                count++
                runOnUiThread {
                    t.setText(count.toString())
                }
                Thread.sleep(100)
            }
        }).start()
    }
    fun stop(view : View){
        b=false
    }
    fun restart(view : View){
        b=true
        count=1
    }
}