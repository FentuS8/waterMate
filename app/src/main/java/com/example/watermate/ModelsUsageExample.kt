package com.example.watermate

import com.example.watermate.models.DehydrationLevel
import com.example.watermate.models.DehydrationTreatment
import com.example.watermate.models.Electrolites
import com.example.watermate.models.WaterBalance


fun main() {
    // Dehydration
    val dehydrationLevel = DehydrationLevel("Irritable", "Sticky", "Few", "Light sleepiness")
    val points = dehydrationLevel.getPoints()
    println("Total points: $points")

    // Electrolites
    val patient = Electrolites("Sodium Chloride", 30)
    val info = patient.getInfo()
    println(info)

    // WaterBalance
    val waterBalance = WaterBalance(75.0, 35)

    val dailyWaterIntake = waterBalance.calculateDailyWaterIntake()
    println("Рекомендуемое ежедневное потребление воды: $dailyWaterIntake мл")

    val dailyWaterIntakeInGlasses = waterBalance.calculateDailyWaterIntakeInGlasses()
    println("Рекомендуемое ежедневное потребление воды в стаканах: $dailyWaterIntakeInGlasses")

    // Dehydration Treatment
    val dehydrationTreatment = DehydrationTreatment()

    val weight = 75.0 // Вес человека в килограммах
    val degreeOfDehydration = 2 // Степень обезвоживания от 1 до 3

    val waterIntake = dehydrationTreatment.calculateWaterIntake(weight, degreeOfDehydration)
    println("Необходимый объем воды для восстановления водного баланса: ${waterIntake} л")

    val waterIntakeInGlasses = dehydrationTreatment.calculateWaterIntakeInGlasses(weight, degreeOfDehydration)
    println("Необходимое количество стаканов воды для восстановления водного баланса: ${waterIntakeInGlasses}")

}