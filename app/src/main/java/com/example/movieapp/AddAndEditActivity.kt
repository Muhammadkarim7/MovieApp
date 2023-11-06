package com.example.movieapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.Cache.Cache
import com.example.movieapp.Models.User
import com.example.movieapp.databinding.ActivityAddAndEdit2Binding

class AddAndEditActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddAndEdit2Binding.inflate(layoutInflater) }
    var position = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Cache.init(this)

        position = intent.getIntExtra("position", -1)

        if (position!=-1){
            edt()
        }else{
            save()
        }

    }

    fun save(){
        binding.btnSave.setOnClickListener {
            val user = User(binding.edtName.text.toString(), binding.edtAbout.text.toString(), binding.edtDate.text.toString(), binding.edtProduser.text.toString())
            val list = Cache.obektString
            list.add(user)
            Cache.obektString = list
            Toast.makeText(this, "Saqlandi", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    fun edt(){
        val list = Cache.obektString
        binding.apply {
            edtName.setText(list[position].name)
            edtAbout.setText(list[position].about)
            edtDate.setText(list[position].date)
            edtProduser.setText(list[position].produser)

            btnSave.setOnClickListener {
                val user = User(edtName.text.toString(), edtAbout.text.toString(), edtDate.text.toString(), edtProduser.text.toString())
                list[position]=user
                Cache.obektString = list
                Toast.makeText(this@AddAndEditActivity, "Taxrirlandi", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}