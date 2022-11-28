package com.jmcandilejo.saude;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewClientActivity extends AppCompatActivity {
    private EditText phone;
    private EditText sms;
    private EditText cpf;
    private EditText name;
    private EditText surname;
    private EditText birth_date;
    private EditText mail;
    private EditText red_senha;
    private EditText senha;
    private Button celular_ask;
    private Button confirma_sms;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_client);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(R.string.new_client);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));

        phone = findViewById(R.id.editTextPhone);
        sms = findViewById(R.id.editTextSms);
        cpf = findViewById(R.id.cpf);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        birth_date = findViewById(R.id.date);
        mail = findViewById(R.id.mail);
        senha = findViewById(R.id.senha);
        red_senha = findViewById(R.id.red_senha);
        celular_ask = findViewById(R.id.button);
        confirma_sms = findViewById(R.id.button2);
        submit = findViewById(R.id.submit);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean compruebaCampo(EditText val){
        if (val.getText().toString().trim().equalsIgnoreCase("")){
            Toast.makeText(NewClientActivity.this, val.getHint()+" missing",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    public boolean submitClick (View v){
        if (!compruebaCampo(phone)){return false;}
        if (!compruebaCampo(sms)){return false;}
        if (!compruebaCampo(cpf)){return false;}
        if (!compruebaCampo(name)){return false;}
        if (!compruebaCampo(surname)){return false;}
        if (!compruebaCampo(birth_date)){return false;}
        if (!compruebaCampo(mail)){return false;}
        if (!compruebaCampo(senha)){return false;}
        if (!compruebaCampo(red_senha)){return false;}
        Toast.makeText(NewClientActivity.this, "Form with all fields completed",
                Toast.LENGTH_SHORT).show();
        return true;
    }

    public void celularAskClicked (View v){
        Toast.makeText(NewClientActivity.this, "You pressed celular?",
                Toast.LENGTH_SHORT).show();
    }

    public void confirmaClicked (View v){
        Toast.makeText(NewClientActivity.this, "You pressed confirma",
                Toast.LENGTH_SHORT).show();
    }
}