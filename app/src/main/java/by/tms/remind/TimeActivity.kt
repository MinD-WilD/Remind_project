package by.tms.remind

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.time_layout.*
import java.util.*


var hour = 0
    var minutes = 0

class TimeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.time_layout)



        time_picker.setIs24HourView(true)
        time_picker.setOnTimeChangedListener { view, hourOfDay, minute ->
            hour = hourOfDay
            minutes = minute
        }
        val calendarNow = Calendar.getInstance()
        val calenderAlarm = Calendar.getInstance()
        calenderAlarm.set(Calendar.HOUR_OF_DAY, hour)
        calenderAlarm.set(Calendar.MINUTE, minutes)
        calenderAlarm.set(Calendar.SECOND, 0)

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, Notification::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 999, intent, 0)

        if (calenderAlarm.after(calendarNow)) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calenderAlarm.timeInMillis, pendingIntent)
        }
    }
}
