package com.example.watermate.custom_utils

import android.content.Context
import android.graphics.Typeface
import android.text.Html
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.watermate.R

class CustomArrayAdapter(context: Context, resource: Int, objects: Array<String>) :
    ArrayAdapter<String>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)

        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.setTextColor(ContextCompat.getColor(context, R.color.textBlack))
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 19f)
        textView.letterSpacing = 0.01f
        textView.setPadding(60, 0, 0, 20)

        val itemText = getItem(position)
        if (itemText != null) {
            val bulletPoint = if (position == 0) "" else "• "
            val lines = itemText.split("\n")
            val formattedText = buildString {
                append("<b>$bulletPoint</b>&nbsp;${lines[0]}")
                if (lines.size > 1) {
                    append("<br/>")
                    for (i in 1 until lines.size) {
                        if (position > 0) {
                            append("&#8201;&#8201;&#8201;&#8239;")
                        }
                        else{
                            append("&nbsp;")
                        }
                        append("${lines[i]}")
                    }
                }
            }
            textView.text = Html.fromHtml(formattedText, Html.FROM_HTML_MODE_LEGACY)
        }

        if (position == 0) {
            textView.setTypeface(null, Typeface.NORMAL)
            textView.setPadding(30,0,0,20)
        } else {
            textView.setTypeface(null, Typeface.NORMAL)
        }

        return view
    }
}
