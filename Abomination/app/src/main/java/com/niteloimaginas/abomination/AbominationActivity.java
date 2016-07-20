package com.niteloimaginas.abomination;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;

/**
 * Created by alfredo on 20/07/16.
 */
public class AbominationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = getIntent();

        setContentView(R.layout.activity_abomination);

        if (savedInstanceState == null) {
            initNewFragment(intent);
        }
    }


    protected void initNewFragment(Intent intent) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = AbominationFragment.getInstance(null);
        fragmentTransaction.add(R.id.container, fragment, AbominationFragment.TAG);
        fragmentTransaction.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            Glide.with(this).onDestroy();
        }
    }
}
