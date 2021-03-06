package com.duongtung.cookingman.customview

import android.content.Context
import android.graphics.Typeface
import android.webkit.JavascriptInterface
import java.util.*

object FontCache {

    const val FA_FONT_REGULAR = "fa-regular-400.ttf"

    const val FA_FONT_SOLID = "fa-solid-900.ttf"

    const val FA_FONT_SOLID_OTF = "fa-solid-900.otf"

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

    private val fontCache = Hashtable<String, Typeface>()
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

    @JvmStatic
    fun getTyface(context: Context, typeFace: Int): Typeface? {
        when (typeFace) {
            0 -> return get(context, FA_FONT_LIGHT)
            1 -> return get(context, FA_FONT_BRANDS)
            2 -> return get(context, FA_FONT_SOLID)
            3 -> return get(context, FA_FONT_REGULAR)
            4 -> return get(context, FONT_CATHSGBR)
            5 -> return get(context, FONT_GENBKBASL)
            6 -> return get(context, FONT_ROBOTO_REGULAR)
            7 -> return get(context, FONT_ROBOTO_THIN)
            8 -> return get(context, FONT_ROBOTO_MEDIUM)
            9 -> return get(context, FONT_ROBOTO_LIGHT)
            10 -> return get(context, FONT_ROBOTO_ITALIC)
            11 -> return get(context, FONT_ROBOTO_BOLD)
            12 -> return get(context, FA_FONT_SOLID_OTF)
        }
        return get(context, FA_FONT_LIGHT)
    }
}