package com.serviingo.serviingo.Firebasee;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.serviingo.serviingo.Activity.HomeActivity;
import com.serviingo.serviingo.Activity.Rating.RatingActivity;
import com.serviingo.serviingo.R;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;

public class MyFirebaseService extends FirebaseMessagingService {
    public static int NOTIFICATION_ID = 1;
    private static final String TAG = "FirebaseMessagingServic";
    String GROUP_KEY_WORK_EMAIL = "com.serviingo.serviingo";
    Intent intent;
    @Override
    public void onNewToken(String s) {

        Log.e("NEW_TOKEN", s);

    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        Log.d(TAG, " Notificationnnn " + "\n Body    ----- " + remoteMessage.getNotification().getBody() + "\n Title---" +
                remoteMessage.getNotification().getTitle() );

        Log.d(TAG, " data size: " + remoteMessage.getData().size());


        if (remoteMessage.getData() != null) {
            Log.d(TAG, "Message data payload: ");

         sendnotification(remoteMessage);

        } /*else {
            if (remoteMessage.getNotification() != null) {


                generateNotification(
                        remoteMessage.getNotification().getBody(),
                        remoteMessage.getNotification().getTitle(),
                        remoteMessage.getNotification().getImageUrl()
                );

            }

        }
*/

    }

    private void sendnotification(RemoteMessage remoteMessage) {

        Map<String, String> data = remoteMessage.getData();
        String title = data.get("title").toString();
        String des = data.get("text").toString();;
        String type = data.get("type").toString();;
        String id= data.get("id").toString();;
        Log.d(TAG, "remoteMessage: data " + title + "\n" + des + "\n"+type+"\n"+id );





        if (type.equalsIgnoreCase("order-complete")){
            intent = new Intent(this, RatingActivity.class);
            intent.putExtra("id", id);

        }

        //  intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent
                , PendingIntent.FLAG_CANCEL_CURRENT);


        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notifcationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle(title)
                .setContentText(des)
                .setSound(alarmSound)

                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[]{1000, 1000})
                .setLights(Color.RED, 3000, 3000)
                .setAutoCancel(true)
                .setGroup(GROUP_KEY_WORK_EMAIL)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (NOTIFICATION_ID > 1073741824) {
            NOTIFICATION_ID = 0;
        }
        notificationManager.notify(NOTIFICATION_ID++, notifcationBuilder.build());

        startForeground(NOTIFICATION_ID++, notifcationBuilder.build());


    }

    private void generateNotification(String body, String title, Uri url) {


        Log.d(TAG, "remoteMessage notification: " + title + "\n" + title + "\n" + url);

        String stringUri = url.toString();

        Bitmap bit = null;
        try {
            bit = BitmapFactory.decodeStream((InputStream) new URL(stringUri).getContent());

        } catch (Exception e) {
        }

        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("page", "home");
        intent.putExtra("title", title);
        intent.putExtra("image", stringUri);
        intent.putExtra("desc", body);


        //  intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent
                , PendingIntent.FLAG_CANCEL_CURRENT);


        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notifcationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle(title)
                .setContentText(body)
                .setLargeIcon(bit)
                .setSound(alarmSound)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[]{1000, 1000})
                .setLights(Color.RED, 3000, 3000)
                .setAutoCancel(true)
                .setGroup(GROUP_KEY_WORK_EMAIL)

                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (NOTIFICATION_ID > 1073741824) {
            NOTIFICATION_ID = 0;
        }
        notificationManager.notify(NOTIFICATION_ID++, notifcationBuilder.build());

        startForeground(NOTIFICATION_ID++, notifcationBuilder.build());


    }

}