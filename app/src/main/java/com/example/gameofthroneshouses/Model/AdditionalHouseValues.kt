package com.example.gameofthroneshouses.model

import com.example.gameofthroneshouses.model.House

/**
 * This is a dataclass to Expand Data from House-Dataclass.
 * in House there are only direct Values which are available instant
 * here are the Values which needed to query first.
 */
data class AdditionalHouseValues(val house: House){

    var currentLord: Character? = null
    var heir:Character?=null
    var overlord:Character?=null
    var founder:Character?=null
    var swornMembers:List<Character?>?=null
}


