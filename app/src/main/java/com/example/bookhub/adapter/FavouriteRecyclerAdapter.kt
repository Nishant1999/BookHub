package com.example.bookhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhub.R
import com.example.bookhub.database.BookEntity
import com.squareup.picasso.Picasso

class FavouriteRecyclerAdapter(val context:Context,val bookList:List<BookEntity>):RecyclerView.Adapter<FavouriteRecyclerAdapter.FavouriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_favourite_single_row,parent,false)
        return FavouriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {

        val book=bookList[position]
        holder.txtFavBookName.text=book.bookName
        holder.txtFavBookAuthor.text=book.bookAuthor
        holder.txtFavBookPrice.text=book.bookPrice
        holder.txtFavBookRating.text=book.bookRating
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
    class FavouriteViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val txtFavBookName: TextView =view.findViewById(R.id.txtFavBookName)
        val txtFavBookAuthor: TextView =view.findViewById(R.id.txtFavBookAuthor)
        val txtFavBookPrice: TextView =view.findViewById(R.id.txtFavBookPrice)
        val txtFavBookRating: TextView =view.findViewById(R.id.txtFavBookRating)
        val imgBookImage: ImageView =view.findViewById(R.id.imgFavBook)
        val relativeContent:RelativeLayout=view.findViewById(R.id.relativeContent)

    }
}