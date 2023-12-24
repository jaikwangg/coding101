package com.example.lab4ui

import android.graphics.drawable.Icon
import android.hardware.camera2.params.MeteringRectangle
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.lab4ui.ui.theme.Lab4UITheme
import java.sql.Time

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4UITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab4UITheme {
//        Greeting("Android")
    MyScreen()
    }
}

@Composable
fun IdNameContent(id: String, onIDChange: (String) -> Unit, name: String, onNameChange: (String) -> Unit) {
    Column() {
        OutlinedTextField(
            value = id,
            onValueChange = onIDChange,
            label = { Text(text = "Student ID")},
            modifier = Modifier.width(400.dp)
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text(text = "Name")},
            modifier = Modifier.width(400.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectDropdown(): String {
    val keyboardController = LocalSoftwareKeyboardController.current
    val subjectsList = listOf(
        "Select Subject",
        "SC362007 Mobile Device Programming",
        "SC362004 Web Appllicaion Programming",
        "SC362005 Database Analysis and Design"
    )
    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedSubject by remember {
        mutableStateOf(subjectsList[0])
    }

    ExposedDropdownMenuBox(
        modifier = Modifier
            .clickable { keyboardController?.hide() },
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }) {
            OutlinedTextField(
                modifier = Modifier
                    .width(400.dp)
                    .menuAnchor()
                    .clickable { keyboardController?.hide() },
                value = selectedSubject,
                onValueChange = {},
                textStyle = TextStyle.Default.copy(fontSize = 12.sp),
                readOnly = true,
                label = { Text("Subjects") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
        
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            subjectsList.forEach {selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedSubject = selectionOption
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
    return selectedSubject
}

@Composable
fun CreditContent(credit: String, onCreditChange: (String) -> Unit): Int {
    Column() {
        OutlinedTextField(
            value = credit,
            onValueChange = onCreditChange,
            label = { Text(text = "Credit")},
            modifier = Modifier.width(400.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
    return 0
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeContent(): Pair<Int, Int> {
    var selectedHour by remember {
        mutableIntStateOf(0)
    }
    var selectedMinute by remember {
        mutableIntStateOf(0)
    }
    var showDialog by remember {
        mutableStateOf(false)
    }
    val timePickerState = rememberTimePickerState(
        initialHour = selectedHour,
        initialMinute = selectedMinute
    )

    if(showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            properties = DialogProperties(usePlatformDefaultWidth = false),
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(size = 12.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .background(
                        color = Color.LightGray.copy(alpha = 0.3f)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TimePicker(state = timePickerState)
                Row(
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    // ปุ่ม Dismiss
                    TextButton(onClick = { showDialog = false }) {
                        Text(text = "Dismiss")
                    }

                    // ปุ่ม Dismiss
                    TextButton(onClick = {
                        showDialog = false
                        selectedHour = timePickerState.hour
                        selectedMinute = timePickerState.minute
                    }) {
                        Text(text = "Confirm")
                    }
                }
            }
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
//        verticalAlignment = Alignment.CenterHorizontally,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Select Time"
        )
        FilledIconButton(onClick = { showDialog = true }) {
            Icon(
                modifier = Modifier.size(size = 30.dp),
                imageVector = Icons.Outlined.DateRange,
                contentDescription = "Time Icon"
            )
        }
        Text(text = "(HH:MM) = $selectedHour : $selectedMinute")
    }
    return selectedHour to selectedMinute
}

@Composable
fun MyScreen() {
    val contextForToast = LocalContext.current.applicationContext
    var textInformation by rememberSaveable {
        mutableStateOf("🥜ing")
    }
    var id by rememberSaveable {
        mutableStateOf("")
    }
    var name by rememberSaveable {
        mutableStateOf("")
    }
    var subject by remember {
        mutableStateOf("")
    }
    var credit by remember {
        mutableStateOf("")
    }
    var hour by remember {
        mutableStateOf("")
    }
    var minute by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enter Student Information",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp)
        )
        IdNameContent(id = id, onIDChange = {id=it}, name = name, onNameChange = {name=it})

        //Subject DropDown
        subject = SubjectDropdown()

        //Lab ข้อ 1
        CreditContent(credit = credit, onCreditChange = {credit=it})

        //Time
        var (hourValue, minuteValue) = TimeContent()
        hour = if(hourValue<10) "0${hourValue}" else "$hourValue"
        minute = if(minuteValue<10) "0${minuteValue}" else "$minuteValue"

        Spacer(modifier = Modifier.height(height = 8.dp))
        Button(
            onClick = {
                Toast.makeText(
                    contextForToast,
                    "This $hour : $minute", Toast.LENGTH_LONG)
                    .show()
                textInformation = "Student Name: ${name}\nID: ${id}\nSubject: ${subject}\nCredit: ${credit}\nTime: ${hour} : ${minute}"
            }
        ) {
            Text(
                text = "Show Information"
            )
        }
        Column(
            modifier = Modifier
                .width(400.dp)
                .padding(16.dp)
                .wrapContentHeight(unbounded = true)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Text(text = "Student Information: ",
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
            Text(text = textInformation,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}