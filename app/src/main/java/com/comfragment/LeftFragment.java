package com.comfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class LeftFragment extends Fragment {

	private ListView lvPlanets;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {

		View view = inflater.inflate( R.layout.left_fragment, null );

		lvPlanets = (ListView) view.findViewById( R.id.lvPlanets );

		lvPlanets.setOnItemClickListener( new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View v, int position,
					long id) {

				tratarSelecao( position );

			}
		
		} );
		
		return view;
	}

	protected void tratarSelecao( int position ) {
		String descricao = lvPlanets.getItemAtPosition( position ).toString();
		Configuration config = getResources().getConfiguration();
		
		if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			FragmentManager fm = getFragmentManager();
			RightFragment fd = (RightFragment) fm.findFragmentById( R.id.rightFragment );
			fd.setConteudo( position, descricao );
		
		} else {
			RightFragment fragDir = new RightFragment();
			Bundle args = new Bundle();
            args.putInt("pos", position);
            args.putString( "description", descricao );
            fragDir.setArguments(args);
			FragmentManager fragmentManager = getFragmentManager();
		    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	        fragmentTransaction.add(android.R.id.content, fragDir);
	        fragmentTransaction.addToBackStack(null);
	        fragmentTransaction.commit();
		}
	}
}
