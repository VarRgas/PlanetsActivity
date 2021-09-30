package com.comfragment;

import android.app.Fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RightFragment extends Fragment {

	private int imagens_id[] = {
			R.drawable.terra,
			R.drawable.mercurio,
			R.drawable.venus,
			R.drawable.jupiter,
			R.drawable.marte,
			R.drawable.saturno,
			R.drawable.urano,
			R.drawable.netuno
	};
	
	private ImageView imPlanets;
	private TextView tvDescription;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
		View view = inflater.inflate( R.layout.right_fragment, null );
		imPlanets = (ImageView) view.findViewById(R.id.imPlanets);
		tvDescription = (TextView) view.findViewById(R.id.tvDescription);
		imPlanets.setScaleType(ImageView.ScaleType.FIT_XY);
		Configuration config = getResources().getConfiguration();

		if (config.orientation != Configuration.ORIENTATION_LANDSCAPE) {
			String descricao = getArguments().getString("description");
			int position = getArguments().getInt("pos");
			imPlanets.setImageResource(imagens_id[position]);
			tvDescription.setText(descricao);
		}
		return view;
	}
	public void setConteudo( int pos, String description ) {
		imPlanets.setImageResource( imagens_id[ pos ] );
		tvDescription.setText( description );
	}
}
		