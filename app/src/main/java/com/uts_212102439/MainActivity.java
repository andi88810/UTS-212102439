package com.uts_212102439;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button _kirimButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initKirimButton();
    }
    private void initKirimButton(){
        _kirimButton = findViewById(R.id.kirimButton);
        _kirimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationChannel channel = new NotificationChannel("twChannel","TW",
                        NotificationManager.IMPORTANCE_DEFAULT);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Nama:Andi Chia")
                        .setContentText("NIM: 212102439")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setChannelId(channel.getId());

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel);
                manager.notify(1,builder.build());

            }
        });
    }
}