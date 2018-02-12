package b2infosoft.gencart.com.activity;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import b2infosoft.gencart.com.R;
import b2infosoft.gencart.com.pojo.ChatListPojo;
import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {

    Context mContext;
    TextView toolbar_title;
    Toolbar toolbar;
    CircleImageView userImg;
    ScrollView scrollView;
    LinearLayout layout;
    EditText messageArea;
    LinearLayout sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mContext = ChatActivity.this;
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_semibold.ttf"));
        toolbar_title.setText("Amar");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        sendButton = (LinearLayout) findViewById(R.id.sendButton);
        messageArea = (EditText) findViewById(R.id.messageArea);
        messageArea.setTypeface(Typeface.createFromAsset(getAssets(), "font/raleway_regular.ttf"));

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        layout = (LinearLayout) findViewById(R.id.layout1);
        ArrayList<ChatListPojo> mListPojos = new ArrayList<>();
        mListPojos.add(new ChatListPojo("Hello", 1));
        mListPojos.add(new ChatListPojo("Hi, How Are You men", 0));
        mListPojos.add(new ChatListPojo("What's going men..?", 0));
        mListPojos.add(new ChatListPojo("I'm Fine...", 1));
        mListPojos.add(new ChatListPojo("What r u doing..?", 1));
        mListPojos.add(new ChatListPojo("nothing men...it's fun for new year", 0));
        mListPojos.add(new ChatListPojo("hehehehehe", 0));
        mListPojos.add(new ChatListPojo("hehehehehe", 1));
        for (int i = 0; i < mListPojos.size(); i++) {
            addMessageBox(mListPojos.get(i).msg, mListPojos.get(i).type);
        }

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String messageText = messageArea.getText().toString().trim();
                if (!messageText.equals("")) {
                    addMessageBox(messageText, 1);
                    messageArea.setText("");
                }
            }
        });

    }

    public void addMessageBox(String message, int type) {

        View descriptionLayout;
        TextView textView;
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp2.weight = 1.0f;
        if (type != 1) {
            LayoutInflater inflater = getLayoutInflater();
            descriptionLayout = inflater.inflate(R.layout.item_chat_left, null, false);
            textView = (TextView) descriptionLayout.findViewById(R.id.text_msg);
            textView.setText(message);
            userImg = (CircleImageView) descriptionLayout.findViewById(R.id.userImg);//userImg
            //Log.d("imgPath>>>", imgPath);
            //Glide.with(getApplicationContext()).load(imgPath).error(R.drawable.default_user).into(userImg);
            lp2.gravity = Gravity.LEFT;
        } else {
            LayoutInflater inflater = getLayoutInflater();
            descriptionLayout = inflater.inflate(R.layout.item_chat_right, null, false);
            textView = (TextView) descriptionLayout.findViewById(R.id.text_msg);
            userImg = (CircleImageView) descriptionLayout.findViewById(R.id.userImgright);//userImg
            textView.setText(message);
            lp2.gravity = Gravity.RIGHT;
        }
        layout.addView(descriptionLayout);
        scrollView.post(new Runnable() {
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}
