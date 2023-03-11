// : Pruthvi Soni - A00262875
package com.example.conversionapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var inputEditText: EditText
    private lateinit var conversionSpinner: Spinner
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.input_value)
        conversionSpinner = findViewById(R.id.conversion_type)
        resultTextView = findViewById(R.id.result_value)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.conversion_types,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            conversionSpinner.adapter = adapter
        }

        // Set the spinner listener
        conversionSpinner.onItemSelectedListener = this

        // Set the button listener
        val convertButton: Button = findViewById(R.id.convert_button)
        convertButton.setOnClickListener {
            onConvertButtonClicked()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // Get the input value and convert it to Double
        val input = inputEditText.text.toString().toDoubleOrNull() ?: return

        // Get the selected item from the spinner
        val selectedItem = parent.getItemAtPosition(pos).toString()

        // Calculate the result based on the selected item and set it to the resultTextView
        val result = when (selectedItem) {
            "CM to IN" -> input / 2.54
            "IN to CM" -> input * 2.54
            "Celsius to Fahrenheit" -> input * 9 / 5 + 32
            "Fahrenheit to Celsius" -> (input - 32) * 5 / 9
            "KM to MI" -> input / 1.609
            "MI to KM" -> input * 1.609
            else -> return
        }
        resultTextView.text = "%.2f".format(result)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Do nothing
    }

    private fun onConvertButtonClicked() {
        // Get the input value and convert it to Double
        val input = inputEditText.text.toString().toDoubleOrNull() ?: return

        // Get the selected item from the spinner
        val selectedItem = conversionSpinner.selectedItem.toString()

        // Calculate the result based on the selected item and set it to the resultTextView
        val result = when (selectedItem) {
            "CM to IN" -> input / 2.54
            "IN to CM" -> input * 2.54
            "Celsius to Fahrenheit" -> input * 9 / 5 + 32
            "Fahrenheit to Celsius" -> (input - 32) * 5 / 9
            "KM to MI" -> input / 1.609
            "MI to KM" -> input * 1.609
            else -> return
        }
        resultTextView.text = "%.2f".format(result)
    }
}