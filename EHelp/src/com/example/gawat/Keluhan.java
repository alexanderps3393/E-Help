package com.example.gawat;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.database.gawat.DataDiri;
import com.database.gawat.DataKeluhan;
import com.database.gawat.DataRs;
import com.database.gawat.db_gawat;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Keluhan extends Activity {

	LinearLayout lihatselengkapnya;
	TextView lihat_selengkapnya, viewNamaKeluhan;
	TextView tvNmaKorban, viewBODPasien, viewJKPasien, viewALAMATAnak,
			tvGolDar, viewStatusAnak, viewpenyakitParah, viewTelp;
	TextView tvRS, tvKontakRS, tvJarakRS;
	List<DataRs> listRS_;

	// String
	String id_keluhan, id_grid;

	// database dan model
	db_gawat db;

	DataKeluhan dataKel;
	DataDiri datadiri;

	// for map
	GoogleMap googleMap;
	GPSTracker gps;
	PlacesList near_hospital;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_keluhan);

		tvNmaKorban = (TextView) findViewById(R.id.tvNmaKorban);
		viewBODPasien = (TextView) findViewById(R.id.viewBODPasien);
		viewJKPasien = (TextView) findViewById(R.id.viewJKPasien);
		viewALAMATAnak = (TextView) findViewById(R.id.viewALAMATAnak);
		tvGolDar = (TextView) findViewById(R.id.tvGolDar);
		viewStatusAnak = (TextView) findViewById(R.id.viewStatusAnak);
		viewpenyakitParah = (TextView) findViewById(R.id.viewpenyakitParah);
		viewTelp = (TextView) findViewById(R.id.viewTelp);

		tvRS = (TextView) findViewById(R.id.viewnamaRS);
		tvKontakRS = (TextView) findViewById(R.id.viewKontak);
		tvJarakRS = (TextView) findViewById(R.id.viewJarak);

		dataKel = new DataKeluhan();
		datadiri = new DataDiri();
		db = new db_gawat(this);
		//Toast.makeText(getApplicationContext(), " data keluhan"+dataKel.getIdKeluhan(),Toast.LENGTH_SHORT).show();
		
		Intent intent = getIntent();
		id_keluhan = intent.getStringExtra("id_keluhan");
		id_grid = intent.getStringExtra("id_grid");

		//Toast.makeText(getApplicationContext(), "id_grid :" + id_grid,Toast.LENGTH_SHORT).show();
		DataDiri korban  = db.ViewDataDiri(id_grid);
//		Toast.makeText(getApplicationContext(), "nama :" +korban.getNama(),
//				Toast.LENGTH_SHORT).show();

		PlacesList plist = ListRumahSakit();
		
		
		lihatselengkapnya = (LinearLayout) findViewById(R.id.lin_lihatselengkapnya);
		lihat_selengkapnya = (TextView) findViewById(R.id.tv_lihat_selengkapnya);
		viewNamaKeluhan = (TextView) findViewById(R.id.viewNamaKeluhan);
		dataKel = db.ViewDataKeluhan(id_keluhan);

		viewNamaKeluhan.setText(dataKel.getNamaKeluhan());
		SetTampilanIdentitasAnak();

		lihat_selengkapnya.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (lihat_selengkapnya.getVisibility() == View.VISIBLE) {
					lihatselengkapnya.setVisibility(View.VISIBLE);
					lihat_selengkapnya.setVisibility(View.INVISIBLE);
				} else {
					lihatselengkapnya.setVisibility(View.INVISIBLE);
				}
			}
		});

		// map
		gps = new GPSTracker(this);
		googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

		googleMap.setMyLocationEnabled(true);

		near_hospital = RecomendedRS();
		for (Place a : near_hospital.results) {
			googleMap.addMarker(new MarkerOptions()
					.position(new LatLng(a.lat, a.lng))
					.title(a.name)
					.snippet(a.formatted_address)
					.icon(BitmapDescriptorFactory.fromResource(R.drawable.mark_blue)));

			// make polylines
			MarkerOptions options = new MarkerOptions();
			options.position(new LatLng(a.lat, a.lng));
			googleMap.addMarker(options);
			String url = getMapsApiDirectionsUrl(a);

			// set info lokasi kejadian
			//rekomendasi beberapa rumah sakit
			tvRS.setText(a.getNama());
			tvJarakRS.setText("2 km");
			tvKontakRS.setText(a.getPhone());

			ReadTask downloadTask = new ReadTask();
			downloadTask.execute(url);
		}

		CameraPosition cameraPosition = new CameraPosition.Builder()
				.target(new LatLng(gps.getLatitude(), gps.getLongitude()))
				.zoom(5).build();

		MapFragment.newInstance(new GoogleMapOptions().camera(cameraPosition));

	}

	public void SetTampilanIdentitasAnak() {
		// String id_pasien = db.ViewIdByIdKeluhan(id_keluhan);
		datadiri = db.ViewDataDiri(id_grid);

		tvNmaKorban.setText(datadiri.getNama());
		viewBODPasien.setText(datadiri.getTmptLahir() + ","+ datadiri.getTanggalLahir());
		viewJKPasien.setText(datadiri.getJenKel());
		viewALAMATAnak.setText(datadiri.getAlamat());
		tvGolDar.setText(datadiri.getGolda());
		viewStatusAnak.setText(datadiri.getStatus());
		viewpenyakitParah.setText(datadiri.getPenyakitId());
		viewTelp.setText(datadiri.getTelp());
		
		//simpan data diri ke server
		//Insert DataDiri
		//Toast.makeText(getApplicationContext(),"".toString(),Toast.LENGTH_LONG).show();
			
//		RESTClient.get().simpanDataDiri(id_grid.toString(), datadiri.getNama().toString(), datadiri.getTmptLahir().toString(), datadiri.getTanggalLahir().toString(),
//				datadiri.getGolda().toString(), datadiri.getTelp().toString(), datadiri.getWa().toString(), datadiri.getBBM().toString(), datadiri.getAlamat().toString(), datadiri.getPenyakitId().toString(), 
//				datadiri.getFoto().toString(), datadiri.getIdPembuat().toString(),datadiri.getWaktu().toString(), new Callback<String>()
		RESTClient.get().simpanDataDiri(id_grid.toString(), datadiri.getNama().toString(),"k", "k",
				datadiri.getGolda().toString(), datadiri.getTelp().toString(), "0", "0", datadiri.getAlamat(), "123", 
				"123", "123",datadiri.getWaktu(), new Callback<String>()
				
						{
					@Override
					public void success(String arg0, Response arg1) {
						// TODO Auto-generated method stub
						if(arg0.equals("benar")){
//							Toast.makeText(getApplicationContext(),"berhasil simpan data dri",Toast.LENGTH_LONG).show();
						} else {
//							Toast.makeText(getApplicationContext(),
//									"Gagal",Toast.LENGTH_LONG).show();
						}
					}

					@Override
					public void failure(RetrofitError arg0) {
						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(),
//								"Gagal Kirim api data diri!"+arg0.toString(),
//								Toast.LENGTH_LONG).show();
					}	
						});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.keluhan, menu);
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

	private String getMapsApiDirectionsUrl(Place a) {
		String waypoints = "waypoints=optimize:true|" + a.getLat() + ","
				+ a.getLng() + "," + gps.getLatitude() + "|"
				+ gps.getLongitude();
		String sensor = "sensor=false";
		String params = waypoints + "&" + sensor;
		String output = "json";
		String url = "https://maps.googleapis.com/maps/api/directions/json?origin="
				+ gps.getLatitude()
				+ ","
				+ gps.getLongitude()
				+ "&destination="
				+ a.getLat()
				+ ","
				+ a.getLng()
				+ "&sensor=false";
		return url;
	}

	public PlacesList ListRumahSakit() {
		
		final List<Place> places = new ArrayList<Place>();
//		
//		RESTClient.get().getRumahsakit((new Callback<ResponHelp>() {
//			@Override
//			public void failure(RetrofitError error) {
//				// TODO Auto-generated method stub
//				// progress.dismiss();
//				Toast.makeText(getApplicationContext(),
//						"AKSES KE SERVER GAGAL" + error.getMessage(),
//						Toast.LENGTH_LONG).show();
//			}
//
//			@Override
//			public void success(ResponHelp hasil, Response arg1) {
//				// TODO Auto-generated method stub
////				Toast.makeText(getApplicationContext(),
////						"Get Rumah Sakit" + hasil.getDataRumahsakit().size(),
////						Toast.LENGTH_LONG).show();
//				Toast.makeText(getApplicationContext(), "Success retrieve rs"+hasil.getDataRumahsakit().size(), Toast.LENGTH_LONG).show();
////				listRS_ = hasil.getDataRumahsakit();
////				Double lat = 0.0;
////				Double lng = 0.0 ;
////				Place tempat = new Place();
////				for(DataRs a : listRS_)
////				{
//////					Toast.makeText(getApplicationContext(),""+Double.parseDouble(a.getrs_latitude())+ hasil.getDataRumahsakit().size(),
//////							Toast.LENGTH_LONG).show();
//////					lat = Double.parseDouble(a.getrs_latitude());
//////					lng = Double.parseDouble(a.getrs_longitude());
////					
////					tempat.setNama(a.getnama_rs());
////					tempat.setformated_address(a.getrs_alamat());
////					tempat.setLat(2.435193);
////					tempat.setLng(99.158069);
////					tempat.setPhone(a.getrs_no_telp());
////					tempat.setStatusAmbulans(a.getstatus_ambulance());
////					tempat.setVicinity("TOBASA");
////					
////					places.add(tempat);
////					Toast.makeText(getApplicationContext(), a.getrs_alamat(), Toast.LENGTH_LONG).show();
////				}
//			}
//		}));
		
		// static
		PlacesList pl = new PlacesList();
		// Rs porsea
		Place p1 = new Place();
		p1.setNama("Rumah Sakit Porsea");
		p1.setLat(2.435193);
		p1.setLng(99.158069);
		p1.setVicinity("Porsea");
		p1.setformated_address("Jalan Raja Sipakko N");
		p1.setPhone("063241084");
		p1.setStatusAmbulans("YES");
		// Rs balige
		Place p2 = new Place();
		p2.setNama("Rumah Sakit HKBP Balige");
		p2.setLat(2.330470);
		p2.setLng(99.066860);
		p2.setVicinity("Balige");
		p2.setformated_address("Jalan Gereja No.17Ba");
		p2.setPhone("063221043");
		p2.setStatusAmbulans("YES");
		// Rs harapan
		Place p3 = new Place();
		p3.setNama("Rumah Sakit Harapan");
		p3.setLat(2.942602);
		p3.setLng(99.065732);
		p3.setVicinity("Siantar");
		p3.setStatusAmbulans("YES");
		p3.setPhone("0622211622");
		// Rs Horas Insani
		Place p4 = new Place();
		p4.setNama("Rumah Sakit Horas Insani");
		p4.setLat(2.977900);
		p4.setLng(99.079520);
		p4.setVicinity("Siantar");
		p4.setStatusAmbulans("YES");
		p4.setPhone("433444");
//
		
		places.add(p1);
		places.add(p2);
		places.add(p3);
		places.add(p4);
		pl.setstatus("OK");
		pl.setListPlace(places);

		
		
		return pl;
	}

	public PlacesList RecomendedRS() {
		int jarak_temp = 0;

		PlacesList pl = ListRumahSakit();
		PlacesList pl_new = new PlacesList();
		
		List<Place> l_new = new ArrayList<Place>();
		// cek yang terdekat -> radius 10 km
		for (Place tempat : pl.results) {
			jarak_temp = calculateDistance(gps.getLatitude(),gps.getLongitude(), tempat.lat, tempat.lng);
			tempat.setJarak(jarak_temp);
			if (jarak_temp <= 30) {
				l_new.add(tempat);
			}
		}

		// cek available ambulans
		for (Place pn : l_new) {
			if (pn.s_ambulans.equals("1")) {
				l_new.remove(pn);
			}
		}

		pl_new.setListPlace(l_new);

		return pl_new;
	}

	public final static double AVERAGE_RADIUS_OF_EARTH = 6371;

	public int calculateDistance(double userLat, double userLng,
			double venueLat, double venueLng) {

		double latDistance = Math.toRadians(userLat - venueLat);
		double lngDistance = Math.toRadians(userLng - venueLng);

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(userLat))
				* Math.cos(Math.toRadians(venueLat))
				* Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH * c));
	}

	private class ReadTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... url) {
			String data = "";
			try {
				HttpConection_ http = new HttpConection_();
				data = http.readUrl(url[0]);
			} catch (Exception e) {
				Log.d("Background Task", e.toString());
			}
			return data;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			new ParserTask().execute(result);
		}
	}

	private class ParserTask extends
			AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

		@Override
		protected List<List<HashMap<String, String>>> doInBackground(
				String... jsonData) {

			JSONObject jObject;
			List<List<HashMap<String, String>>> routes = null;

			try {
				jObject = new JSONObject(jsonData[0]);
				PathJSONParser parser = new PathJSONParser();
				routes = parser.parse(jObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return routes;
		}

		@Override
		protected void onPostExecute(List<List<HashMap<String, String>>> routes) {
			ArrayList<LatLng> points = null;
			PolylineOptions polyLineOptions = null;

			// traversing through routes
			for (int i = 0; i < routes.size(); i++) {
				points = new ArrayList<LatLng>();
				polyLineOptions = new PolylineOptions();
				List<HashMap<String, String>> path = routes.get(i);

				for (int j = 0; j < path.size(); j++) {
					HashMap<String, String> point = path.get(j);

					double lat = Double.parseDouble(point.get("lat"));
					double lng = Double.parseDouble(point.get("lng"));
					LatLng position = new LatLng(lat, lng);

					points.add(position);
				}

				polyLineOptions.addAll(points);
				polyLineOptions.width(4);
				polyLineOptions.color(Color.GREEN);
			}

			googleMap.addPolyline(polyLineOptions);
		}
	}

}