import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kmm.augieafr.todoapp.common.App


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
