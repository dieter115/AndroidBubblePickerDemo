package com.flashapps.bubblepicker.model

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt

/**
 *  on 1/19/17.
 */
data class PickerItem @JvmOverloads constructor(var title: String? = null,
                                                var icon: Drawable? = null,
                                                var iconOnTop: Boolean = true,
                                                @ColorInt var color: Int? = null,
                                                @ColorInt var selectedColor: Int? = null,
                                                var gradient: BubbleGradient? = null,
                                                var overlayAlpha: Float = 0.5f,
                                                var typeface: Typeface = Typeface.DEFAULT,
                                                @ColorInt var textColor: Int? = null,
                                                @ColorInt var selectedTextColor: Int? = null,
                                                var textSize: Float = 40f,
                                                var backgroundImage: Drawable? = null,
                                                var isSelected: Boolean = false,
                                                @ColorInt var borderColor: Int? = null,
                                                @ColorInt var borderSelectedColor: Int? = null,
                                                var borderSize: Int = 0)