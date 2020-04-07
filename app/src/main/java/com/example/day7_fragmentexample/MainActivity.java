package com.example.day7_fragmentexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "I am from Activity" + "hello", Toast.LENGTH_LONG).show();
            }
        });

        mFragmentManager = getSupportFragmentManager();

//        mFragmentTransaction = mFragmentManager.beginTransaction();
//        mFragmentTransaction.add(R.id.container, new RedFragment());
//        mFragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        Fragment mFragment = null;
        switch (item.getItemId()){
            case R.id.menuRed:
                mFragment = new RedFragment();
                break;
            case R.id.menuBlue:
                mFragment = new BlueFragment();
                break;
            case R.id.menuGreen:
                mFragment = new GreenFragment();
                break;
            case R.id.menuHome:
             //   mFragmentTransaction.remove(null);
                break;
        }

        mFragmentTransaction.replace(R.id.container, mFragment);
        mFragmentTransaction.commit();

        return super.onOptionsItemSelected(item);
    }
}
