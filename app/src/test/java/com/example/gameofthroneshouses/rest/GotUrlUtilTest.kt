package com.example.gameofthroneshouses.rest

import org.junit.Assert

import org.junit.Test

class GotUrlUtilTest {
    @Test
    fun isAHouseQueryUrl() {
        Assert.assertTrue(GotUrlUtil.isAHouseQueryUrl("https://anapioficeandfire.com/api/houses/378"))
        Assert.assertFalse(GotUrlUtil.isAHouseQueryUrl("https://anapioficeandfire.com/api/characters/583"))
        Assert.assertFalse(GotUrlUtil.isACharacterQueryUrl("https://thisisawrongUrl.com"))
    }

    @Test
    fun getHouseIdFromUrl() {
        Assert.assertEquals(
            "378",
            GotUrlUtil.getHouseIdFromUrl("https://anapioficeandfire.com/api/houses/378")
        )
        Assert.assertEquals(
            GotUrlUtil.NO_NUMBER,
            GotUrlUtil.getHouseIdFromUrl("https://anapioficeandfire.com/api/houses/-378")
        )
        Assert.assertEquals(
            GotUrlUtil.NO_CORRECT_URL,
            GotUrlUtil.getHouseIdFromUrl("https://notanapioficeandfire.com/api/houses/-378")
        )
        Assert.assertEquals(
            GotUrlUtil.NO_CORRECT_URL,
            GotUrlUtil.getHouseIdFromUrl("https://notanapioficeandfire.com/api/characters/378")
        )

    }

    @Test
    fun isACharacterQueryUrl() {
        assert(GotUrlUtil.isACharacterQueryUrl("https://anapioficeandfire.com/api/characters/583"))
        Assert.assertFalse(GotUrlUtil.isACharacterQueryUrl("https://anapioficeandfire.com/api/houses/378"))

        Assert.assertFalse(GotUrlUtil.isACharacterQueryUrl("https://thisisawrongUrl.com"))
    }

    @Test
    fun getCharacterIdFromUrl() {

        Assert.assertEquals(
            "244",
            GotUrlUtil.getCharacterIdFromUrl("https://anapioficeandfire.com/api/characters/244")
        )
        Assert.assertEquals(
            GotUrlUtil.NO_NUMBER,
            GotUrlUtil.getCharacterIdFromUrl("https://anapioficeandfire.com/api/characters/-378")
        )
        Assert.assertEquals(
            GotUrlUtil.NO_CORRECT_URL,
            GotUrlUtil.getCharacterIdFromUrl("https://notanapioficeandfire.com/api/characters/-378")
        )
    }
}