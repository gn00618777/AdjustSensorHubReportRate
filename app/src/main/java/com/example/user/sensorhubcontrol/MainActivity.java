package com.example.user.sensorhubcontrol;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    TextView showResult;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    String line = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    execCommand("su", 0);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                Toast.makeText(v.getContext(), "Report Rate: 10ms", Toast.LENGTH_LONG).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    execCommand("su", 1);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }

                Toast.makeText(v.getContext(), "Report Rate: 5ms", Toast.LENGTH_LONG).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    execCommand("su", 2);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                Toast.makeText(v.getContext(), "Report Rate: 2ms", Toast.LENGTH_LONG).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    execCommand("su", 3);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                Toast.makeText(v.getContext(), "Report Rate: 1ms", Toast.LENGTH_LONG).show();
            }
        });
    } //onCreate
    public void execCommand(String command, int which) throws IOException
    {
        java.lang.Process proc = Runtime.getRuntime().exec(command);
        DataOutputStream outputStream = new DataOutputStream(proc.getOutputStream());

        if(which == 0)
        {
            outputStream.writeBytes("sensorsHubControl CWM0300\n");
            outputStream.flush();
        }
        else if(which == 1)
        {
            outputStream.writeBytes("sensorsHubControl CWM0301\n");
            outputStream.flush();
        }
        else if(which == 2)
        {
            outputStream.writeBytes("sensorsHubControl CWM0302\n");
            outputStream.flush();
        }
        else
        {
            outputStream.writeBytes("sensorsHubControl CWM0303\n");
            outputStream.flush();
        }
    }
}
