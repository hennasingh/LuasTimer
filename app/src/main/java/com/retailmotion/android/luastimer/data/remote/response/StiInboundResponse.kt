package com.retailmotion.android.luastimer.data.remote.response

import com.retailmotion.android.luastimer.data.model.Direction
import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml
import java.util.*

@Xml(name = "stopInfo")
data class StiInboundResponse(

    @Attribute
    var createdAt: Date,

    @Element
    var direction: List<Direction>
)

