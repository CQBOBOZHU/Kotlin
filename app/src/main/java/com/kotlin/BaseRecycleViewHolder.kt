package com.kotlin

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView

import java.util.LinkedHashSet

/**
 * Created by Administrator on 2016/12/1.
 */

open class BaseRecycleViewHolder @JvmOverloads constructor(itemView: View, isItem: Boolean = true) : RecyclerView.ViewHolder(itemView) {
    internal var views = SparseArray<View>()
    private val childClickViewIds = LinkedHashSet<Int>()

    fun <T : View> getView(id: Int): T {
        var view: View? = views.get(id)
        if (view == null) {
            view = itemView.findViewById(id)
            views.put(id, view)
        }
        return (view as T?)!!
    }

    fun getText(id: Int, charS: CharSequence): BaseRecycleViewHolder {
        val textView = getView<TextView>(id)
        textView.text = charS
        return this
    }


    fun setText(id: Int, text: CharSequence): BaseRecycleViewHolder {
        val textView = getView<TextView>(id)
        textView.text = text
        return this
    }

    fun setTextColor(id: Int, textcolor: Int): BaseRecycleViewHolder {
        val view = getView<TextView>(id)
        view.setTextColor(textcolor)
        return this
    }

    fun setImage(id: Int, bitmap: Bitmap): BaseRecycleViewHolder {
        val imageView = getView<ImageView>(id)
        imageView.setImageBitmap(bitmap)
        return this
    }

    fun setImageDrawable(id: Int, drawable: Drawable): BaseRecycleViewHolder {
        val imageView = getView<ImageView>(id)
        imageView.setImageDrawable(drawable)
        return this
    }


    fun setImageResource(id: Int, resId: Int): BaseRecycleViewHolder {
        val imageView = getView<ImageView>(id)
        imageView.setImageResource(resId)
        return this
    }

    fun setOnClickListener(id: Int, listener: View.OnClickListener): BaseRecycleViewHolder {
        val view = getView<View>(id)
        view.setOnClickListener(listener)
        return this
    }

    fun setOnClickListener(listener: View.OnClickListener, vararg ids: Int): BaseRecycleViewHolder {
        for (id in ids) {
            val view = getView<View>(id)
            view.setOnClickListener(listener)
        }
        return this
    }


    fun addOnClickListener(id: Int): BaseRecycleViewHolder {
        childClickViewIds.add(id)
        return this
    }

    fun setTag(id: Int, tag: Any): BaseRecycleViewHolder {
        val view = getView<View>(id)
        view.tag = tag
        return this
    }

    fun setCheck(id: Int, check: Boolean): BaseRecycleViewHolder {
        val view = getView<View>(id)
        if (view is CompoundButton) {
            view.isChecked = check
        } else if (view is CheckBox) {
            view.isChecked = check
        }
        return this
    }
}
