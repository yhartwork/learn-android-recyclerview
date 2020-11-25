package com.example.yusufapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyAdapter.ListItemClickListener {

    String[] s1;
    String[] s2;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.programming_languages);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onListItemClick(int position) {
        Toast.makeText(this, s1[position], Toast.LENGTH_SHORT).show();

        Intent myIntent = new Intent(MainActivity.this, LanguageDetail.class);
        myIntent.putExtra("key", "Hello!");
        MainActivity.this.startActivity(myIntent);
    }
}

