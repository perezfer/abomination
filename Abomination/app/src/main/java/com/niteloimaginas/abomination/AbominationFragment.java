package com.niteloimaginas.abomination;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by alfredo on 20/07/16.
 */
public class AbominationFragment extends Fragment {

    public static final String TAG = "abomination_fragment";

    protected TextView mLabel = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.abomination_layout, null);


        // This is a common case in which the fragment keeps a number of instances
        // of graphic components that hold a reference to the activity (Context)
        // if no graphic component is hold in the fragment then the Activity will not be leaked
        // but the fragment itself will be retained.
        mLabel = new TextView(getContext());

        mLabel.setText("Only developers will ever read this");

        return rootView;
    }

    public static AbominationFragment getInstance(Bundle arguments) {
        AbominationFragment abominationFragment = new AbominationFragment();
        return abominationFragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // This is basically causing a caught IllegalStateException
        // at android.support.v4.app.FragmentManagerImpl.enqueueAction
        // that seems to be holding a reference to the fragment and so to the activity.
        Glide.with(this).onDestroy();
    }
}
