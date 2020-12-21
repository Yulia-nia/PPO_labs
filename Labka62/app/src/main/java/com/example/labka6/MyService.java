package com.example.labka6;
import android.app.Service;
import android.media.MediaPlayer;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.app.TaskStackBuilder;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;


public class MyService extends Service {
    MediaPlayer mediaPlayer;
    int time;
    SeekBar pos;
    @Nullable
    @Override public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        Intent resultIntent = new Intent(this, MainActivity.class);

        mediaPlayer = MediaPlayer.create(this, R.raw.explosion);
        mediaPlayer.setLooping(true);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_launcher_foreground)
                                                 .setContentTitle("My music").setContentText("Music");


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }
}
