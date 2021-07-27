package com.garyjmj.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.garyjmj.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        // For getPost()
//        viewModel.getPost()
//        viewModel.myResponse.observe(this, Observer { response ->
//
//            if (response.isSuccessful){
//                Log.d("Response", response.body()?.userId.toString())
//                Log.d("Response", response.body()?.id.toString())
//                textView.text = response.body()?.title!!
//                Log.d("Response", response.body()?.body!!)
//            }else{
//                Log.d("Response", response.errorBody().toString())
//                textView.text = response.code().toString()
//            }
//
//        })

        // getPost2()
//        button.setOnClickListener {
//            val myNumber = editTextNumber.text.toString()
//            viewModel.getPost2(Integer.parseInt(myNumber))
//            viewModel.myResponse2.observe(this, Observer { response ->
//                if (response.isSuccessful){
//                    textView.text = response.body().toString()
//                }else{
//                    textView.text = response.code().toString()
//                }
//            })
//        }

        // getCustomPosts() and add (sort & desc)
//        button.setOnClickListener {
//            val myNumber = editTextNumber.text.toString()
//            viewModel.getCustomPosts(Integer.parseInt(myNumber), "id", "desc")
//            viewModel.myCustomPosts.observe(this, Observer { response ->
//                if (response.isSuccessful){
//                    textView.text = response.body().toString()
//                    response.body()?.forEach {
//                        Log.d("Response", it.userId.toString())
//                        Log.d("Response", it.id.toString())
//                        Log.d("Response", it.title)
//                        Log.d("Response", it.body)
//                        Log.d("Response", "---------")
//                    }
//                }else{
//                    textView.text = response.code().toString()
//                }
//            })
//        }

        // getCustomPosts2()
        val options: HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"

        button.setOnClickListener {
            val myNumber = editTextNumber.text.toString()
            viewModel.getCustomPosts2(Integer.parseInt(myNumber), options)
            viewModel.myCustomPosts2.observe(this, Observer { response ->
                if (response.isSuccessful){
                    textView.text = response.body().toString()
                    response.body()?.forEach {
                        Log.d("Response", it.userId.toString())
                        Log.d("Response", it.id.toString())
                        Log.d("Response", it.title)
                        Log.d("Response", it.body)
                        Log.d("Response", "---------")
                    }
                }else{
                    textView.text = response.code().toString()
                }
            })
        }
    }
}