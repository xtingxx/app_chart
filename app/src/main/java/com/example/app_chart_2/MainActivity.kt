package com.example.app_chart_2

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

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
        weights.add(Entry(0f, 55f)) //增加資料
        weights.add(Entry(1f, 54f))
        weights.add(Entry(2f, 56f))
        weights.add(Entry(3f, 53f))
        weights.add(Entry(4f, 52f))
        weights.add(Entry(5f, 54f))

        val lineDataSet = LineDataSet(weights, "體重(kg)")
        lineDataSet.setColor(resources.getColor(R.color.Lavender)) //折線圖線的顏色
        lineDataSet.setCircleColor(resources.getColor(R.color.Lavender)) //圓點的顏色
        lineDataSet.setDrawCircleHole(true) //圓點為實心空心(實心-false，空心-true)
        lineDataSet.setDrawValues(true) //顯示座標點對應 Y軸的數字(預設顯示)
        lineDataSet.valueTextColor = ContextCompat.getColor(this, R.color.TextColor)
        wc.legend.isEnabled = true //顯示圖例(預設顯示)
        wc.description.isEnabled = false //不顯示 Description Label (預設顯示)

        val xAxis = wc.xAxis
                xAxis.position = XAxis.XAxisPosition.BOTTOM //X軸標籤顯示位置(預設顯示在上方，分為上方內/外側、下方內/外側及上下同時顯示)
        xAxis.textColor = R.color.TextColor //X軸標籤顏色
        xAxis.textSize = 11f
        xAxis.labelCount = weights.size
        xAxis.spaceMin = 0.5f //折線起點距離左側Y軸距離
        xAxis.spaceMax = 0.5f //折線終點距離右側Y軸距離
        xAxis.setDrawGridLines(false) //不顯示每個座標點對應X軸的線(預設顯示)
        //xAxis.valueFormatter = IndexAxisValueFormatter(weights)  ???????????????????????

        val yAxisRight = wc.axisRight
        yAxisRight.setEnabled(false)

        val yAxisLeft = wc.axisLeft
        yAxisLeft.setGranularity(1f)

        //設定資料
        val data = LineData(lineDataSet)
        wc.setData(data)
        wc.animateX(2500)
        //刷新資料
        wc.invalidate()
    }

    fun calorieChart() {
        val lineChart_calorie = findViewById<LineChart>(R.id.lineChart_calorie)

        lineChart_calorie.setDrawBorders(false) //邊框

        val calories = ArrayList<Entry>() //卡路里資料
        calories.add(Entry(0f, 3500f)) //增加資料
        calories.add(Entry(1f, 3700f))
        calories.add(Entry(2f, 3600f))
        calories.add(Entry(3f, 3430f))
        calories.add(Entry(4f, 3590f))
        calories.add(Entry(5f, 3260f))
        calories.add(Entry(6f, 3300f))
        calories.add(Entry(7f, 3880f))
        calories.add(Entry(8f, 3100f))
        calories.add(Entry(9f, 3500f))
        calories.add(Entry(10f, 3700f))

        val lineDataSet = LineDataSet(calories, "卡路里(大卡)")
        lineDataSet.setColor(resources.getColor(R.color.Lavender)) //線的顏色
        lineDataSet.setCircleColor(resources.getColor(R.color.Lavender)) //點的顏色
        lineDataSet.setDrawCircleHole(true) //空心圓點
        lineDataSet.setDrawValues(false) //不顯示座標點 Y值
        lineChart_calorie.legend.isEnabled = true //顯示圖例
        lineChart_calorie.description.isEnabled = false

        val data = LineData(lineDataSet)
        lineChart_calorie.setData(data)
    }
}