package com.example.send_parcelable_objects_to_fragment_android_github;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DetailFragment.FragmentListener {

    private FloatingActionButton floatingActionButton;
    public static final String TAG = "main_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDetails userDetails = new UserDetails("Jones","Malik",2);
                DetailFragment detailFragment = DetailFragment.newInstance(userDetails);
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .add(R.id.frame_container,detailFragment,TAG)
                        .commit();
            }
        });
    }

    @Override
    public void sendValues(UserDetails userDetails) {
        Log.i(TAG,"First Name:- "+userDetails.getFirstName()+", Last Name:- "+userDetails.getLastName()+", Age:- "+userDetails.getAge()+".");


        Toast.makeText(getApplicationContext(),"First Name:- "+userDetails.getFirstName()+", Last Name:- "+userDetails.getLastName()+", Age:- "+userDetails.getAge()+".",Toast.LENGTH_LONG).show();

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(TAG);
        if(fragment!=null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }

    }
}
