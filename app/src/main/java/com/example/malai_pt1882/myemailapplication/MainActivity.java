package com.example.malai_pt1882.myemailapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.malai_pt1882.myemailapplication.mainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendButton(View view){

        //Gettting message from the textView
        EditText editText = (EditText)findViewById(R.id.editText);
        String text = editText.getText().toString();
        String sendTo = "pazh14227.ee@rmkec.ac.in";

        //creating new intent and setting it with action and data
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setDataAndType(Uri.parse(sendTo),"text/plain");

        //while setting data and type seperately data will not show up in mail
//        intent.setData(myUri);
//        intent.setType("text/plain");

        //adding subject and text
        intent.putExtra(EXTRA_MESSAGE,text);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        intent.putExtra(Intent.EXTRA_TEXT, text);

        Intent chooser = Intent.createChooser(intent,"Share Using");

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(chooser);
        }

    }

    public void sendMessage(View view){
        EditText editText = (EditText)findViewById(R.id.editText);
        String text = editText.getText().toString();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(text),"text/plain");
        Intent chooser = Intent.createChooser(intent, "View using");

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(chooser);
        }
    }
}
