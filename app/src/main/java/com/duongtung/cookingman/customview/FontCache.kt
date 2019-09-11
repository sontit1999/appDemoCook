package com.duongtung.cookingman.customview

import android.content.Context
import android.graphics.Typeface
import java.util.*

object FontCache {

    const val FA_FONT_REGULAR = "fa-regular-400.ttf"

    const val FA_FONT_SOLID = "fa-solid-900.ttf"

    const val FA_FONT_BRANDS = "fa-brands-400.ttf"

    const val FA_FONT_LIGHT = "fa-light-300.ttf"

    const val FONT_CATHSGBR = "CATHSGBR.TTF"

    const val FONT_GENBKBASL = "GenBkBasl.ttf"

    const val FONT_ROBOTO_BOLD = "Roboto-Bold.ttf"

    const val FONT_ROBOTO_ITALIC = "Roboto-Italic.ttf"

    const val FONT_ROBOTO_LIGHT = "Roboto-Light.ttf"

    const val FONT_ROBOTO_MEDIUM = "Roboto-Medium.ttf"

    const val FONT_ROBOTO_REGULAR = "Roboto-Regular.ttf"

    const val FONT_ROBOTO_THIN = "Roboto-Thin.ttf"

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