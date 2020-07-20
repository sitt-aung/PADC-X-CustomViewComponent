package com.sa.padc_x_customviewcomponent_sa.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sa.padc_x_customviewcomponent_sa.R
import com.sa.padc_x_customviewcomponent_sa.views.components.EmotionalFaceView
import kotlinx.android.synthetic.main.activity_custom_component.*

class CustomComponentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_component)

        happyButton.setOnClickListener {
            emotionalFaceView.happinessState = EmotionalFaceView.HAPPY
        }

        sadButton.setOnClickListener {
            emotionalFaceView.happinessState = EmotionalFaceView.SAD
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CustomComponentActivity::class.java)
        }
    }
}