package vcmsa.josh.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vcmsa.josh.mathapp.R
class MainActivity : AppCompatActivity() {
    // Declaring the UI components
    private lateinit var edtEnterValueOne: EditText
    private lateinit var edtEnterValueTwo: EditText
    private lateinit var edtFinalAnswer: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize the UI components
        initializeViews()
        // Set up the button click listener
        buttonCalculate.setOnClickListener {
            performCalculation()
        }
    }
    // Function to bind the UI components
    private fun initializeViews() {
        edtEnterValueOne = findViewById(R.id.edtEnterValueOne)
        edtEnterValueTwo = findViewById(R.id.edtEnterValueTwo)
        edtFinalAnswer = findViewById(R.id.edtFinalAnswer)
        buttonCalculate = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
    }
    // Function to perform the addition and display the result
    private fun performCalculation() {
        // Retrieve the input values from EditText
        val valueOne = edtEnterValueOne.text.toString()
        val valueTwo = edtEnterValueTwo.text.toString()
        // Check if both inputs are filled in
        if (valueOne.isNotEmpty() && valueTwo.isNotEmpty()) {
            // Try to convert the input values to integers
            val num1 = valueOne.toIntOrNull()
            val num2 = valueTwo.toIntOrNull()
            // Check if both inputs are valid numbers
            if (num1 != null && num2 != null) {
                // Calculate the sum and display it in the Final Answer EditText
                val sum = num1 + num2
                edtFinalAnswer.setText(sum.toString())
                textView.text = "Result: $sum"
            } else {
                // If invalid input, show an error message
                textView.text = "Please enter valid numbers."
            }
        } else {
            // If any input is missing, show an error message
            textView.text = "Please enter both numbers."

        }
    }
}
