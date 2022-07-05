package com.example.gameofthroneshouses.rest

/**
 * A Util Call for Rest-Service here is the Central Place for all URLs + here are Functions for
 * URL-Operations
 */
object GotUrlUtil {

    const val BASIC_REST_URL = "https://anapioficeandfire.com/"
    const val GET_HOUSES_RELATIVE = "api/houses/"
    const val GET_CHARACTERS_RELATIVE = "api/characters/"
    const val NO_CORRECT_URL ="-1" // for example when you try to get a Character id but you use a House Id
    const val NO_NUMBER = "-2"

    /**
     * @param testURL a Url which will be testet if its a  House Query Url for An Api of ice and Fire
     * @return true if the String Starts with https://anapioficeandfire.com/api/houses/
     */
    fun isAHouseQueryUrl(testURL: String) =
        testURL.startsWith(BASIC_REST_URL + GET_HOUSES_RELATIVE)

    /**
     *  Check and cuts a String in Format of https://anapioficeandfire.com/api/houses/
     *  and if its in this Format returns the id in be back of the URL
     * @param  testURL a Url which will be testet if its Query Url for An Api of ice and Fire
     * @return  Return ID if there is the Right Url Given,
     * if the Wrong URL is given returns -1 as String
     * if the Numberpart is wrong (is no Number for Example) its returns -2
     */

    fun getHouseIdFromUrl(testURL: String): String {
        return if (isAHouseQueryUrl(testURL)) {
            getGeneralIdFromUrl(testURL, GET_HOUSES_RELATIVE)
        } else {
            NO_CORRECT_URL
        }
    }
    /**
     * @param testURL a Url which will be testet if its a Character Query Url for An Api of ice and Fire
     * @return true if the String Starts with https://anapioficeandfire.com/api/characters/
     */
    fun isACharacterQueryUrl(testURL: String) =
        testURL.startsWith(BASIC_REST_URL + GET_CHARACTERS_RELATIVE)

    /**
     *  Check and cuts a String in Format of https://anapioficeandfire.com/api/characters/
     *  and if its in this Format returns the id in be back of the URL
     * @param  testURL a Url which will be testet if its Query Url for An Api of ice and Fire
     * @return  Return ID if there is the Right Url Given,
     * if the Wrong URL is given returns -1 as String
     * if the Numberpart is wrong (is no Number for Example) its returns -2
     */
    fun getCharacterIdFromUrl(testURL: String): String {
        return if (isACharacterQueryUrl(testURL)) {
            getGeneralIdFromUrl(testURL, GET_CHARACTERS_RELATIVE)
        } else {
            NO_CORRECT_URL
        }
    }

    /**
     *  Check and cuts a String in Format of https://anapioficeandfire.com/[relativeURL]
     *  and if its in this Format returns the id in be back of the URL
     * @param  testURL a Url which will be testet if its Query Url for An Api of ice and Fire
     * @param relativeURL the relative Url determine which kind of ID will be Checked and returned
     * @return  Return ID if there is the Right Url Given,
     * if the Wrong URL is given returns -1 as String
     * if the Numberpart is wrong (is no Number for Example) its returns -2
     */
    fun getGeneralIdFromUrl(testURL: String, relativeURL: String): String {
        val cuttedString = testURL.removePrefix(BASIC_REST_URL + relativeURL)
        return if (cuttedString.all { char -> char.isDigit() }) {
            cuttedString
        } else {
            NO_NUMBER
        }
    }
}


