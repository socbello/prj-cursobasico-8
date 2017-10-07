package com.sbello.sbctictactoe;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import static android.graphics.Color.parseColor;


public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.PvPmode).setOnClickListener(this);
        findViewById(R.id.exitButton).setOnClickListener(this);

        ActionBar myActionBar = getSupportActionBar();
        if (myActionBar != null) {
            myActionBar.setDisplayShowTitleEnabled(false);
            myActionBar.setDisplayShowCustomEnabled(true);
            @SuppressLint("InflateParams") View appTitle = getLayoutInflater().inflate(R.layout.app_title, null);
            myActionBar.setBackgroundDrawable(new ColorDrawable(parseColor("#000000")));
            myActionBar.setCustomView(appTitle);
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.PvPmode:
                intent = new Intent(MainActivity.this, PvpModeActivity.class);
                break;
            case R.id.exitButton:

                AlertDialog alert = new AlertDialog.Builder(this)
                        .setTitle("Tic Tac Toe")
                        .setMessage("Do you want to exit the game?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Good Bye! Thanks for playing!", Toast.LENGTH_SHORT).show();
                                finish();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Sweet!!! Let's keep playing!", Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alert.show();
                break;
            case R.id.imageLogo:
                intent = new Intent(MainActivity.this, PvpModeActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
