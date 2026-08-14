package ir.tasisat.mohandesnazari

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF061B35)
private val Gold = Color(0xFFD39A25)
private val Blue = Color(0xFF1264B8)
private val Green = Color(0xFF1FA66A)
private val Bg = Color(0xFFF6F8FA)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { TasisatApp() }
    }
}

@Composable
fun TasisatApp() {
    var selected by remember { mutableStateOf(0) }
    var lesson by remember { mutableStateOf(false) }

    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Navy,
            secondary = Gold,
            background = Bg,
            surface = Color.White
        )
    ) {
        CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
            Scaffold(
                containerColor = Bg,
                bottomBar = {
                    NavigationBar(containerColor = Color.White) {
                        val labels = listOf("پروفایل", "سرفصل‌ها", "جستجو", "یادداشت‌ها", "خانه")
                        val icons = listOf(Icons.Default.Person, Icons.Default.MenuBook, Icons.Default.Search, Icons.Default.Bookmark, Icons.Default.Home)
                        labels.forEachIndexed { i, label ->
                            NavigationBarItem(
                                selected = selected == i,
                                onClick = { selected = i },
                                icon = { Icon(icons[i], null) },
                                label = { Text(label, fontSize = 11.sp) }
                            )
                        }
                    }
                }
            ) { padding ->
                if (lesson) {
                    LessonScreen(onBack = { lesson = false })
                } else {
                    when (selected) {
                        1 -> CategoriesScreen()
                        2 -> SearchScreen()
                        3 -> SavedScreen()
                        4 -> HomeScreen(onLesson = { lesson = true })
                        else -> HomeScreen(onLesson = { lesson = true })
                    }
                }
            }
        }
    }
}

@Composable
fun Header(title: String, back: (() -> Unit)? = null) {
    Row(
        modifier = Modifier.fillMaxWidth().background(Navy).padding(horizontal = 18.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (back != null) {
            IconButton(onClick = back) { Icon(Icons.Default.ArrowBack, null, tint = Color.White) }
        } else {
            IconButton(onClick = {}) { Icon(Icons.Default.Menu, null, tint = Color.White) }
        }
        Text(title, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        Icon(Icons.Default.NotificationsNone, null, tint = Color.White)
    }
}

@Composable
fun HomeScreen(onLesson: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 18.dp)
    ) {
        item {
            Header("تأسیسات با مهندس ناظری")
        }
        item {
            Spacer(Modifier.height(12.dp))
            Card(
                modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Column(Modifier.padding(18.dp)) {
                    Text("درس امروز", color = Navy, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(8.dp))
                    Text("شیر برقی آمونیاکی", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("اجزا، عملکرد و نکات سرویس و نگهداری", color = Color.Gray)
                    Spacer(Modifier.height(14.dp))
                    Box(
                        Modifier.fillMaxWidth().height(150.dp)
                            .background(
                                Brush.linearGradient(listOf(Color(0xFFEAF2FA), Color(0xFFFFF8E8))),
                                RoundedCornerShape(16.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Settings, null, tint = Gold, modifier = Modifier.size(90.dp))
                    }
                    Spacer(Modifier.height(14.dp))
                    Button(onClick = onLesson, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Gold)) {
                        Text("ادامه آموزش", color = Navy, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
        item {
            Spacer(Modifier.height(14.dp))
            Card(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(), shape = RoundedCornerShape(18.dp)) {
                Column(Modifier.padding(18.dp)) {
                    Text("پیشرفت کلی شما", fontWeight = FontWeight.Bold, fontSize = 17.sp)
                    Spacer(Modifier.height(10.dp))
                    LinearProgressIndicator(progress = { .36f }, modifier = Modifier.fillMaxWidth(), color = Gold)
                    Spacer(Modifier.height(8.dp))
                    Text("۳۶٪ تکمیل شده • ۵۶ درس • ۱۸ نکته ذخیره‌شده", color = Color.Gray)
                }
            }
        }
        item {
            Spacer(Modifier.height(14.dp))
            Text("دسترسی سریع", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(Modifier.height(8.dp))
        }
        item {
            Row(Modifier.fillMaxWidth().padding(horizontal = 12.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                QuickCard("ابزارها", Icons.Default.Build, Blue, Modifier.weight(1f))
                QuickCard("شیرآلات", Icons.Default.WaterDrop, Gold, Modifier.weight(1f))
                QuickCard("لوله و اتصالات", Icons.Default.Plagiarism, Green, Modifier.weight(1f))
                QuickCard("سردخانه آمونیاکی", Icons.Default.AcUnit, Navy, Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun QuickCard(text: String, icon: androidx.compose.ui.graphics.vector.ImageVector, color: Color, modifier: Modifier) {
    Card(modifier = modifier.height(105.dp), shape = RoundedCornerShape(16.dp)) {
        Column(Modifier.fillMaxSize().padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Icon(icon, null, tint = color, modifier = Modifier.size(34.dp))
            Spacer(Modifier.height(6.dp))
            Text(text, fontSize = 11.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun CategoriesScreen() {
    val cats = listOf(
        "ایمنی و مقررات" to Icons.Default.Security,
        "ابزار و تجهیزات" to Icons.Default.Build,
        "لوله و اتصالات" to Icons.Default.Plagiarism,
        "شیرآلات" to Icons.Default.WaterDrop,
        "آبرسانی ساختمان" to Icons.Default.Water,
        "فاضلاب ساختمان" to Icons.Default.Delete,
        "گرمایش و موتورخانه" to Icons.Default.LocalFireDepartment,
        "تهویه مطبوع" to Icons.Default.Air,
        "تبرید اصولی" to Icons.Default.AcUnit,
        "سردخانه آمونیاکی" to Icons.Default.Factory,
        "نگهداری و عیب‌یابی" to Icons.Default.Engineering,
        "نقشه‌خوانی و مدارک" to Icons.Default.Description
    )
    Column(Modifier.fillMaxSize()) {
        Header("سرفصل‌ها")
        LazyColumn(contentPadding = PaddingValues(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(cats) { (name, icon) ->
                Card(shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth().clickable {}) {
                    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(icon, null, tint = Blue, modifier = Modifier.size(34.dp))
                        Spacer(Modifier.width(14.dp))
                        Text(name, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                        Text("۱۲ درس", color = Color.Gray, fontSize = 12.sp)
                        Icon(Icons.Default.ChevronLeft, null, tint = Color.Gray)
                    }
                }
            }
        }
    }
}

@Composable
fun LessonScreen(onBack: () -> Unit) {
    Column(Modifier.fillMaxSize()) {
        Header("درس", onBack)
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            item {
                Text("شیر برقی آمونیاکی", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Navy)
                Spacer(Modifier.height(12.dp))
                Card(shape = RoundedCornerShape(20.dp)) {
                    Column(Modifier.padding(16.dp)) {
                        Box(
                            Modifier.fillMaxWidth().height(220.dp)
                                .background(
                                    Brush.linearGradient(listOf(Color(0xFFE9F1F8), Color(0xFFFFF7E7))),
                                    RoundedCornerShape(16.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Settings, null, tint = Gold, modifier = Modifier.size(120.dp))
                        }
                        Spacer(Modifier.height(16.dp))
                        Text("۱. معرفی", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text("شیر برقی برای کنترل خودکار جریان سیال در مدار استفاده می‌شود. در سیستم‌های تبرید آمونیاکی، انتخاب، نصب و سرویس آن باید با توجه به نوع مبرد و شرایط کاری انجام شود.")
                        Spacer(Modifier.height(12.dp))
                        LessonRow("۲. اجزا و قطعات")
                        LessonRow("۳. نحوه عملکرد")
                        LessonRow("۴. روش تست و عیب‌یابی")
                        LessonRow("۵. نکات نگهداری")
                        LessonRow("۶. نکات ایمنی")
                    }
                }
                Spacer(Modifier.height(14.dp))
                Button(onClick = {}, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Navy)) {
                    Text("آزمون این درس")
                }
            }
        }
    }
}

@Composable
fun LessonRow(text: String) {
    Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.KeyboardArrowDown, null, tint = Gold)
        Text(text, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun SearchScreen() {
    Column(Modifier.fillMaxSize()) {
        Header("جستجو")
        OutlinedTextField(
            value = "", onValueChange = {},
            placeholder = { Text("جستجو در درس‌ها، ابزارها و قطعات") },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            singleLine = true,
            leadingIcon = { Icon(Icons.Default.Search, null) }
        )
        Text("نتایج پیشنهادی", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(horizontal = 16.dp))
        SearchItem("اتو لوله (دستگاه جوش PP)", "ابزار و تجهیزات", Icons.Default.Build)
        SearchItem("لوله‌بُر", "ابزار و تجهیزات", Icons.Default.Build)
        SearchItem("شیر توپی", "شیرآلات", Icons.Default.WaterDrop)
        SearchItem("پمپ آمونیاکی", "سردخانه آمونیاکی", Icons.Default.Settings)
    }
}

@Composable
fun SearchItem(title: String, category: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Card(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 5.dp), shape = RoundedCornerShape(14.dp)) {
        Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null, tint = Blue, modifier = Modifier.size(38.dp))
            Spacer(Modifier.width(12.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold)
                Text(category, color = Blue, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun SavedScreen() {
    Column(Modifier.fillMaxSize()) {
        Header("یادداشت‌ها و ذخیره‌شده‌ها")
        Text("مطالب ذخیره‌شده شما اینجا نمایش داده می‌شوند.", modifier = Modifier.padding(20.dp), color = Color.Gray)
    }
}
