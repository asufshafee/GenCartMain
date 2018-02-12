package b2infosoft.gencart.com.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.adapter.NotificationAdapter;


public class NotificationActivity extends AppCompatActivity {

    TextView toolbar_title;
    Toolbar toolbar;
    RecyclerView recycler_Notification;
    Context mContext;
    TextView tvNotificationDetails;
    private static final String TAG = NotificationActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        toolbar_title.setText("Notification");
        recycler_Notification = (RecyclerView) findViewById(R.id.recycler_Notification);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_Notification.setLayoutManager(linearLayoutManager);
        recycler_Notification.setHasFixedSize(true);
        ArrayList<String> mStoreListPojos = new ArrayList<>();
        NotificationAdapter mAdapter = new NotificationAdapter(getApplicationContext(), mStoreListPojos);
        recycler_Notification.setAdapter(mAdapter);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
