package com.selcannarin.dictionaryapp

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Words(

    var english : String? = "",

    var turkish :String? = "",

    var word_id : String? = ""

    ) : Serializable


