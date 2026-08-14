package ir.tasisat.mohandesnazari

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp


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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasisatApp() {

    var selectedTab by remember {
        mutableIntStateOf(0)
    }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "تأسیسات با مهندس ناظری",
                        textAlign = TextAlign.Right
                    )
                }
            )
        },

        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = {
                        selectedTab = 0
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = "آموزش"
                        )
                    },
                    label = {
                        Text("آموزش")
                    }
                )

                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = {
                        selectedTab = 1
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Build,
                            contentDescription = "موضوعات"
                        )
                    },
                    label = {
                        Text("موضوعات")
                    }
                )

                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = {
                        selectedTab = 2
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "تنظیمات"
                        )
                    },
                    label = {
                        Text("تنظیمات")
                    }
                )
            }
        }

    ) { paddingValues ->

        when (selectedTab) {

            0 -> HomeScreen(
                modifier = Modifier.padding(paddingValues)
            )

            1 -> TopicsScreen(
                modifier = Modifier.padding(paddingValues)
            )

            2 -> SettingsScreen(
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    val lessons = listOf(
        "ابزارهای پایه تأسیسات",
        "شناخت انواع شیرها",
        "انواع لوله و اتصالات",
        "اتو لوله و روش استفاده",
        "اصول ایمنی در موتورخانه",
        "آشنایی با سیستم تبرید آمونیاکی"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {

            Text(
                text = "آموزش امروز",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Right
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "نکته امروز",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = "قبل از کار با هر ابزار یا تجهیز تأسیساتی، ابتدا کاربرد و روش صحیح استفاده از آن را یاد بگیرید.",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "ادامه مسیر یادگیری",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Right
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }

        items(lessons) { lesson ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            ) {

                androidx.compose.foundation.layout.Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = null
                    )

                    Text(
                        text = lesson,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Right
                    )
                }
            }
        }
    }
}


@Composable
fun TopicsScreen(
    modifier: Modifier = Modifier
) {

    val topics = listOf(
        "۱. مبانی تأسیسات ساختمان",
        "۲. ابزارهای تأسیساتی",
        "۳. لوله‌ها و اتصالات",
        "۴. انواع شیر و کاربرد آنها",
        "۵. پمپ‌ها",
        "۶. موتورخانه ساختمان",
        "۷. سیستم‌های سرمایش و گرمایش",
        "۸. سردخانه آمونیاکی",
        "۹. کمپرسور آمونیاکی",
        "۱۰. کندانسور و اواپراتور",
        "۱۱. شیر انبساط و شیر برقی",
        "۱۲. تعمیر و نگهداری",
        "۱۳. عیب‌یابی سیستم‌های تأسیساتی",
        "۱۴. ایمنی کار با آمونیاک"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {

            Text(
                text = "سرفصل‌های آموزش",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Right
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

        items(topics) { topic ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            ) {

                Text(
                    text = topic,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    textAlign = TextAlign.Right
                )
            }
        }
    }
}


@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.End
    ) {

        Text(
            text = "تنظیمات",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "اعلان آموزش روزانه",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "دریافت مطالب جدید از اینترنت",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "ذخیره مطالب مورد علاقه",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right
        )
    }
}
