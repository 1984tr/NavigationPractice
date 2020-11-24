package com.tr1984.navigationpractice.main

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tr1984.navigationpractice.R
import com.tr1984.navigationpractice.databinding.FragmentIntentBinding

class IntentFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return FragmentIntentBinding.inflate(inflater).apply {
            explicit.setOnClickListener {
                val context = context ?: return@setOnClickListener
                val pi = findNavController().createDeepLink()
                        .setDestination(R.id.popupFragment)
                        .createPendingIntent()
                showNotification(pi)
            }
            implicit.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("myapp://shop.mysto.re/popup?alert=deeplink")
                })
            }
        }.root
    }

    private fun showNotification(pi: PendingIntent) {
        val context = context ?: return
        val remoteView = RemoteViews(context.packageName, R.layout.notification_remote_view)
        val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("General", "General", NotificationManager.IMPORTANCE_MIN)
                    .apply {
                        description = "General notification"
                        lockscreenVisibility = Notification.VISIBILITY_PUBLIC
                    }
            notificationManager.createNotificationChannel(channel)
            NotificationCompat.Builder(context, "General")
        } else {
            NotificationCompat.Builder(context)
        }
        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContent(remoteView)
                .setContentIntent(pi)
        notificationManager.notify(1, builder.build())
    }
}