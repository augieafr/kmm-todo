package kmm.augieafr.todoapp.common.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kmm.augieafr.todoapp.common.ui.utils.toDateFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoDatePicker(
    initialDisplayMonthMillis: Long = System.currentTimeMillis(),
    onDismissRequest: () -> Unit,
    onSaveButtonClick: (String) -> Unit
) {
    val datePickerState = rememberDatePickerState(
        initialDisplayedMonthMillis = initialDisplayMonthMillis,
        initialDisplayMode = DisplayMode.Picker
    )

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {
            Column(horizontalAlignment = Alignment.End) {
                DatePicker(modifier = Modifier.padding(16.dp), state = datePickerState)
                Button(modifier = Modifier.padding(16.dp), onClick = {
                    datePickerState.selectedDateMillis?.toDateFormat()
                        ?.let { onSaveButtonClick(it) }
                }) {
                    Text(text = "Save")
                }
            }
        }
    }
}