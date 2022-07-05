package com.example.gameofthroneshouses.model

import java.io.Serializable


/**
 * A House is a house branch within the Ice And Fire universe.
 *
 * @property house The hypermedia URL of this resource, always starts with "https://anapioficeandfire.com/api/houses/{HouseID}"
 * @property name The name of this house
 * @property region The region that this house resides in
 * @property coatOfArms Text describing the coat of arms of this house.
 * @property words The words of this house.
 * @property titles The titles that this house holds.
 * @property seats The seats that this house holds.
 * @property currentLord The Character resource URL of this house's current lord, always starts with "https://anapioficeandfire.com/api/characters/{CharacterID}
 * @property heir The Character resource URL of this house's heir, always starts with "https://anapioficeandfire.com/api/characters/{CharacterID}
 * @property overlord The House resource URL that this house answers to, always starts with "https://anapioficeandfire.com/api/houses/{HouseID}
 * @property founded The year that this house was founded.
 * @property founder The Character resource URL of this house's heir, always starts with "https://anapioficeandfire.com/api/characters/{CharacterID}
 * @property diedOut The year that this house died out.
 * @property ancestralWeapons A List of names of the noteworthy weapons that this house owns.
 * @property cadetBranches A List of House resource URLs that was founded from this house
 * @property swornMembers A List of Character resource URLs that are sworn to this house
 *
 */


data class House(
    val house: String,
    val name: String,
    val region: String?,
    val coatOfArms: String?,
    val words: String?,
    val titles: List<String>?,
    val seats: List<String>?,
    val currentLord: String?,
    val heir: String?,
    val overlord: String?,
    val founded: String?,
    val founder: String?,
    val diedOut: String?,
    val ancestralWeapons: List<String>?,
    val cadetBranches: List<String>?,
    val swornMembers: List<String>?
):Serializable
