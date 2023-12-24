import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import

androidx.compose.ui.platform.LocalContext

import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.datepicker.MaterialPickerOnDateChangedListener

class

MainActivity : AppCompatActivity() {

    private

    lateinit

    var usernameEditText: EditText
    private

    lateinit

    var passwordEditText: EditText
    private lateinit var genderEditText: EditText
    private lateinit var emailEditText: EditText
    private

    lateinit

    var birthdayButton: Button

    override

    fun

            onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.username_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        genderEditText = findViewById(R.id.gender_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        birthdayButton = findViewById(R.id.birthday_button)

        birthdayButton.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.show(supportFragmentManager, "birthday_picker")

            datePicker.addOnDateChangedListener(object : MaterialPickerOnDateChangedListener {
                override fun onDateChanged(
                    picker: MaterialDatePicker<Long>,
                    date: Long,
                    isCanceled: Boolean
                ) {
                    if (!isCanceled) {
                        val calendar = Calendar.getInstance()
                        calendar.timeInMillis = date

                        val year = calendar.get(Calendar.YEAR)
                        val month = calendar.get(Calendar.MONTH) + 1


                        val day = calendar.get(Calendar.DAY_OF_MONTH)

                        birthdayEditText.setText("$year-$month-$day")
                    }
                }
            })
        }

        val context = LocalContext.current

        val registerButton = findViewById<Button>(R.id.register_button)
        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()


            val password = passwordEditText.text.toString()
            val gender = genderEditText.text.toString()
            val email = emailEditText.text.toString()
            val birthday = birthdayEditText.text.toString()

            val dialog = AlertDialog.Builder(context).setTitle("Register")
                .setMessage("Username: $username\nPassword: $password\nGender: $gender\nEmail: $email\nBirthday: $birthday")
                .setPositiveButton("OK", null)
                .create()

            dialog.show()
        }
    }
}