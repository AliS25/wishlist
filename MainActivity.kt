package com.example.simplewishlist

import android.R.attr.data
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    //a variable to store the list of items
    lateinit var items: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRv)
        // Initialize the list of items
        items = ArrayList()
        // Create adapter passing in the list of items
        val adapter = ItemAdapter(items)
        // Attach the adapter to the RecyclerView to populate items
        itemsRv.adapter = adapter
        // Set layout manager to position the items
        itemsRv.layoutManager = LinearLayoutManager(this)
//reference to the submit button
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
         //hide the keyboard
            hideKeyboard(this)


//reference to the input fields
            val itemName = findViewById<EditText>(R.id.nameInput)
            val itemPrice = findViewById<EditText>(R.id.priceInput)
            val itemURL = findViewById<EditText>(R.id.urlInput)
            //add a new Item to the list of items
            (items as MutableList<Item>).add(Item(itemName.text.toString(),itemPrice.text.toString(),itemURL.text.toString()))
            //notify the adapter of the addition
            adapter.notifyItemInserted(items.size-1)
//clear user input
            itemName.text=null
            itemPrice.text=null
            itemURL.text=null
        }
    }
    open fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager =
            activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
