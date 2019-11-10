package com.purnaprasanth.baseandroid

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.purnaprasanth.baseandroid.databinding.ViewTextWithHeaderBinding

/**
 * Created by purna on 2019-11-10
 **/

class TextWithHeaderView : LinearLayout {

    lateinit var binding: ViewTextWithHeaderBinding

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {
        initView()
    }

    constructor(context: Context, attributes: AttributeSet, defStyle: Int) : super(
        context,
        attributes,
        defStyle
    ) {
        initView()
    }

    private fun initView() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflater, R.layout.view_text_with_header, this, true)
    }

    fun setText(text: String?) {
        binding.text.text = text
    }

    fun setTitle(title: String) {
        binding.title.text = title
    }
}