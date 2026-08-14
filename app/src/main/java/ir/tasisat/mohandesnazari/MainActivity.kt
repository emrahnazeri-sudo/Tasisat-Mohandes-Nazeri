package ir.tasisat.mohandesnazari

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider(
                LocalLayoutDirection provides LayoutDirection.Rtl
            ) {
                MaterialTheme {
                    TasisatApp()
                }
            }
        }
    }
}

@Composable
fun TasisatApp() {

    var selectedTab by remember {
        mutableIntStateOf(0)
    }

    val tabs = listOf(
        "آموزش",
        "موضوعات",
        "تنظیمات"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "تأسیسات با مهندس ناظری"
                    )
                }
            )
        }
    ) { innerPadding ->

        Text(
            text = tabs[selectedTab],
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
