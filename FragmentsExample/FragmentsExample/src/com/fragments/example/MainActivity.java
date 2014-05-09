package com.fragments.example;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity implements SwitchFragmentsListener
{

	final String TAG = "MainActivity";
	
	FragmentA fragi = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fragi = new PlaceholderFragment();
        
		Log.d(TAG, "onCreate");
		
        if (savedInstanceState == null) 
        {
        	Log.d(TAG, "onCreate: adding the fragment");
    		
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, fragi).commit();
        }
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    
    //מה יהיה במעבר בין הפרגמנים
	@Override
	public void switchAB(String value) {
		
		//אם אנחנו במצב של כל פרגמן בדף בודוד מסך קטן
		View view = findViewById(R.id.container);
		if(view != null)
		{
			FragmentB fragmentB = new FragmentB();
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			fragmentB.setText(value);
			
			transaction.replace(R.id.fragmentA, fragmentB);
			transaction.addToBackStack(null);
			
			
			transaction.commit();
		}
		else//מסך גדול שניהם באותו דף
		{
			FragmentB fragmentB = (FragmentB)getSupportFragmentManager().findFragmentById(R.id.fragmentB);
			fragmentB.changeText(value);
			
			
		}
		
		
	}

    //חזרה 
	@Override
	public void switchBA() {
		// TODO Auto-generated method stub
		
	}


}
