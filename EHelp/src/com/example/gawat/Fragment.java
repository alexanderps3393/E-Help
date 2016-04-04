package com.example.gawat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpConnection;
import org.json.JSONObject;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Fragment extends FragmentActivity {

	GoogleMap googleMap;
	GPSTracker gps;
	PlacesList near_hospital;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);

		PolylineOptions polylineOptions = new PolylineOptions();
		gps = new GPSTracker(this);
		googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        googleMap.setMyLocationEnabled(true);
        
        near_hospital = RecomendedRS();
        for(Place a : near_hospital.results)
        {
        	googleMap.addMarker(new MarkerOptions().position(new LatLng(a.lat, a.lng)).title(a.name).snippet(a.formatted_phone_number).icon(BitmapDescriptorFactory.fromResource(R.drawable.mark_blue)));
        	
        	//make polylines
        	
        	MarkerOptions options = new MarkerOptions();
    		options.position(new LatLng(a.lat, a.lng));
    		googleMap.addMarker(options);
    		String url = getMapsApiDirectionsUrl(a);
    		Log.e("url", ""+url);
//    		Toast.makeText( getApplicationContext(),""+url,Toast.LENGTH_SHORT).show();
    				
    		
    		ReadTask downloadTask = new ReadTask();
    		downloadTask.execute(url);
//    		
//            polylineOptions.add(new LatLng(a.lat, a.lng));
//            polylineOptions.add(new LatLng(gps.getLatitude(), gps.getLongitude()));
//            googleMap.addPolyline(polylineOptions);
//            googleMap.addPolyline(new PolylineOptions().add(new LatLng(a.lat, a.lng), new LatLng(gps.getLatitude(), gps.getLongitude())).width(5).color(Color.BLUE).geodesic(true));
        }
        //googleMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(gps.getLatitude(),gps.getLongitude()) , 12.0f) );
        CameraPosition cameraPosition = new CameraPosition.Builder()
        .target(new LatLng(gps.getLatitude(),gps.getLongitude()))
        .zoom(13)
        .build();
        
        MapFragment.newInstance(new GoogleMapOptions().camera(cameraPosition));
        
        
	}
	
	private String getMapsApiDirectionsUrl(Place a) {
		//http://maps.googleapis.com/maps/api/directions/json?origin=51,0&destination=51.5,-0.1&sensor=false
		String waypoints = "waypoints=optimize:true|"
				+ a.getLat() + "," + a.getLng()+","
				+gps.getLatitude()+"|"+gps.getLongitude();
		
//		String waypoints = "waypoints=optimize:true|"
//				+ LOWER_MANHATTAN.latitude + "," + LOWER_MANHATTAN.longitude
//				+ "|" + "|" + BROOKLYN_BRIDGE.latitude + ","
//				+ BROOKLYN_BRIDGE.longitude + "|" + WALL_STREET.latitude + ","
//				+ WALL_STREET.longitude;

		String sensor = "sensor=false";
		String params = waypoints + "&" + sensor;
		String output = "json";
		String url = "https://maps.googleapis.com/maps/api/directions/json?origin="+gps.getLatitude()+","+gps.getLongitude()+"&destination="+a.getLat()+","+a.getLng()+"&sensor=false";
		return url;
	}
	
	
	public PlacesList ListRumahSakit()
	{
		PlacesList pl = new PlacesList();
		//Rs porsea
		Place p1 = new Place();
		p1.setNama("Rumah Sakit Porsea");p1.setLat(2.435193);p1.setLng(99.158069); p1.setVicinity("Porsea");p1.setformated_address("Jalan Raja Sipakko N");p1.setPhone("063241084");p1.setStatusAmbulans("YES");
		//Rs balige
		Place p2 = new Place();
		p2.setNama("Rumah Sakit HKBP Balige"); p2.setLat(2.330470);p2.setLng(99.066860);p2.setVicinity("Balige");p2.setformated_address("Jalan Gereja No.17Ba");p2.setPhone("063221043");p2.setStatusAmbulans("YES");
		//Rs harapan
		Place p3 = new Place();
		p3.setNama("Rumah Sakit Harapan"); p3.setLat(2.942602);p3.setLng(99.065732);p3.setVicinity("Siantar");p3.setStatusAmbulans("YES");
		//Rs Horas Insani
		Place p4 = new Place();
		p4.setNama("Rumah Sakit Horas Insani"); p4.setLat(2.977900);p4.setLng(99.079520);p4.setVicinity("Siantar");p4.setStatusAmbulans("YES");
		
		List<Place> places = new ArrayList<Place>();
		places.add(p1);
		places.add(p2);
		places.add(p3);
		places.add(p4);
		
		pl.setstatus("OK");
		pl.setListPlace(places);
		
		return pl;
		
	}
	
	public PlacesList RecomendedRS()
	{
		PlacesList pl =  ListRumahSakit();
		PlacesList pl_new = new PlacesList();
		int jarak_temp=0;
		List<Place> l_new = new ArrayList<Place>();
		//cek yang terdekat -> radius 10 km 
		for(Place tempat : pl.results)
		{
			jarak_temp = calculateDistance(gps.getLatitude(),gps.getLongitude(),tempat.lat,tempat.lng);
			tempat.setJarak(jarak_temp);
			if(jarak_temp <= 30)
			{
				l_new.add(tempat);
			}
		}
		
		//cek available ambulans
		for(Place pn: l_new)
		{
			if(pn.s_ambulans.equals("NO"))
			{
				l_new.remove(pn);
			}
		}
		
		pl_new.setListPlace(l_new);
		
		return pl_new;
	}
	
	public final static double AVERAGE_RADIUS_OF_EARTH = 6371;
	
	public int calculateDistance(double userLat, double userLng,double venueLat, double venueLng) {

	    double latDistance = Math.toRadians(userLat - venueLat);
	    double lngDistance = Math.toRadians(userLng - venueLng);

	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	      + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
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

	private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

		@Override
		protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

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
				polyLineOptions.width(2);
				polyLineOptions.color(Color.BLUE);
			}

			googleMap.addPolyline(polyLineOptions);
		}
	}
	
	
}
