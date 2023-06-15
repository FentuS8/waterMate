package com.example.watermate

import com.example.watermate.models.DehydrationLevel
import com.example.watermate.models.DehydrationTreatment
import com.example.watermate.models.Electrolites
import com.example.watermate.models.WaterBalance
import com.example.watermate.utils.converters.WaterIntakeConverter
import com.example.watermate.utils.converters.WaterIntakeInGlassesConverter
import com.example.watermate.utils.evaluators.DefaultAppearanceEvaluator
import com.example.watermate.utils.evaluators.DefaultEyesEvaluator
import com.example.watermate.utils.evaluators.DefaultMucousEvaluator
import com.example.watermate.utils.evaluators.DefaultTearsEvaluator
import com.example.watermate.utils.multipliers.DegreeOfDehydrationMultiplier
import com.example.watermate.utils.providers.AgeBasedInjectionsProvider
import com.example.watermate.utils.providers.CalciumSolutionProvider
import com.example.watermate.utils.providers.DefaultAgeMultiplierProvider


fun main() {
    // Dehydration
    // Создаем список оценщиков
    val evaluators = listOf(
        DefaultEyesEvaluator("Normal"),
        DefaultTearsEvaluator("Yes"),
        DefaultMucousEvaluator("Sticky"),
        DefaultAppearanceEvaluator("Irritable")
    )

    // Создаем объект класса DehydrationLevel, передавая список оценщиков
    val dehydrationLevel = DehydrationLevel(evaluators)

    // Получаем общее количество баллов
    val totalPoints = dehydrationLevel.getPoints()

    // Выводим результат
    println("Total points: $totalPoints") // 2

    // Electrolites
    val electrolyte = Electrolites("Sodium", 30, CalciumSolutionProvider(), AgeBasedInjectionsProvider())
    val info = electrolyte.getInfo()
    println("Electrolites info:\n$info")

    // Water
    val waterBalance = WaterBalance(
        weight = 70.0,
        age = 25,
        ageMultiplierProvider = DefaultAgeMultiplierProvider(),
        waterIntakeCalculator = WaterIntakeConverter(),
        waterIntakeInGlassesCalculator = WaterIntakeInGlassesConverter()
    )
    println("Daily Water Intake: ${waterBalance.calculateDailyWaterIntake()}")
    println("Daily Water Intake in Glasses: ${waterBalance.calculateDailyWaterIntakeInGlasses()}")

    // Dehydration Treatment
    val dehydrationTreatment = DehydrationTreatment(
        degreeOfDehydrationMultiplier = DegreeOfDehydrationMultiplier(),
        waterIntakeConverter = WaterIntakeConverter(),
        waterIntakeInGlassesCalculator = WaterIntakeInGlassesConverter()
    )

    println("Dehydration Treatment Water Intake: ${dehydrationTreatment.calculateWaterIntake(65.3, 2)}")
    println("Dehydration Treatment Water Intake in Glasses: ${dehydrationTreatment.calculateWaterIntakeInGlasses(65.3, 2)}")
}