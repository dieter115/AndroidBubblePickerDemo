package com.flashapps.bubblepicker.exception

import java.lang.Exception

/**
 *  on 1/19/17.
 */
class EmptyPickerException() : Exception("Picker must have at least one item when it becomes visible")