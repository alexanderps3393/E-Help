package com.example.gawat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.database.gawat.DataKeluhan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class LvNotif extends Activity {

	String names[] = { "BM.Yanti Siregar"};
	String content[] = { "Melahirkan"};
	String waktu[] = { "20-10-2015; 13:05"};
	final Context context = this;
	List<DataKeluhan> listkeluhan_;
	List<String> list_keluhan;
	ArrayList<String> list_keluhan1 = new ArrayList<String>();
	//String names[];
	String[] tampung;
	TextView ini;
	//TextView notif1;

	private static final class Holder {
		public TextView nama;
		public TextView content;
		public TextView waktu;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lv_notif);

		// get intent
		Intent i = getIntent();
		String kode_random_ = i.getStringExtra("kode_rand_rs");
		ini = (TextView) findViewById(R.id.ini);
		
		//notif1 = (TextView) findViewById(R.id.notif1);

		// Bundle extras = getIntent().getExtras();
		// if (extras != null) {
		// String datas= extras.getString("kode_rand_rs");
		//
		// if (datas!= null) {
		// // do stuff
		// Toast.makeText(getApplicationContext(),""+datas,
		// Toast.LENGTH_LONG).show();
		// }
		// else
		// {
		// Toast.makeText(getApplicationContext(),"intent null",
		// Toast.LENGTH_LONG).show();
		// }

		// String kode_random_ = "$pOR,j,";
//		RESTClient.get().searchkeluhan("ym(C9TG", new Callback<ResponHelp>() {
//			DataKeluhan tmpHasil = new DataKeluhan();
//
//			public void failure(RetrofitError arg0) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(),
//						"Gagal Kirim api!" + arg0.toString(), Toast.LENGTH_LONG)
//						.show();
//			}
//
//			@Override
//			public void success(ResponHelp help, Response arg1) {
//				// TODO Auto-generated method stub
//				String notif = "";
//				List<DataKeluhan> data_kel = new ArrayList<DataKeluhan>();
//				data_kel = help.getDataKeluhan();
//				for (DataKeluhan dk : data_kel) {
//					list_keluhan1.add(dk.getNamaKeluhan().toString());
//				}
//				names = list_keluhan1.toArray(new String[list_keluhan1.size()]);
//				for (int i = 0; i < names.length; i++) {
////					Toast.makeText(getApplicationContext(), "name" + names[i],
////							Toast.LENGTH_LONG).show();
//					notif += names[i] + ",";
//				}
//				notif1.setText(notif);
//				if (help.getDataKeluhan().size() > 0) {
//
//				} else {
//					Toast.makeText(getApplicationContext(),"DATA SEDANG TIDAK TERSEDIA", Toast.LENGTH_LONG).show();
//				}
//			}
//
//		});

//		tampung = notif1.getText().toString().split(",");
//		Toast.makeText(getApplicationContext(),
//				"size tampung"+tampung.length, Toast.LENGTH_LONG)
//				.show();
		CustomListNotif adap = new CustomListNotif(this, names, content,waktu);

		final ListView lv = (ListView) findViewById(R.id.listviewNotif);
		lv.setAdapter(adap);
		
		
		  lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						final int arg2, long arg3) {
					
					String id_child;
					//Child_Model model_anak = new Child_Model();
					

					// TODO Auto-generated method stub
					final View selectedView = arg1;
					String str = lv.getItemAtPosition(arg2).toString();

					lv.setVisibility(View.INVISIBLE);
				}
			});

	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.linClickedNotif:
//			Toast.makeText(getApplicationContext(), "ini", Toast.LENGTH_LONG)
//					.show();
			break;

		case R.id.imgCloseNotif:
//			Toast.makeText(getApplicationContext(), "yuhu", Toast.LENGTH_LONG)
//					.show();
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

	private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
		String strAdd = "";
		Geocoder geocoder = new Geocoder(this, Locale.getDefault());
		try {
			List<Address> addresses = geocoder.getFromLocation(LATITUDE,
					LONGITUDE, 1);
			if (addresses != null) {
				Address returnedAddress = addresses.get(0);
				StringBuilder strReturnedAddress = new StringBuilder("");

				for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
					strReturnedAddress
							.append(returnedAddress.getAddressLine(i)).append(
									"\n");
				}
				strAdd = strReturnedAddress.toString();
				Log.w("My Current loction address",
						"" + strReturnedAddress.toString());
			} else {
				Log.w("My Current loction address", "No Address returned!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.w("My Current loction address", "Canont get Address!");
		}
		return strAdd;
	}
}
