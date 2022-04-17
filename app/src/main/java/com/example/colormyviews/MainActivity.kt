package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setListeners(binding)
    }

    private fun setListeners(bindingInstance: ActivityMainBinding) {
        bindingInstance.apply {

            val viewsList: List<View> = listOf(
                boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, constraintLayout, redButton, greenButton, yellowButton
            )
            for (item in viewsList) {
                item.setOnClickListener { makeColoured(it,bindingInstance) }
            }
        }


    }

    private fun makeColoured(view: View, binding2: ActivityMainBinding) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.RED)
            R.id.box_two_text -> view.setBackgroundResource(android.R.color.holo_blue_light)
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_purple)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_orange_light)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.red_button -> binding2.boxThreeText.setBackgroundResource(R.color.red)
            R.id.green_button -> binding2.boxFiveText.setBackgroundResource(R.color.green)
            R.id.yellow_button -> binding2.boxFourText.setBackgroundResource(R.color.yellow)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}