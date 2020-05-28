package by.tms.remind

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.date_layout.*
import java.util.*

    var years = 0
    var month = 0
    var day = 0


class DateActivity() : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.date_layout)

        date_picker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            years = year
            month = monthOfYear
            day = dayOfMonth
            val calendarNow = Calendar.getInstance()
            val calenderAlarm = Calendar.getInstance()
            calenderAlarm.set(Calendar.YEAR, years)
            calenderAlarm.set(Calendar.MONTH, month)
            calenderAlarm.set(Calendar.DAY_OF_MONTH, day)
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

            val intent = Intent(this, Notification::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 999, intent, 0)

            if (calenderAlarm.after(calendarNow)) {
                alarmManager.set(AlarmManager.RTC_WAKEUP, calenderAlarm.timeInMillis, pendingIntent)

            }

        }

    }
}