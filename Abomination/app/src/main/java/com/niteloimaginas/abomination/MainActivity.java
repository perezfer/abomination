package com.niteloimaginas.abomination;

import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.abomination_button);
        if (button != null) {
            button.setOnClickListener(this);
        }

        enableStrictMode();
    }

    protected void enableStrictMode() {
        if (BuildConfig.DEBUG) {
            // This is used to detect Activities that are leaked. As soon as two activities of
            // the same class are detected it will kill the application.
            StrictMode.VmPolicy.Builder vmPolicy = new StrictMode.VmPolicy.Builder();

            vmPolicy.detectActivityLeaks();

            StrictMode.setVmPolicy(vmPolicy.penaltyLog()
                                           .penaltyDeath()
                                           .build());
        }

    }

    @Override
    public void onClick(View v) {
        createAbominationActivity();
    }

    protected void createAbominationActivity() {
        Intent intent = new Intent(this, AbominationActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(AccountManager.KEY_INTENT, intent);
        startActivity(intent);
    }

}
