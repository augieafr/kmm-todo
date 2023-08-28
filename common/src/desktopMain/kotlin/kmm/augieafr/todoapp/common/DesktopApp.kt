package kmm.augieafr.todoapp.common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import kmm.augieafr.todoapp.common.data.database.DatabaseDriverFactory

@Preview
@Composable
fun AppPreview() {
    App(DatabaseDriverFactory())
}