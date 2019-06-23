package com.retailmotion.android.luastimer.data.remote.response

import com.retailmotion.android.luastimer.data.model.Direction
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "stopInfo")
data class MarOutboundResponse(

    @Element
    var direction: List<Direction>
)