package by.tms.remind


import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import androidx.core.app.JobIntentService


class SoundNotification : JobIntentService() {
   lateinit var soundNotification: Ringtone

    override fun onHandleWork(intent: Intent) {
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val soundNotificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val soundNotification = RingtoneManager.getRingtone(this, soundNotificationUri)
        val pendingIntent = PendingIntent.FLAG_CANCEL_CURRENT




        soundNotification.play()
        return Service.START_NOT_STICKY


    }

    override fun onDestroy() {
        soundNotification.stop()


    }
}
