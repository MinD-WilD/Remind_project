package by.tms.remind



import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      }

    fun onDate(view: View) {
        val dateIntent = Intent(this, DateActivity::class.java)
        startActivity(dateIntent)
    }
    fun onTime(view: View) {
        val timeIntent = Intent(this, TimeActivity::class.java)
        startActivity(timeIntent)
    }

    fun onStartWork(view: View) {
        val calendarNow = Calendar.getInstance()
        val calenderAlarm = Calendar.getInstance()
        calenderAlarm.set(Calendar.YEAR, years)
        calenderAlarm.set(Calendar.MONTH, month)
        calenderAlarm.set(Calendar.DAY_OF_MONTH, day)
        calenderAlarm.set(Calendar.HOUR_OF_DAY, hour)
        calenderAlarm.set(Calendar.MINUTE, minutes)
        calenderAlarm.set(Calendar.SECOND, 0)

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, Notification::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 999, intent, 0)

        if (calenderAlarm.after(calendarNow)) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calenderAlarm.timeInMillis, pendingIntent)

        }


        Toast.makeText(this, "Напоминалка начала работу", Toast.LENGTH_SHORT).show()
    }


}

