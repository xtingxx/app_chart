package com.example.app_chart_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightChart()
        calorieChart()
    }

    fun weightChart() {
        val wc = findViewById<LineChart>(R.id.lineChart_weight)

        wc.setDrawBorders(false) //邊框
        val weights = ArrayList<Entry>() //折線圖的資料
        weights.add(Entry(1f, 20f)) //增加資料
        weights.add(Entry(2f, 40f))
        weights.add(Entry(3f, 30f))
        weights.add(Entry(4f, 60f))
        weights.add(Entry(5f, 50f))

        val lineDataSet = LineDataSet(weights, "體重 / kg")
        lineDataSet.setColor(Color.parseColor("#FFBB86FC")) //折線圖線的顏色

        val data = LineData(lineDataSet) //資料傳給 LineData
        wc.setData(data)
    }

    fun calorieChart() {

    }
}