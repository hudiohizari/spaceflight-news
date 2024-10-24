package com.hizari.data.model.dto.event

import com.google.gson.annotations.SerializedName

/**
 * Spaceflight News - com.hizari.data.model.dto.event
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

data class EventDTO(
    @SerializedName("event_id")
    val eventId: String? = null,
    val provider: String? = null
)