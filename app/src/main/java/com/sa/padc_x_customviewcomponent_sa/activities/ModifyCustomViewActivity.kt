package com.sa.padc_x_customviewcomponent_sa.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sa.padc_x_customviewcomponent_sa.R

class ModifyCustomViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_custom_view)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ModifyCustomViewActivity::class.java)
        }
    }
}