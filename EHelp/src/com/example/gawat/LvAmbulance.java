package com.example.gawat;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class LvAmbulance extends Activity {

	String lokasi[] = {"Sitoluama","Balige"};
	String waktu[] = {"20-10-2015; 13:50","20-10-2015; 14:10"};
	final Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lv_ambulance);
		
		 
		  CustomListAmbulance adap = new CustomListAmbulance(this, lokasi,waktu);
		  
		  ListView lv = (ListView) findViewById(R.id.listviewAmbu);
		  lv.setAdapter(adap);
		  

	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnTersedia:
			Toast.makeText(getApplicationContext(), "Ambulance Tersedia",
					 Toast.LENGTH_LONG).show();
			break;


		case R.id.imgCloseNotif:
			Toast.makeText(getApplicationContext(), "yuhu",
					 Toast.LENGTH_LONG).show();
			break;

		default:
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lv_notif, menu);
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
}
