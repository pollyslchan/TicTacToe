package com.example.pollychan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int round = 0;

    //Get button state, if not blank, assign O and X for alternative rounds
    public void ButtonClick(View view){
        Button button = (Button) view;
        String buttonState = button.getText().toString();

        TextView roundTextView = (TextView) findViewById(R.id.roundMessage);
        EditText player1Name = (EditText) findViewById(R.id.player1);
        String player1String = player1Name.getText().toString();
        EditText player2Name = (EditText) findViewById(R.id.player2);
        String player2String = player2Name.getText().toString();

        if (buttonState.equals("")) {
            if (round % 2 == 0) {
                roundTextView.setText("This is player " + player1String + " turn.");
                button.setText("O");
            } else {
                roundTextView.setText("This is player " + player2String + " turn.");
                button.setText("X");
            }
            check();
            round++;


        } else {
            Toast.makeText(getApplicationContext(),"Choose another!", Toast.LENGTH_SHORT).show();
        }
    }

    private void check(){
        //pass all button states into String variables
        Button button1 = (Button) findViewById(R.id.button1);
        String string1 = button1.getText().toString();

        Button button2 = (Button) findViewById(R.id.button2);
        String string2 = button2.getText().toString();

        Button button3 = (Button) findViewById(R.id.button3);
        String string3 = button3.getText().toString();

        Button button4 = (Button) findViewById(R.id.button4);
        String string4 = button4.getText().toString();

        Button button5 = (Button) findViewById(R.id.button5);
        String string5 = button5.getText().toString();

        Button button6 = (Button) findViewById(R.id.button6);
        String string6 = button6.getText().toString();

        Button button7 = (Button) findViewById(R.id.button7);
        String string7 = button7.getText().toString();

        Button button8 = (Button) findViewById(R.id.button8);
        String string8 = button8.getText().toString();

        Button button9 = (Button) findViewById(R.id.button9);
        String string9 = button9.getText().toString();

        //conditions to win
        if (((string1.equals(string2)) && (string2.equals(string3)) && !(string1.equals(""))) ||
                ((string4.equals(string5)) && (string5.equals(string6)) && !(string4.equals(""))) ||
                ((string7.equals(string8)) && (string8.equals(string9)) && !(string7.equals(""))) ||
                ((string1.equals(string4)) && (string4.equals(string7)) && !(string1.equals(""))) ||
                ((string2.equals(string5)) && (string5.equals(string8)) && !(string2.equals(""))) ||
                ((string3.equals(string6)) && (string6.equals(string9)) && !(string3.equals(""))) ||
                ((string1.equals(string5)) && (string5.equals(string9)) && !(string1.equals(""))) ||
                ((string3.equals(string5)) && (string5.equals(string7)) && !(string3.equals("")))) {

            //show a "You win message when win
            Toast toast = Toast.makeText(getApplicationContext(),"You win!", Toast.LENGTH_LONG);
            ViewGroup viewGroupToast = (ViewGroup) toast.getView();
            TextView messageToast = (TextView) viewGroupToast.getChildAt(0);
            messageToast.setTextSize(72);
            toast.show();

        }
    }
}
