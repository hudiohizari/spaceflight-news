package com.hizari.data.model.dto.launch

import com.google.gson.annotations.SerializedName

/**
 * Spaceflight News - com.hizari.data.model.dto.launch
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

data class LaunchDTO(
    @SerializedName("launch_id")
    val launchId: Int? = null,
    val provider: String? = null
)