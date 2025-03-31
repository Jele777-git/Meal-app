package com.example.vcfoodrecommedation

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the UI elements
        val timeOfDayInput = findViewById<EditText>(R.id.timeOfDayInput)
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // Meal Suggestion Logic
        fun suggestMeal(timeOfDay: String): String {
            return when (timeOfDay.lowercase()) {
                "morning" -> "Breakfast: 1.Eggs , 2.Oatmeal, 3.Avocado & Bread , 4.Omelet with cheese and veggies , 5.Salmon  "
                "mid-morning" -> "Snack: 1.Fruit , 2.Greek Yogurt , 3.Smoothies , 4.Boiled egg , 5.Cottage cheese"
                "afternoon" -> "Lunch: 1.Sandwich , 2.Grilled chicken salad , 3.Veggie fry , 4.Quinoa bowl , 5.Pastor "
                "mid-afternoon" -> "Snack: 1.Cake , 2.Carrot , 3.almonds & mixed nuts , 4.Apple slices , 5.Iced coffee "
                "dinner" -> "Main Course: Pasta"
                "after dinner" -> "Dessert: 1.Ice Cream , 2.Caramel , 3.Banana cake , 4.Pink cake , "
                else -> "Invalid time of day. Please enter a valid time like 'Morning' or 'Dinner'."
            }
        }


        resetButton.setOnClickListener {
            timeOfDayInput.text.clear() // Clear the input
            mealSuggestion.text = "Your meal suggestion will appear here."
        }


        timeOfDayInput.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val userInput = timeOfDayInput.text.toString()


                if (TextUtils.isEmpty(userInput)) {
                    Toast.makeText(this, "Please enter a time of day.", Toast.LENGTH_SHORT).show()
                } else {

                    mealSuggestion.text = suggestMeal(userInput)
                }
            }
        }
    }
}

