package com.example.danelogowania;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /********************************************************
     * nazwa funkcji: onCreate
     * parametry wejściowe: saveInstanceState - parametry uruchomieniowe
     * wartość zwracana: brak
     * opis: uruchamia aplikację mobilną
     * autor: 23456789012
     * ****************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /********************************************************
     * nazwa funkcji: zatwierdz
     * parametry wejściowe: view - widok wywołujący zdarzenie
     * wartość zwracana: brak
     * opis: zatwierdza formularz przeprowadzając jego walidację
     * autor: 23456789012
     * ****************************************************/
    public void zatwierdz(View view) {
        EditText login = (EditText) findViewById(R.id.login);
        String loginStr = login.getText().toString();

        EditText email = (EditText) findViewById(R.id.email);
        String emailStr = email.getText().toString();

        EditText haslo = (EditText) findViewById(R.id.haslo);
        String hasloStr = haslo.getText().toString();

        TextView komunikat = (TextView) findViewById(R.id.komunikat);
        String komunikatStr = "";

        if (!(loginStr.length() > 0 || emailStr.length() > 0)) {
            komunikatStr = "Wymagany login lub email. ";
        }
        if (hasloStr.length() == 0) {
            komunikatStr += "Wymagane hasło. ";
        }
        if (loginStr.length() > 0 && loginStr.indexOf(" ") >= 0) {
            komunikatStr += "Nieprawidłowy login. ";
        }
        if (emailStr.length()>0 && emailStr.indexOf("@") < 0) {
            komunikatStr += "Nieprawidłowy email. ";
        }
        if ((
                (loginStr.equals("leszek") || emailStr.equals("leszek@wp.pl")) && (hasloStr.equals("tajne1")) ||
                (loginStr.equals("maria") || emailStr.equals("maria@interia.pl")) && (hasloStr.equals("tajne2")) ||
                (loginStr.equals("zenek") || emailStr.equals("zenek@onet.pl")) && (hasloStr.equals("tajne3"))
             ) && komunikatStr.length() == 0
            ) {
            komunikatStr = "Witaj " + loginStr + " " + emailStr;
        } else {
            komunikatStr += "Błąd uwierzytelniania.";
        }
        komunikat.setText(komunikatStr);
    }
}