package com.example.trailmobile.app.Views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.trailmobile.app.Classes.ConnectionManager;
import com.example.trailmobile.app.Classes.DataSource;
import com.example.trailmobile.app.Classes.Factory;
import com.example.trailmobile.app.Models.Athlete;
import com.example.trailmobile.trailmobile.R;

public class introActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        handler = new Handler();
        buttonListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Metodo para ficar a escuta de cliques nos botoes
    public void buttonListener()
    {
        Button submeter = (Button) findViewById(R.id.submeter);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);


        submeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText email = (EditText) findViewById(R.id.email);
                EditText password = (EditText) findViewById(R.id.password);
                Athlete user =  Athlete.getAthleteByCredentials(email.getText().toString(), password.getText().toString());
                progressBar.setVisibility(View.VISIBLE);
                if (user == null) {
                    ConnectionManager.createConnectionEvents(Factory.getInstance().createTrailEvent(),"http://apus.uma.pt/~a2012310/trailmobile/index.php/events");
                    ConnectionManager.createConnectionUsers(Factory.getInstance().createAthlete(), "http://apus.uma.pt/~a2012310/trailmobile/index.php/athlete", email.getText().toString());

                    runnable = new  Runnable() {

                        @Override
                        public void run() {

                            if (DataSource.getInstance().getUser_id() > 0)
                                avancaMenu();
                            //handler.postDelayed(this,1000);
                            progressBar.setVisibility(View.GONE);
                        }
                    };
                    handler.postDelayed(runnable, 8000);
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    DataSource.getInstance().setUser_id(user.getId());
                    avancaMenu();
                }
                // TODO Auto-generated method stub

                // Executar validacao
                // Validation validaInputs = new Validation();
                // if(validaInputs.validate()) avancaMenu();

            }
        });
    }

    public void avancaMenu()
    {
        // ao executar este código passa para outra activity. atencao para passar dados de uma para outra é necessário fazer inflate.
        // portanto da introActivity -> MainMenuActivity
        Intent myIntent = new Intent(this, MainMenuActivity.class);
        startActivity(myIntent);
    }
}
