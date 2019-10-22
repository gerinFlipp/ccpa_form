package com.example.ccpaformkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.ccpaformkotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel: FormViewModel by lazy {
        ViewModelProviders.of(this).get(FormViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        binding.formViewModel = viewModel

        ccpa_submit_form_button.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "Submitted", Toast.LENGTH_SHORT).show()
        })

    }
}
