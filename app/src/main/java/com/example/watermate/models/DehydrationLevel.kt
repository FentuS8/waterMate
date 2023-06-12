package com.example.watermate.models

class DehydrationLevel {
    var appearance: String = ""
    var eyes: String = ""
    var mucous: String = ""
    var tears: String = ""

    fun getPoints(): Int {
        var points = 0

        // Checking Appearance
        when (appearance) {
            "Normal" -> points += 0
            "Irritable" -> points += 1
            "Sluggish" -> points += 2
        }

        // Checking Eyes
        when (eyes) {
            "Normal" -> points += 0
            "Light sleepiness" -> points += 1
            "Drowsy" -> points += 2
        }
        // 123456789
        // Checking Mucous
        when (mucous) {
            "Wet" -> points += 0
            "Sticky" -> points += 1
            "Dry" -> points += 2
        }

        // Checking Tears
        when (tears) {
            "Yes" -> points += 0
            "Few" -> points += 1
            "No" -> points += 2
        }

        return points
    }
}

//fun main() {
//    val dehydrationLevel = DehydrationLevel()
//    dehydrationLevel.appearance = "Irritable"
//    dehydrationLevel.eyes = "Drowsy"
//    dehydrationLevel.mucous = "Dry"
//    dehydrationLevel.tears = "Few"
//
//    val points = dehydrationLevel.getPoints()
//    println("Dehydration Level: $points")
//}
