package ir.tasisat.mohandesnazari

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                TasisatApp()
            }
        }
    }
}


/* ---------------------------------------------------------
   DATA
--------------------------------------------------------- */

data class Lesson(
    val title: String,
    val subtitle: String,
    val icon: String,
    val content: String
)


val lessons = listOf(

    Lesson(
        title = "ابزارهای پایه تأسیسات",
        subtitle = "آشنایی با ابزارهای ضروری کار تأسیسات",
        icon = "🔧",
        content = """
ابزارهای پایه تأسیسات

در کارهای تأسیساتی شناخت ابزار مناسب اهمیت زیادی دارد.

ابزارهای پرکاربرد:

• آچار فرانسه
• آچار تخت و رینگی
• آچار لوله‌گیر
• انبردست
• سیم‌چین
• پیچ‌گوشتی
• متر
• تراز
• آچار آلن
• ابزارهای اندازه‌گیری

نکته مهم:

قبل از استفاده از هر ابزار، ابتدا کاربرد صحیح آن را یاد بگیرید.

استفاده از ابزار نامناسب می‌تواند باعث آسیب به قطعه، ابزار یا خود فرد شود.
        """.trimIndent()
    ),

    Lesson(
        title = "شناخت انواع شیرها",
        subtitle = "شیرهای مورد استفاده در سیستم‌های تأسیساتی",
        icon = "🚰",
        content = """
شناخت انواع شیرها

شیرها برای کنترل، قطع، تنظیم و هدایت جریان سیال استفاده می‌شوند.

انواع متداول:

• شیر توپی (Ball Valve)
• شیر پروانه‌ای (Butterfly Valve)
• شیر کشویی (Gate Valve)
• شیر سوزنی (Needle Valve)
• شیر یک‌طرفه (Check Valve)
• شیر برقی (Solenoid Valve)
• شیر اطمینان (Safety Valve)

شیر برقی:

با استفاده از یک بوبین الکتریکی باز و بسته شدن مسیر سیال را کنترل می‌کند.

شیر یک‌طرفه:

برای جلوگیری از برگشت جریان استفاده می‌شود.
        """.trimIndent()
    ),

    Lesson(
        title = "انواع لوله و اتصالات",
        subtitle = "شناخت لوله‌ها و روش اتصال آن‌ها",
        icon = "🔩",
        content = """
انواع لوله و اتصالات

لوله‌ها بر اساس جنس، فشار کاری، دما و نوع سیال انتخاب می‌شوند.

نمونه‌های رایج:

• لوله فولادی
• لوله مسی
• لوله گالوانیزه
• لوله پلی‌اتیلن
• لوله PVC
• لوله‌های پنج‌لایه

اتصالات:

• زانویی
• سه‌راهی
• تبدیل
• بوشن
• مهره ماسوره
• فلنج
• نیپل

در انتخاب لوله باید فشار، دما و نوع سیال سیستم در نظر گرفته شود.
        """.trimIndent()
    ),

    Lesson(
        title = "اتصالات لوله",
        subtitle = "روش شناخت و کاربرد اتصالات",
        icon = "🧰",
        content = """
اتصالات لوله

اتصالات برای تغییر مسیر، انشعاب، تغییر قطر یا اتصال دو بخش از سیستم استفاده می‌شوند.

زانویی:

برای تغییر جهت مسیر لوله استفاده می‌شود.

سه‌راهی:

برای ایجاد انشعاب در مسیر استفاده می‌شود.

تبدیل:

برای اتصال دو لوله با قطر متفاوت استفاده می‌شود.

فلنج:

برای اتصال قابل باز شدن لوله‌ها و تجهیزات به یکدیگر کاربرد دارد.
        """.trimIndent()
    ),

    Lesson(
        title = "اصول ایمنی در موتورخانه",
        subtitle = "نکات مهم قبل و هنگام کار",
        icon = "⚠️",
        content = """
اصول ایمنی در موتورخانه

قبل از شروع کار:

• وضعیت سیستم را بررسی کنید.
• تجهیزات حفاظتی مناسب استفاده کنید.
• مسیرهای دسترسی را بررسی کنید.
• فشار و دمای سیستم را کنترل کنید.
• در صورت نیاز سیستم را از مدار خارج کنید.

تجهیزات حفاظت فردی:

• کفش ایمنی
• دستکش مناسب
• عینک ایمنی
• لباس کار
• محافظ شنوایی در محیط‌های پرصدا

هرگز بدون شناخت سیستم، شیر یا تجهیزی را باز و بسته نکنید.
        """.trimIndent()
    ),

    Lesson(
        title = "آشنایی با سیستم تبرید آمونیاکی",
        subtitle = "مفاهیم پایه سیکل تبرید NH₃",
        icon = "❄️",
        content = """
سیستم تبرید آمونیاکی

آمونیاک با نام NH₃ یکی از مبردهای مورد استفاده در سیستم‌های تبرید صنعتی است.

اجزای اصلی سیستم:

• کمپرسور
• کندانسور
• منبع یا رسیور
• شیرهای کنترلی
• شیر انبساط
• اواپراتور
• تجهیزات جداسازی و کنترل جریان

فرآیند کلی:

1. مبرد در اواپراتور گرما را از محیط جذب می‌کند.
2. بخار مبرد به سمت کمپرسور حرکت می‌کند.
3. کمپرسور فشار مبرد را افزایش می‌دهد.
4. مبرد داغ وارد بخش تقطیر و کندانسور می‌شود.
5. مبرد پس از تقطیر به حالت مایع برمی‌گردد.
6. پس از افت فشار، دوباره وارد مدار تبخیر می‌شود.

نکته ایمنی:

آمونیاک ماده‌ای خطرناک است و کار با آن باید توسط افراد آموزش‌دیده و با تجهیزات حفاظت مناسب انجام شود.
        """.trimIndent()
    ),

    Lesson(
        title = "کمپرسورهای تبرید",
        subtitle = "وظیفه و عملکرد کمپرسور",
        icon = "⚙️",
        content = """
کمپرسور تبرید

کمپرسور وظیفه فشرده کردن بخار مبرد و ایجاد اختلاف فشار لازم برای گردش مبرد در سیستم را دارد.

وظایف اصلی:

• مکش بخار مبرد
• افزایش فشار
• افزایش دمای گاز
• ارسال گاز به سمت کندانسور

در سیستم‌های صنعتی آمونیاکی از کمپرسورهای مختلفی استفاده می‌شود.

قبل از تعمیر یا باز کردن کمپرسور باید وضعیت فشار، دما و ایمنی سیستم بررسی شود.
        """.trimIndent()
    ),

    Lesson(
        title = "کندانسور",
        subtitle = "آشنایی با وظیفه کندانسور در سیکل",
        icon = "🌡️",
        content = """
کندانسور

کندانسور وظیفه دفع حرارت مبرد و تبدیل بخار داغ مبرد به مایع را دارد.

مراحل:

1. ورود بخار داغ از کمپرسور
2. انتقال حرارت به محیط خنک‌کننده
3. کاهش دمای مبرد
4. تبدیل بخار به مایع
5. خروج مبرد مایع

کندانسورها می‌توانند به روش‌های مختلفی خنک شوند.

از جمله:

• هواخنک
• آب‌خنک
• تبخیری
        """.trimIndent()
    ),

    Lesson(
        title = "اواپراتور",
        subtitle = "وظیفه اواپراتور در سیستم تبرید",
        icon = "❄️",
        content = """
اواپراتور

اواپراتور بخشی از سیستم است که در آن مبرد گرمای محیط را جذب می‌کند.

در این بخش:

• مبرد وارد اواپراتور می‌شود.
• گرمای محیط را جذب می‌کند.
• مبرد تبخیر می‌شود.
• بخار مبرد به سمت کمپرسور برمی‌گردد.

در سردخانه‌ها انتخاب ظرفیت مناسب اواپراتور اهمیت زیادی دارد.
        """.trimIndent()
    ),

    Lesson(
        title = "شیر انبساط",
        subtitle = "کنترل جریان و افت فشار مبرد",
        icon = "🔵",
        content = """
شیر انبساط

شیر انبساط وظیفه کنترل جریان مبرد به سمت اواپراتور را دارد.

با عبور مبرد از شیر:

• فشار کاهش پیدا می‌کند.
• شرایط مبرد برای ورود به اواپراتور فراهم می‌شود.
• مقدار مبرد ورودی کنترل می‌شود.

نوع شیر و روش کنترل آن به طراحی سیستم بستگی دارد.
        """.trimIndent()
    )
)


/* ---------------------------------------------------------
   MAIN APP
--------------------------------------------------------- */

@Composable
fun TasisatApp() {

    var selectedTab by remember {
        mutableIntStateOf(0)
    }

    var selectedLesson by remember {
        mutableStateOf<Lesson?>(null)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        if (selectedLesson != null) {

            LessonDetailScreen(
                lesson = selectedLesson!!,
                onBack = {
                    selectedLesson = null
                }
            )

        } else {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {

                    when (selectedTab) {

                        0 -> HomeScreen(
                            onLessonClick = {
                                selectedLesson = it
                            }
                        )

                        1 -> TopicsScreen(
                            onLessonClick = {
                                selectedLesson = it
                            }
                        )

                        2 -> SettingsScreen()

                    }
                }

                BottomNavigationBar(
                    selectedTab = selectedTab,
                    onTabSelected = {
                        selectedTab = it
                    }
                )
            }
        }
    }
}


/* ---------------------------------------------------------
   HOME
--------------------------------------------------------- */

@Composable
fun HomeScreen(
    onLessonClick: (Lesson) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "تأسیسات با مهندس ناظری",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "آموزش کاربردی تأسیسات",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(18.dp))
        }

        item {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "آموزش امروز",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "قبل از کار با هر ابزار یا تجهیز تأسیساتی، ابتدا کاربرد و روش صحیح استفاده از آن را یاد بگیرید.",
                        fontSize = 16.sp,
                        lineHeight = 25.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
        }

        item {

            Text(
                text = "ادامه مسیر یادگیری",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        items(lessons.take(6)) { lesson ->

            LessonCard(
                lesson = lesson,
                onClick = {
                    onLessonClick(lesson)
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


/* ---------------------------------------------------------
   TOPICS
--------------------------------------------------------- */

@Composable
fun TopicsScreen(
    onLessonClick: (Lesson) -> Unit
) {

    var searchText by remember {
        mutableStateOf("")
    }

    val filteredLessons = lessons.filter {

        it.title.contains(
            searchText,
            ignoreCase = true
        ) ||
                it.subtitle.contains(
                    searchText,
                    ignoreCase = true
                )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp)
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "موضوعات آموزشی",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = {
                Text("جستجوی موضوع")
            },
            placeholder = {
                Text("مثلاً شیر، کمپرسور، لوله...")
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(filteredLessons) { lesson ->

                LessonCard(
                    lesson = lesson,
                    onClick = {
                        onLessonClick(lesson)
                    }
                )
            }

            if (filteredLessons.isEmpty()) {

                item {

                    Text(
                        text = "موضوعی پیدا نشد.",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


/* ---------------------------------------------------------
   LESSON CARD
--------------------------------------------------------- */

@Composable
fun LessonCard(
    lesson: Lesson,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(17.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = lesson.icon,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = lesson.title,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = lesson.subtitle,
                    fontSize = 14.sp
                )
            }

            Text(
                text = "‹",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


/* ---------------------------------------------------------
   DETAIL SCREEN
--------------------------------------------------------- */

@Composable
fun LessonDetailScreen(
    lesson: Lesson,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.primaryContainer
                )
                .padding(
                    horizontal = 12.dp,
                    vertical = 10.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextButton(
                onClick = onBack
            ) {

                Text(
                    text = "بازگشت",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = lesson.title,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = lesson.icon,
                fontSize = 25.sp
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            item {

                Text(
                    text = lesson.title,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Right,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = lesson.subtitle,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Right,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor =
                            MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {

                    Text(
                        text = lesson.content,
                        modifier = Modifier.padding(20.dp),
                        textAlign = TextAlign.Right,
                        fontSize = 17.sp,
                        lineHeight = 30.sp
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = "بازگشت به موضوعات"
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}


/* ---------------------------------------------------------
   SETTINGS
--------------------------------------------------------- */

@Composable
fun SettingsScreen() {

    var notificationsEnabled by remember {
        mutableStateOf(true)
    }

    var darkModeEnabled by remember {
        mutableStateOf(false)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp)
    ) {

        item {

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "تنظیمات",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {

            SettingCard(
                title = "اعلان‌های آموزشی",
                description = "دریافت یادآوری برای ادامه آموزش",
                value = notificationsEnabled,
                onClick = {
                    notificationsEnabled = !notificationsEnabled
                }
            )
        }

        item {

            Spacer(modifier = Modifier.height(12.dp))

            SettingCard(
                title = "حالت تاریک",
                description = "فعال‌سازی ظاهر تیره برنامه",
                value = darkModeEnabled,
                onClick = {
                    darkModeEnabled = !darkModeEnabled
                }
            )
        }

        item {

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "درباره برنامه",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "تأسیسات با مهندس ناظری",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "نسخه 1.0",
                        fontSize = 14.sp
                    )
                }
            }
        }

        item {

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "نام انگلیسی صحیح پروژه: Nazeri",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}


/* ---------------------------------------------------------
   SETTING CARD
--------------------------------------------------------- */

@Composable
fun SettingCard(
    title: String,
    description: String,
    value: Boolean,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(17.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = description,
                    fontSize = 14.sp
                )
            }

            Text(
                text = if (value) "فعال" else "خاموش",
                fontWeight = FontWeight.Bold
            )
        }
    }
}


/* ---------------------------------------------------------
   BOTTOM NAVIGATION
--------------------------------------------------------- */

@Composable
fun BottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    ) {

        Divider()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            NavigationItem(
                title = "آموزش",
                selected = selectedTab == 0,
                modifier = Modifier.weight(1f),
                onClick = {
                    onTabSelected(0)
                }
            )

            NavigationItem(
                title = "موضوعات",
                selected = selectedTab == 1,
                modifier = Modifier.weight(1f),
                onClick = {
                    onTabSelected(1)
                }
            )

            NavigationItem(
                title = "تنظیمات",
                selected = selectedTab == 2,
                modifier = Modifier.weight(1f),
                onClick = {
                    onTabSelected(2)
                }
            )
        }
    }
}


/* ---------------------------------------------------------
   NAVIGATION ITEM
--------------------------------------------------------- */

@Composable
fun NavigationItem(
    title: String,
    selected: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(
                if (selected)
                    MaterialTheme.colorScheme.primaryContainer
                else
                    MaterialTheme.colorScheme.background
            )
            .clickable {
                onClick()
            }
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = if (selected)
                FontWeight.Bold
            else
                FontWeight.Normal
        )
    }
}
