package kmm.augieafr.todoapp.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import kmm.augieafr.todoapp.common.App
import kmm.augieafr.todoapp.common.data.database.DatabaseDriverFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(DatabaseDriverFactory(this))
        }
    }
}