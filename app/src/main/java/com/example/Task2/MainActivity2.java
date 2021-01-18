package com.example.Task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView bookImg;
    TextView bookInfo ,bookName , authorName ;
    String bookInfoString , bookNameString, authorNameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        bookName = findViewById(R.id.textView2);
        authorName = findViewById(R.id.textView3);
        bookImg = findViewById(R.id.actavitybutton);
        bookInfo = findViewById(R.id.textView444);

        bookInfo.setText(getIntent().getExtras().getString("bookInfo"));
        bookName.setText(getIntent().getExtras().getString("bookName"));
        authorName.setText(getIntent().getExtras().getString("authorName"));


        Bundle b = getIntent().getExtras();
            int resID = b.getInt("imgValue");
            bookImg.setImageResource(resID);


    }
}