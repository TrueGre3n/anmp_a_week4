package com.ubaya.studentapp.view

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.ubaya.studentapp.R
import java.lang.Exception

@BindingAdapter("android:imageUrl")
fun loadPhotoURL(imageView: ImageView, url:String) {
    val picasso = Picasso.Builder(imageView.context)
    picasso.listener { picasso, uri, exception ->
        exception.printStackTrace()
    }
    picasso.build().load(url).into(imageView,object: Callback{
        override fun onSuccess() {
            var v = imageView.parent as View
            var pb = v.findViewById<ProgressBar>(R.id.progressBar)
            pb.visibility = View.INVISIBLE
            imageView.visibility = View.VISIBLE
        }

        override fun onError(e: Exception?) {
            Log.e("picasso",e?.message.toString())
        }
    })
    Log.d("bindingadapter","cek" + url)
    //imageView.visibility = View.VISIBLE
    //picasso.build().load(url).into(imageView)
}
