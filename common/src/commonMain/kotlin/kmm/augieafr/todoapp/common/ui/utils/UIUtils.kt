package kmm.augieafr.todoapp.common.ui.utils

import kmm.augieafr.todoapp.common.ui.model.TodoDeadline
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

fun dueDateToDeadline(dueDate: String): TodoDeadline {
    val sdf = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
    val currentDate = Date()
    val endDate = sdf.parse(dueDate)

    val timeLeft = (endDate?.time ?: 0) - currentDate.time
    val dayLeft = TimeUnit.MILLISECONDS.toDays(timeLeft)
    return when {
        dayLeft <= 0 -> TodoDeadline.NEAR("Due date has passed")
        dayLeft < 3 -> TodoDeadline.NEAR("$dayLeft days left")
        dayLeft < 7 -> TodoDeadline.MID("$dayLeft days left")
        else -> {
            TodoDeadline.FAR(
                "${
                    endDate?.let {
                        sdf.applyPattern("MM-dd-yyyy")
                        sdf.format(endDate)
                    }
                }"
            )
        }
    }
}

fun String?.changeDatePattern(
    sourcePattern: String,
    targetPattern: String
): String {
    if (this == null) return ""
    val parser = SimpleDateFormat(sourcePattern, Locale.getDefault())
    val formatter = SimpleDateFormat(targetPattern, Locale.getDefault())
    return parser.parse(this)?.let { formatter.format(it) } ?: ""
}

fun Long?.toDateFormat(pattern: String = "MM-dd-yyyy"): String {
    if (this == null) return ""
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return sdf.format(calendar.time)
}