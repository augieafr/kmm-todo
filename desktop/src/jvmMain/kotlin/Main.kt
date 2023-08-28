import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kmm.augieafr.todoapp.common.App
import kmm.augieafr.todoapp.common.data.database.DatabaseDriverFactory


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App(DatabaseDriverFactory())
    }
}
