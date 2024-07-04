//Assignment 1
// Name: Muhammad Umair Khalid.
//Batch: Android (Kotlin)
//Submitted To: Kashif Mehmood.
//Date: 4th July 2024.

package com.example.bytewise_a1

fun String.buildUrl(vararg arguments: Any): String {
    /**
     * This function takes variable number of arguments and inserts the passed
     * values in the place of placeholders in the URL and returns the new updated URL.
     */

    var newUrl = this

    val prefix = "{"           //Prefix and Suffix used to identify the placeholder
    val suffix = "}"

    for( arg in arguments){        //Run for all passed Arguments

        val startIndex = newUrl.indexOf(prefix)                 //Getting the Index of first '{'

        if(startIndex == -1) {   //In case no. of passed arguments are more than the placeholders in the URL.
            break
        }

        val endIndex = newUrl.indexOf(suffix, startIndex)      //Getting the Index of first '}'
        val placeholder = newUrl.substring(startIndex, endIndex+1)        //Extracting everything in between { }

        newUrl = newUrl.replaceFirst(placeholder, arg.toString())    //Replace the placeholder with its appropriate value

    }

    return newUrl         //Returning the new Updated URL.
}

fun main() {

    val url = "play.kotlin.org/?id={id}/program={program}/device={device}"       //Old URl
    println("Initial URL : $url")

    val id = 1
    val program = "bytewise"            //Parameters for buildUrl function
    val device  = "android"

    //Function to build the New Updated URL
    val newUrl = url.buildUrl(id, program, device)             //Getting New URL

    println("Processed URL : $newUrl")            //Printing Updated URL
}