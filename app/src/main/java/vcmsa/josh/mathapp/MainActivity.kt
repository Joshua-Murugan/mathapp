package vcmsa.josh.mathapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtEnterValueOne: EditText
    private lateinit var edtEnterValueTwo: EditText
    private lateinit var edtFinalAnswer: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textStatus: TextView
    private lateinit var radioGroupOperations: RadioGroup
    private lateinit var radioAddition: RadioButton
    private lateinit var radioSubtraction: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        edtEnterValueOne = findViewById(R.id.edtEnterValueOne)
        edtEnterValueTwo = findViewById(R.id.edtEnterValueTwo)
        edtFinalAnswer = findViewById(R.id.edtFinalAnswer)
        buttonCalculate = findViewById(R.id.button)
        textStatus = findViewById(R.id.textView)
        radioGroupOperations = findViewById(R.id.radioGroupOperations)
        radioAddition = findViewById(R.id.radioAddition)
        radioSubtraction = findViewById(R.id.radioSubtraction)

        buttonCalculate.setOnClickListener {
            performCalculation()
        }
    }

    private fun performCalculation() {
        val valueOne = edtEnterValueOne.text.toString()
        val valueTwo = edtEnterValueTwo.text.toString()

        // Check if input is empty
        if (valueOne.isEmpty() || valueTwo.isEmpty()) {
            textStatus.text = "Please enter both numbers."
            return
        }

        val num1 = valueOne.toIntOrNull()
        val num2 = valueTwo.toIntOrNull()

        // Check if input is valid
        if (num1 == null || num2 == null) {
            textStatus.text = "Please enter valid numbers."
            return
        }

        val selectedId = radioGroupOperations.checkedRadioButtonId

        // Check if an operation is selected
        if (selectedId == -1) {
            textStatus.text = "Please select an operation."
            return
        }

        // Perform calculation
        val result = when (selectedId) {
            R.id.radioAddition -> num1 + num2
            R.id.radioSubtraction -> num1 - num2
            else -> 0
        }

        edtFinalAnswer.setText(result.toString())

        val operation = if (selectedId == R.id.radioAddition) "Addition" else "Subtraction"
        textStatus.text = "Operation: $operation\nAnswer: $result"
    }
}
