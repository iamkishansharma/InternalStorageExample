package com.example.internalstorageexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button readButton, writeButton;
    static int SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText1);
        textView = findViewById(R.id.textView1);
        writeButton = findViewById(R.id.writeBtn);
        readButton = findViewById(R.id.readBtn);

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fileout = openFileOutput("mytextfile.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(editText.getText().toString());
                    outputWriter.close();

                    Toast.makeText(getBaseContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileInputStream fileIn=openFileInput("mytextfile.txt");
                    InputStreamReader InputRead= new InputStreamReader(fileIn);

                    String s="";
                    int charRead;

                    while ((charRead=InputRead.read())!=-1) {
                        // char to string conversion
                        s = s + Character.toString((char)charRead);
                    }
                    InputRead.close();
                    textView.setText(s);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
    }

