package com.example.vvapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1 = null;
    private Button button2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        button1 = (Button)findViewById(R.id.buttonOne);
        button2 = (Button)findViewById(R.id.buttonTwo);
        button1.setOnClickListener(new myClickListener());
        button2.setOnClickListener(new myClickListener());
    }

    private class myClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            if(v.getId()==R.id.buttonOne){
                intent.setClass(MainActivity.this,LinearRecyclerViewActivity.class);
            }else {
                intent.setClass(MainActivity.this,LinearRecyclerViewActivity.class);
            }
            MainActivity.this.startActivity(intent);
        }
    }

}
