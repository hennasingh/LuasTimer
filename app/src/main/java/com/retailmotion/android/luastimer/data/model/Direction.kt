package com.retailmotion.android.luastimer.data.model

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Direction(

    @Attribute
    var name: String,

    @Element(name = "tram")
    var trams: List<Tram>
)