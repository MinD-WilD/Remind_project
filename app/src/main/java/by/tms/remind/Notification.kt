package by.tms.remind

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


const val NOTIFICATION = "NOTIFICATION"


class Notification : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val intentFirst = Intent(context, MainActivity::class.java)
        val intentSecond = PendingIntent.getActivity(context, 0, intentFirst, 0)
        val deleteIntent = Intent(context, SoundNotification::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, deleteIntent,
            PendingIntent.FLAG_CANCEL_CURRENT)




        val deletePendingIntent = PendingIntent.getActivity(context, 0, deleteIntent, 0)
        val notificationBuilder = context?.let {
            NotificationCompat.Builder(it, NOTIFICATION)
                .setSmallIcon(R.drawable.remind_icon)
                .setContentTitle("Время пришло")
                .setContentText("Пора за дело")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(intentSecond)
                .setDeleteIntent(deletePendingIntent)
                .addAction(R.drawable.close_button, "Закрыть", pendingIntent)
                .setAutoCancel(true)




        }
        val notificationManager = context?.let { NotificationManagerCompat.from(it) }
        notificationBuilder?.build()?.let { notificationManager?.notify(999, it) }




        val ringtone = Intent(context, SoundNotification::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            context?.startForegroundService(ringtone)
            context?.startForegroundService(Intent(intentFirst))



        }else{
            context?.startService(ringtone)
        }
    }

}

