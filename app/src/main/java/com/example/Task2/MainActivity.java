package com.example.Task2;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//Recycler view object
    private RecyclerView rv ;

//adapter object
    private RVAdapter1 adapter;

//ArrayList to hold the model data
    private ArrayList<itemViewModel> item;

//intent object to navigate form activity to another
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//Find the recycler view by id
        rv = (RecyclerView) findViewById(R.id.recyclarview);

        item = new ArrayList<>();

//initialise data
        item.add(new itemViewModel("BOOK 1 ", "AUTHOR 1 ",R.drawable.image1 , "Pages number : 240"));

        item.add(new itemViewModel("BOOK 2 ", "AUTHOR 2 ",R.drawable.images2, "Pages number : 150"));

        item.add(new itemViewModel("BOOK 3 ", "AUTHOR 3 ",R.drawable.image3, "Pages number : 300"));

        adapter = new RVAdapter1(this, item);

        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter(adapter);

        adapter.setOnItemClickListener(new RVAdapter1.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                openBookInfo(position);
            }
        });

        adapter.setOnItemLongClickListener(new RVAdapter1.onItemLongClickListener() {
            @Override
            public void onLongClick(int position) {
                deleteBook(position);
            }
        });

    }
//delete book method
    public void deleteBook(int position){
        item.remove(position);
        adapter.notifyItemRemoved(position);
    }

//display book info method and opining the second activity
    public void openBookInfo(int position){

        String string;

        switch (position){
            case 0 :{
                intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("bookInfo","First book description ");
                intent.putExtra("bookName","Book 1");
                intent.putExtra("authorName","Author 1");

                intent.putExtra("imgValue",R.drawable.image1);
                startActivity(intent);

                break;
            }
            case 1:{
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("bookInfo","Second book description ");
                intent.putExtra("bookName","Book 2");
                intent.putExtra("authorName","Author 2");
                intent.putExtra("imgValue",R.drawable.images2);
                startActivity(intent);

                break;
            }

            case 2 :{
                intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("bookInfo","Third book description ");
                intent.putExtra("bookName","Book 3");
                intent.putExtra("authorName","Author 3");
                intent.putExtra("imgValue",R.drawable.image3);
                startActivity(intent);

                break;
            }
            default:
                break;
        }


    }
}


