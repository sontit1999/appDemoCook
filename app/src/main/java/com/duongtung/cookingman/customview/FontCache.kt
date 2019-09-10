package com.duongtung.cookingman.customview

import android.content.Context
import android.graphics.Typeface
import java.util.*

object FontCache {
    val FA_FONT_REGULAR = "fa-regular-400.ttf"
    val FA_FONT_SOLID = "fa-solid-900.ttf"
    val FA_FONT_BRANDS = "fa-brands-400.ttf"
    val FA_FONT_LIGHT = "fa-light-300.ttf"
    val FONT_CATHSGBR = "CATHSGBR.TFF"
    val FONT_GENBKBASL = "GenBkBasl.tff"
    private val fontCache = Hashtable<String,Typeface>()
    @JvmStatic
    fun get(context: Context, name: String): Typeface? {
        var typeface = fontCache[name]
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.assets, name)
            } catch (e: Exception) {
                return null
            }

            fontCache[name] = typeface
        }
        return typeface
    }
}