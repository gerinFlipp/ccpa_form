package com.example.ccpaformkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.ccpaformkotlin.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mBuilder : AlertDialog.Builder
    lateinit var binding: ActivityMainBinding
    val viewModel: FormViewModel by lazy {
        ViewModelProviders.of(this).get(FormViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        binding.formViewModel = viewModel

        mBuilder = AlertDialog.Builder(this)

        ccpa_submit_form_button.setOnClickListener{
            val materialBuilder = MaterialAlertDialogBuilder(this)
//            val builder = AlertDialog.Builder(this)
            materialBuilder.setTitle("Request deletion of your Flipp data?")
                .setMessage("This will delete all your data from our platform.")
                .setCancelable(true)
                .setPositiveButton("Request Deletion") { _, _ ->
                    Toast.makeText(applicationContext, "Request Sent", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { _, _ -> }
            val alertDialog : AlertDialog = materialBuilder.create()
            alertDialog.show()
        }

    }
}
