package com.example.dell.androidb12;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnFocusChangeListener {

    EditText nameEditText;
    public static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp = findViewById(R.id.spinner);
        sp.setPrompt("Select Country");
        sp.setOnItemSelectedListener(this);
        nameEditText = findViewById(R.id.editTextName);
        nameEditText.setOnFocusChangeListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.spinner_item,
                R.id.textSpinner,
                // android.R.layout.simple_dropdown_item_1line,
                languages);
        sp.setAdapter(adapter); //setting adapter into socket


    }

    String[] languages = {"hindi","english","chinese","urdu"};




    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, getResources().getString(R.string.pause));
        add(10,20);
    }
    public int add(int x, int y){
        return x+y;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getResources().getString(R.string.resume));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,getResources().getString(R.string.stop));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getResources().getString(R.string.start));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,getResources().getString(R.string.destroy));
    }


    public void clickHandlerB12(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
               nameEditText = (EditText)findViewById(R.id.editTextName);
                String name= nameEditText.getText().toString();
                // Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                Intent hIntent = new Intent(MainActivity.this,HomeActivity.class);
                //explicit intent name of activity given
                hIntent.putExtra(Constants.KEY2, name);
                startActivityForResult(hIntent, 007);
                //startActivity(hIntent);


                 break;
            case R.id.buttonCancle:
                EditText pwdEditText = (EditText)findViewById(R.id.editTextPassword);
                String pwd = pwdEditText.getText().toString();
                Toast.makeText(this, pwd, Toast.LENGTH_SHORT).show();
                Intent dIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:2038099896"));
                startActivity(dIntent);



               /* final String CALCULATOR_PACKAGE ="com.android.calculator2";
                final String CALCULATOR_CLASS ="com.android.calculator2.Calculator";
                Intent intent = new Intent();

                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setComponent(new ComponentName(
                        CALCULATOR_PACKAGE,
                        CALCULATOR_CLASS));

                startActivity(intent);*/
                break;

        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView res= findViewById(R.id.textViewMain);
        String str = data.getStringExtra(Constants.KEY3);
        res.setText(str);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,"position clicked = "+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onFocusChange(View v, boolean isFocus) {
        if(isFocus){
            Toast.makeText(this,"focussed",Toast.LENGTH_SHORT).show();

        }
        else if(!isFocus){
            Toast.makeText(this,"lost focus",Toast.LENGTH_SHORT).show();
        }
    }
}
