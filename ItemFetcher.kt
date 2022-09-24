package com.example.wishlist
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ItemFetcher {

    companion object {
        var name = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
var price=2.0
        var url = "some url"


        fun changeItems(n:String,p:Double,u:String) {
           price=p;
        }

        fun getItems(): MutableList<Item> {
            var items : MutableList<Item> = ArrayList()
            for (i in 0..9) {
                val item = Item(name[i], price, url)
                items.add(item)
            }
            return items
        }

        fun getNext5Items(): MutableList<Item> {
            var newItems : MutableList<Item> = ArrayList()
            for (i in 10..14) {
                val item = Item(name[i], price, url)
                newItems.add(item)
            }
            return newItems
        }
    }
}