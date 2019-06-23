package com.retailmotion.android.luastimer.data.model

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Tram(

    @Attribute
    var dueMins: String,

    @Attribute
    var destination: String
)