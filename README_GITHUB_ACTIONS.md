# تأسیسات با مهندس ناظری — GitHub Actions APK Builder

این نسخه برای ساخت APK در GitHub Actions آماده شده است.

## ساخت APK بدون Android Studio

1. یک Repository جدید در GitHub بساز.
2. همه فایل‌های این پوشه را داخل Repository قرار بده.
3. از GitHub وارد تب **Actions** شو.
4. Workflow با نام **Build Android APK** را انتخاب کن.
5. روی **Run workflow** بزن.
6. بعد از اتمام Build، وارد اجرای موفق Workflow شو.
7. در بخش **Artifacts** فایل `Tasisat-Mohandes-Nazari-debug-apk` را دانلود کن.
8. فایل ZIP دانلودشده را باز کن و `app-debug.apk` را روی گوشی نصب کن.

## نکته
این APK نسخه Debug و برای تست است. برای انتشار عمومی در Google Play یا نصب حرفه‌ای، بعداً باید نسخه Release را با keystore اختصاصی امضا کنیم.

Workflow از JDK 17، Android SDK 35 و Gradle 8.7 استفاده می‌کند.
