package com.flashapps.bubblepicker

import com.flashapps.bubblepicker.model.PickerItem

/**
 *  on 3/6/17.
 */
interface BubblePickerListener {

    fun onBubbleSelected(item: PickerItem)

    fun onBubbleDeselected(item: PickerItem)

}