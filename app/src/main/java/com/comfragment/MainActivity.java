package com.comfragment;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    Configuration config = getResources().getConfiguration();

	    if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
	         setContentView( R.layout.activity_main );
	    }else{
	         LeftFragment lf = new LeftFragment();
	         FragmentManager fragmentManager = getFragmentManager();
	         FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	         fragmentTransaction.add(android.R.id.content, lf);
	         fragmentTransaction.commit();
	    }
	}
}
