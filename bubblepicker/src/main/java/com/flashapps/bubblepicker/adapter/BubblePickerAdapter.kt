package com.flashapps.bubblepicker.adapter

import com.flashapps.bubblepicker.model.PickerItem

/**
 *  on 5/22/17.
 */
interface BubblePickerAdapter {

    val totalCount: Int

    fun getItem(position: Int): PickerItem

}