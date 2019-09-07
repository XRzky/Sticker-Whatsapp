package com.rylabs.stickerwaline;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        LinearLayout telegram = (LinearLayout) findViewById(R.id.telegram);
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://t.me/xrzky"));
                startActivity(intent);
            }
        });

        LinearLayout share = (LinearLayout) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent("android.intent.action.SEND");
                share.setType("text/plain");
                share.putExtra("android.intent.extra.TEXT", getString(R.string.share_text));
                startActivity(share);
            }
        });

        LinearLayout update = (LinearLayout) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent update = new Intent();
                update.setAction(Intent.ACTION_VIEW);
                update.addCategory(Intent.CATEGORY_BROWSABLE);
                update.setData(Uri.parse("https://bit.ly/2OnaA6R"));
                startActivity(update);
            }
        });

        LinearLayout contactus = (LinearLayout) findViewById(R.id.contact_us);
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "xvyctim7@email.com", null)));
            }
        });
    }

}
