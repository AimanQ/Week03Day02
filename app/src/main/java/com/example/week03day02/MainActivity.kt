package com.example.week03day02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    var editText:EditText?= null
    var listView:ListView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
        prepareListView()

        Log.i("My Name","Ahmad")


    }

    private fun connectViews(){
        listView = findViewById(R.id.lv)
        editText = findViewById(R.id.etFilter)
    }
    private fun prepareListView(){
        val arrayList = ArrayList<String>()
        arrayList.add("Orange")
        arrayList.add("Apple")
        arrayList.add("banana")
        arrayList.add("cherry")
        arrayList.add("cherry")
        arrayList.add("cherry")
        arrayList.add("cherry")
        arrayList.add("cherry")
        arrayList.add("cherry")
        arrayList.add("cherry")

        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,
            arrayList)

        listView?.adapter = arrayAdapter

        listView?.setOnItemClickListener { parent, view, position, id ->
            arrayList.removeAt(position)
            //arrayAdapter.notifyDataSetChanged()
        }

        editText?.addTextChangedListener {
            arrayAdapter.filter.filter(it)
        }
    }
}