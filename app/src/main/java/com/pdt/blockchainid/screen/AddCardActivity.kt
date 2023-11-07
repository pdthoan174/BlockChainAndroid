package com.pdt.blockchainid.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.pdt.blockchainid.R
import com.pdt.blockchainid.api.RetrofitClient
import com.pdt.blockchainid.api.RetrofitServer
import com.pdt.blockchainid.databinding.ActivityAddCardBinding
import com.pdt.blockchainid.model.ReponseSuccess
import com.pdt.blockchainid.model.RequestAddInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCardBinding.inflate(layoutInflater)

        setContentView(binding.root)

        onHandle()
    }

    private fun onHandle() {
        binding.btnAddImage.setOnClickListener {

            Glide.with(this)
                .load(R.drawable.cccd_img)
                .into(binding.ivIdCard)
        }

        binding.btnScan.setOnClickListener {
            binding.tvBtnApply.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            val id = binding.tvIdCard.text.toString()
            val name = binding.tvName.text.toString()
            val sex = binding.tvSex.text.toString()
            val address = binding.tvAddress.text.toString()

            if (id.isNotEmpty() && name.isNotEmpty() && sex.isNotEmpty() && address.isNotEmpty()) {
                sendRequestAdd(id.toLong(), name, sex, address)
            } else {
                Toast.makeText(applicationContext, "Field Empty", Toast.LENGTH_SHORT).show()

            }
        }
    }


    private fun sendRequestAdd(id: Long, name: String, sex:String, add: String) {
        val request = RequestAddInfo()
        request.id = id
        request.name = name
        request.sex = sex
        request.add = add

        RetrofitServer.instance.addInfo(request)
            .enqueue(object: Callback<ReponseSuccess> {
                override fun onResponse(
                    call: Call<ReponseSuccess>,
                    response: Response<ReponseSuccess>
                ) {
                    // description: trong RegisterResponse.kt
                    val postResult = response.body()
                    if (postResult != null){
                        Log.i("hihi", postResult.toString())
                        val state = postResult.success
                        binding.tvBtnApply.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Add Info Successfully", Toast.LENGTH_SHORT).show()


                    }else{
                        //Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<ReponseSuccess>, t: Throwable) {
                    Toast.makeText(applicationContext, "Call API Fail", Toast.LENGTH_SHORT).show()
                }
            })
    }

}