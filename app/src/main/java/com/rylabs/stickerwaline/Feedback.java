package com.rylabs.stickerwaline;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.firebase.client.Firebase;

public class Feedback extends BaseActivity {
    EditText namedata, emaildata, messagedata;
    Button send;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        namedata = findViewById(R.id.namedata);
        emaildata = findViewById(R.id.emaildata);
        messagedata = findViewById(R.id.messagedata);

        send = findViewById(R.id.btn_send);
        Firebase.setAndroidContext(this);

        String UniqueID =
        Settings.Secure.getString(getApplicationContext().getContentResolver(),
        Settings.Secure.ANDROID_ID);

        firebase = new Firebase("https://feedback-sticker.firebaseio.com/Users" + UniqueID);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = namedata.getText().toString();
                final String email = emaildata.getText().toString();
                final String message = messagedata.getText().toString();

                Firebase child_name = firebase.child("Name");
                child_name.setValue(name);
                if (name.isEmpty()) {
                    namedata.setError(getString(R.string.feedback_error));
                    send.setEnabled(false);
                } else {
                    namedata.setError(null);
                    send.setEnabled(true);
                }

                Firebase child_email = firebase.child("Email");
                child_email.setValue(email);
                if (email.isEmpty()) {
                    emaildata.setError(getString(R.string.feedback_error));
                    send.setEnabled(false);
                } else {
                    emaildata.setError(null);
                    send.setEnabled(true);
                }

                Firebase child_message = firebase.child("Message");
                child_message.setValue(message);
                if (message.isEmpty()) {
                    messagedata.setError(getString(R.string.feedback_error));
                    send.setEnabled(false);
                } else {
                    messagedata.setError(null);
                    send.setEnabled(true);
                }
                Toast.makeText(getApplicationContext(), getString(R.string.feedback_toast), Toast.LENGTH_LONG).show();

            }
        });
    }
}
