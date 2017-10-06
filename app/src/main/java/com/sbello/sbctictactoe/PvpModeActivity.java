package com.sbello.sbctictactoe;

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
        myActionBar.setDisplayShowTitleEnabled(false);
        myActionBar.setDisplayShowCustomEnabled(true);
        View apptitle = getLayoutInflater().inflate(R.layout.app_title, null);
        myActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        myActionBar.setCustomView(apptitle);

        myTable = new int[3][3];
        playerXMove = true;
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
                    .setMessage("Error - This cell is not empty!")
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

            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("Tic Tac Toe")
                    .setMessage("It's a Draw!")
                    .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PvpModeActivity.this, "Sweet!!! Let's keep playing!", Toast.LENGTH_LONG).show();
                            recreate();
                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PvpModeActivity.this, "Good Bye! Thanks for playing!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).create();
            alert.show();
        }
        //horizontal lines check
        for (int i = 0; i != 3; ++i) {
            if (myTable[i][0] == 1 && myTable[i][1] == 1 && myTable[i][2] == 1) {
                label.setText("Player 0 wins!");

                AlertDialog alert = new AlertDialog.Builder(this)
                        .setTitle("Tic Tac Toe")
                        .setMessage("Player 0 wins!")
                        .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(PvpModeActivity.this, "Sweet!!! Let's keep playing!", Toast.LENGTH_LONG).show();
                                recreate();
                            }
                        })
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(PvpModeActivity.this, "Good Bye! Thanks for playing!", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }).create();
                alert.show();
            }
            if (myTable[i][0] == 2 && myTable[i][1] == 2 && myTable[i][2] == 2) {
                label.setText("Player X wins!");

                AlertDialog alert = new AlertDialog.Builder(this)
                        .setTitle("Tic Tac Toe")
                        .setMessage("Player X wins!")
                        .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(PvpModeActivity.this, "Sweet!!! Let's keep playing!", Toast.LENGTH_LONG).show();
                                recreate();
                            }
                        })
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(PvpModeActivity.this, "Good Bye! Thanks for playing!", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }).create();
                alert.show();
            }
        }
        //vertical lines check
        for (int i = 0; i != 3; ++i) {
            if (myTable[0][i] == 1 && myTable[1][i] == 1 && myTable[2][i] == 1) {
                label.setText("Player 0 wins!");

                AlertDialog alert = new AlertDialog.Builder(this)
                        .setTitle("Tic Tac Toe")
                        .setMessage("Player 0 wins!")
                        .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(PvpModeActivity.this, "Sweet!!! Let's keep playing!", Toast.LENGTH_LONG).show();
                                recreate();
                            }
                        })
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(PvpModeActivity.this, "Good Bye! Thanks for playing!", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }).create();
                alert.show();
            }
            if (myTable[0][i] == 2 && myTable[1][i] == 2 && myTable[2][i] == 2) {
                label.setText("Player X wins!");

                AlertDialog alert = new AlertDialog.Builder(this)
                        .setTitle("Tic Tac Toe")
                        .setMessage("Player X wins!")
                        .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(PvpModeActivity.this, "Sweet!!! Let's keep playing!", Toast.LENGTH_LONG).show();
                                recreate();
                            }
                        })
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(PvpModeActivity.this, "Good Bye! Thanks for playing!", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }).create();
                alert.show();
            }
        }
        //diagonals check
        if (myTable[0][0] == 1 && myTable[1][1] == 1 && myTable[2][2] == 1) {
            label.setText("Player 0 wins!");

            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("Tic Tac Toe")
                    .setMessage("Player 0 wins!")
                    .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PvpModeActivity.this, "Sweet!!! Let's keep playing!", Toast.LENGTH_LONG).show();
                            recreate();
                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PvpModeActivity.this, "Good Bye! Thanks for playing!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).create();
            alert.show();
        }
        if (myTable[0][0] == 2 && myTable[1][1] == 2 && myTable[2][2] == 2) {
            label.setText("Player X wins!");

            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("Tic Tac Toe")
                    .setMessage("Player X wins!")
                    .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PvpModeActivity.this, "Sweet!!! Let's keep playing!", Toast.LENGTH_LONG).show();
                            recreate();
                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PvpModeActivity.this, "Good Bye! Thanks for playing!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).create();
            alert.show();
        }
        if (myTable[0][2] == 1 && myTable[1][1] == 1 && myTable[2][0] == 1) {
            label.setText("Player 0 wins!");

            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("Tic Tac Toe")
                    .setMessage("Player 0 wins!")
                    .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PvpModeActivity.this, "Sweet!!! Let's keep playing!", Toast.LENGTH_LONG).show();
                            recreate();
                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PvpModeActivity.this, "Good Bye! Thanks for playing!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).create();
            alert.show();

        }
        if (myTable[0][2] == 2 && myTable[1][1] == 2 && myTable[2][0] == 2) {
            label.setText("Player X wins!");

            AlertDialog alert = new AlertDialog.Builder(this)
                    .setTitle("Tic Tac Toe")
                    .setMessage("Player X wins!")
                    .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PvpModeActivity.this, "Sweet!!! Let's keep playing!", Toast.LENGTH_LONG).show();
                            recreate();
                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(PvpModeActivity.this, "Good Bye! Thanks for playing!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).create();
            alert.show();
        }
    }
}
