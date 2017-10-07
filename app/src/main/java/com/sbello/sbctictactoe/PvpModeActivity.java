package com.sbello.sbctictactoe;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PvpModeActivity extends AppCompatActivity {
    private int[][] myTable;
    private boolean playerXMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp_mode);

        ActionBar myActionBar = getSupportActionBar();
        if (myActionBar != null) {
            myActionBar.setDisplayShowTitleEnabled(false);
            myActionBar.setDisplayShowCustomEnabled(true);
            @SuppressLint("InflateParams") View appTitle = getLayoutInflater().inflate(R.layout.app_title, null);
            myActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
            myActionBar.setCustomView(appTitle);
        }
        myTable = new int[3][3];
        playerXMove = true;

    }

    public void myResetPressed(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.resetButton:
                AlertDialog alert = new AlertDialog.Builder(this)
                        .setTitle("Tic Tac Toe")
                        .setMessage("Do you want to reset the game?")
                        .setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(PvpModeActivity.this, "Let's play again!", Toast.LENGTH_SHORT).show();
                                        myTable = new int[3][3];
                                        Button button1 = (Button) findViewById(R.id.myButton1);
                                        Button button2 = (Button) findViewById(R.id.myButton2);
                                        Button button3 = (Button) findViewById(R.id.myButton3);
                                        Button button4 = (Button) findViewById(R.id.myButton4);
                                        Button button5 = (Button) findViewById(R.id.myButton5);
                                        Button button6 = (Button) findViewById(R.id.myButton6);
                                        Button button7 = (Button) findViewById(R.id.myButton7);
                                        Button button8 = (Button) findViewById(R.id.myButton8);
                                        Button button9 = (Button) findViewById(R.id.myButton9);
                                        TextView label = (TextView) findViewById(R.id.myGameStatusText);

                                        button1.setText("");
                                        button2.setText("");
                                        button3.setText("");
                                        button4.setText("");
                                        button5.setText("");
                                        button6.setText("");
                                        button7.setText("");
                                        button8.setText("");
                                        button9.setText("");
                                        label.setText("Player X starts");
                                    }
                                }
                        )
                        .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(PvpModeActivity.this, "Thanks for playing!", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).create();
                alert.show();
                break;
        }
    }

    public void myButtonPressed(View v) {
        int x = 0;
        int y = 0;

        int id = v.getId();
        switch (id) {
            case R.id.myButton1:
                break;
            case R.id.myButton2:
                x = 0;
                y = 1;
                break;
            case R.id.myButton3:
                x = 0;
                y = 2;
                break;
            case R.id.myButton4:
                x = 1;
                y = 0;
                break;
            case R.id.myButton5:
                x = 1;
                y = 1;
                break;
            case R.id.myButton6:
                x = 1;
                y = 2;
                break;
            case R.id.myButton7:
                x = 2;
                y = 0;
                break;
            case R.id.myButton8:
                x = 2;
                y = 1;
                break;
            case R.id.myButton9:
                x = 2;
                y = 2;
                break;
        }

        if (myTable[x][y] != 0) {
            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("Tic Tac Toe")
                    .setMessage("This cell is not empty!")
                    .setCancelable(true)
                    .create();
            alert.show();
            return;
        }

        Button btn = (Button) findViewById(id);
        TextView label = (TextView) findViewById(R.id.myGameStatusText);
        if (playerXMove) {
            btn.setText("X");
            myTable[x][y] = 2;
            playerXMove = false;
            label.setText("Player 0 move");
        } else {
            btn.setText("0");
            myTable[x][y] = 1;
            playerXMove = true;
            label.setText("Player X move");
        }
        checkResult();
    }

    private void checkResult() {
        boolean empty = false;
        TextView label = (TextView) findViewById(R.id.myGameStatusText);
        for (int i = 0; i != 3; ++i) {
            for (int j = 0; j != 3; ++j) {
                if (myTable[i][j] == 0) {
                    empty = true;
                    break;
                }
            }
        }
        if (!empty) {
            label.setText("It's a Draw!");
        }
        //horizontal lines check
        for (int i = 0; i != 3; ++i) {
            if (myTable[i][0] == 1 && myTable[i][1] == 1 && myTable[i][2] == 1) {
                label.setText("Player 0 wins!");
            }
            if (myTable[i][0] == 2 && myTable[i][1] == 2 && myTable[i][2] == 2) {
                label.setText("Player X wins!");
            }
        }
        //vertical lines check
        for (int i = 0; i != 3; ++i) {
            if (myTable[0][i] == 1 && myTable[1][i] == 1 && myTable[2][i] == 1) {
                label.setText("Player 0 wins!");
            }
            if (myTable[0][i] == 2 && myTable[1][i] == 2 && myTable[2][i] == 2) {
                label.setText("Player X wins!");
            }
        }
        //diagonal lines check
        if (myTable[0][0] == 1 && myTable[1][1] == 1 && myTable[2][2] == 1) {
            label.setText("Player 0 wins!");
        }
        if (myTable[0][0] == 2 && myTable[1][1] == 2 && myTable[2][2] == 2) {
            label.setText("Player X wins!");
        }
        if (myTable[0][2] == 1 && myTable[1][1] == 1 && myTable[2][0] == 1) {
            label.setText("Player 0 wins!");
        }
        if (myTable[0][2] == 2 && myTable[1][1] == 2 && myTable[2][0] == 2) {
            label.setText("Player X wins!");
        }
    }
}
