package com.fahad.project.common_domain.providers

import android.app.Activity

interface CurrentActivityProvider {
    fun get(): Activity
}
