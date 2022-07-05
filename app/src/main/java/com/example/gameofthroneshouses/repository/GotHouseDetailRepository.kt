package com.example.gameofthroneshouses.repository

import com.example.gameofthroneshouses.rest.GotRestApiService

class GotHouseDetailRepository(private val restApiService: GotRestApiService) {


    fun queryGetCharacter(characterId: String) = restApiService.queryCharacterById(characterId)
}