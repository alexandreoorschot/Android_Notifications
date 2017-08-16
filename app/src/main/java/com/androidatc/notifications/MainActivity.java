package com.androidatc.notifications;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.app.RemoteInput;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private CharSequence mTitle;
    private Button btnMaxPriorityNotification;
    private Button btnHighPriorityNotification;
    private Button btnDefaultPriorityNotification;
    private Button btnLowPriorityNotification;
    private Button btnMinPriorityNotification;
    private Button btnDefaultNotification;
    private Button btnOldTypeNotification;
    private Button btnBigTextNotification;
    private Button btnBigImageNotification;
    private Button btnInboxTypeNotification;
    private Button btnNougatNotification;
    private static final String KEY_TEXT_REPLY = "key_text_reply";
    private int NOTIF_REF = 1;
    private NotificationManager manager;
    private int count = 1;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        btnMaxPriorityNotification = (Button) findViewById(R.id.btnMaxPriorityNotification);
        btnHighPriorityNotification = (Button) findViewById(R.id.btnHighPriorityNotification);
        btnDefaultPriorityNotification = (Button) findViewById(R.id.btnDefaultNotification);
        btnLowPriorityNotification = (Button) findViewById(R.id.btnLowPriorityNotification);
        btnMinPriorityNotification = (Button) findViewById(R.id.btnMinPriorityNotification);
        btnDefaultNotification = (Button) findViewById(R.id.btnDefaultNotification);
        btnOldTypeNotification = (Button) findViewById(R.id.btnOldTypeNotification);
        btnBigTextNotification = (Button) findViewById(R.id.btnBigTextNotification);
        btnBigImageNotification = (Button) findViewById(R.id.btnBigImageNotification);
        btnInboxTypeNotification = (Button) findViewById(R.id.btnInboxTypeNotification);
        btnNougatNotification = (Button) findViewById(R.id.btnNougatNotification);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        btnMaxPriorityNotification.setOnClickListener(MainActivity.this);
        btnHighPriorityNotification.setOnClickListener(MainActivity.this);
        btnDefaultPriorityNotification.setOnClickListener(MainActivity.this);
        btnLowPriorityNotification.setOnClickListener(MainActivity.this);
        btnDefaultNotification.setOnClickListener(MainActivity.this);
        btnOldTypeNotification.setOnClickListener(MainActivity.this);
        btnBigTextNotification.setOnClickListener(MainActivity.this);
        btnBigImageNotification.setOnClickListener(MainActivity.this);
        btnInboxTypeNotification.setOnClickListener(MainActivity.this);
        btnMinPriorityNotification.setOnClickListener(MainActivity.this);
        btnNougatNotification.setOnClickListener(MainActivity.this);
        handleNotification(getIntent());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        Notification notif = null;
        Notification.Builder builder = new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setWhen(System.currentTimeMillis()).setContentText("Android Notifications");
        switch (v.getId()) {
            case R.id.btnMaxPriorityNotification:
                builder.setContentTitle("Maximum Priority Notification").setPriority(Notification.PRIORITY_MAX);
                sendNotification(builder.build());
                break;
            case R.id.btnHighPriorityNotification:
                builder.setContentTitle("High Priority Notification").setPriority(Notification.PRIORITY_HIGH);
                sendNotification(builder.build());
                break;
            case R.id.btnLowPriorityNotification:
                builder.setContentTitle("Low Priority Notification").setPriority(Notification.PRIORITY_LOW);
                sendNotification(builder.build());
                break;
            case R.id.btnMinPriorityNotification:
                builder.setContentTitle("Minimum Priority Notification").setPriority(Notification.PRIORITY_MIN);
                sendNotification(builder.build());
                break;
            case R.id.btnDefaultNotification:
                builder.setContentTitle("Default Priority Notification").setPriority(Notification.PRIORITY_DEFAULT);
                sendNotification(builder.build());
                break;
            case R.id.btnOldTypeNotification:
                notif = getOldStyleNotification(builder);
                sendNotification(notif);
                break;
            case R.id.btnBigTextNotification:
                notif = getBigTextStyle(builder);
                sendNotification(notif);
                break;
            case R.id.btnBigImageNotification:
                notif = getBigPictureStyle(builder);
                sendNotification(notif);
                break;
            case R.id.btnInboxTypeNotification:
                notif = getInboxStyleNotification(builder);
                sendNotification(notif);
                break;
            case R.id.btnNougatNotification:
                notif = getNougatStyleNotification(builder);
                manager.notify(0123, notif);
                break;
        }
    }

    public void sendNotification(Notification notif) {
        manager.notify(NOTIF_REF++, notif);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private Notification getBigPictureStyle(Notification.Builder builder) {
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(), R.drawable.big_image);

        return new Notification.Builder(MainActivity.this).setContentTitle("Reduced BigPicture title").setContentText("Reduced Content").setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(icon).setStyle(new Notification.BigPictureStyle().bigPicture(icon)).build();
    }

    private Notification getBigTextStyle(Notification.Builder builder) {
        return new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("big text").setContentText("Android ATC has its main objective...").setDefaults(Notification.DEFAULT_ALL).setStyle(new NotificationCompat.BigTextStyle().bigText(getString(R.string.summary_text))).build();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private Notification getInboxStyleNotification(Notification.Builder builder) {
        return new Notification.Builder(this).setContentTitle("2 new mails").setContentText("Android ATC Update").setSmallIcon(R.mipmap.ic_launcher).setStyle(new Notification.InboxStyle().addLine("Android ATC Update").addLine("new android opportunities").setSummaryText("+1 more")).build();
    }

    private Notification getOldStyleNotification(Notification.Builder builder) {
        return new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("My old notification").setContentText("hello from android atc!").build();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    private Notification getNougatStyleNotification(Notification.Builder builder) {
        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY).setLabel("").build();
        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Action action = new Notification.Action.Builder(R.mipmap.ic_launcher, "Reply...", resultPendingIntent).addRemoteInput(remoteInput).build();
        return new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("Billy Wonka").setContentText("hey, want to go for a dinner tonight?").addAction(action).build();
    }


    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    public void handleNotification(Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (getMessageText(intent) != null) {
            Notification repliedNotification = new Notification.Builder(this).setSmallIcon(R.mipmap.ic_launcher).setContentText("your reply has been submitted successfully").build();
            manager.notify(0123, repliedNotification);
        }
    }


    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    private CharSequence getMessageText(Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            return remoteInput.getCharSequence(KEY_TEXT_REPLY);

        }
        return null;
    }
}




























