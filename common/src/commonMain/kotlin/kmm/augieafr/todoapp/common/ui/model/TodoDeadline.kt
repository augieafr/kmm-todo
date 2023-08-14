package kmm.augieafr.todoapp.common.ui.model

import androidx.compose.ui.graphics.Color

sealed class TodoDeadline(val timeLeft: String) {
    companion object {
        private const val BACKGROUND_COLOR = 1
        private const val ON_BACKGROUND_COLOR = 2
    }

    fun getBackgroundColor() = getDeadlineColor(this, BACKGROUND_COLOR)

    fun getOnBackgroundColor() = getDeadlineColor(this, ON_BACKGROUND_COLOR)

    // due date still one week or more
    class FAR(timeLeft: String) : TodoDeadline(timeLeft)

    // due date less than one week
    class MID(timeLeft: String) : TodoDeadline(timeLeft)

    // due date less than three days
    class NEAR(timeLeft: String) : TodoDeadline(timeLeft)
}

expect fun getDeadlineColor(deadlineType: TodoDeadline, type: Int): Color