package com.example.gawat;

import java.util.ArrayList;
import java.util.List;









import com.database.gawat.DataAlarm;
import com.database.gawat.DataAmbulance;
import com.database.gawat.DataDiri;
import com.database.gawat.DataKeluhan;
import com.database.gawat.DataNotification;
import com.database.gawat.DataPenyakit;
import com.database.gawat.DataRs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class TestAPIActivity extends Activity {

	Context myContext;
	ProgressDialog progress;
	TextView a;
	List<DataDiri> list_;
	List<DataKeluhan> listkeluhan_;
	List<DataRs> listRS_;
	List<DataAmbulance> listAmbulance_;
	List<DataAlarm> listAlarm_;
	List<DataNotification> listNotification_;
	List<DataPenyakit> listPenyakit_;

	
	DataDiri dd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_api);
		
		myContext = getApplicationContext();
		a = (TextView) findViewById(R.id.test);
		list_ = new ArrayList<DataDiri>();
		listkeluhan_ = new ArrayList<DataKeluhan>();
		dd = new DataDiri();
		RESTClient.get().simpanDataDiri("", "", "", "", "", "", "", "", "", "", "", "","", new Callback<String>()
				
				{
			@Override
			public void success(String arg0, Response arg1) {
				// TODO Auto-generated method stub
				if(arg0.equals("benar")){
//					Toast.makeText(getApplicationContext(),"benar!",Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Gagal",Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"Gagal Kirim api!"+arg0.toString(),
						Toast.LENGTH_LONG).show();
			}	
				});
		//progress = ProgressDialog.show(getApplicationContext(), "Inisialisasi Data", "Sedang Mengunduh Data Untuk Aplikasi", true);
		//Get All DataDiri
		
		/*RESTClient.get().getAll((new Callback<ResponHelp>(){
		@Override
			public void failure(RetrofitError error) {
			// TODO Auto-generated method stub
			// progress.dismiss();
			 Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL"+error.getMessage(), Toast.LENGTH_LONG).show();
			}
		@Override
		 public void success(ResponHelp hasil, Response response) {
		 // TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "Yuhu sukses"+hasil.getDataDiri().size(), Toast.LENGTH_LONG).show();
			list_ = hasil.getDataDiri();
			for(DataDiri a : list_)
			{
				Toast.makeText(getApplicationContext(), a.getNama(), Toast.LENGTH_LONG).show();
			}
		}
		}));
		
		//Insert DataDiri
		RESTClient.get().simpanDataDiri("", "", "", "", "", "", "", "", "", "", "", "","", new Callback<String>()
		
				{
			@Override
			public void success(String arg0, Response arg1) {
				// TODO Auto-generated method stub
				if(arg0.equals("benar")){
					Toast.makeText(getApplicationContext(),"benar!",Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Gagal",Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"Gagal Kirim api!"+arg0.toString(),
						Toast.LENGTH_LONG).show();
			}	
				});
			
		//Get All Keluhan
		
		RESTClient.get().getKeluhan((new Callback<ResponHelp>(){
			@Override
				public void failure(RetrofitError error) {
				// TODO Auto-generated method stub
				// progress.dismiss();
				 Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL"+error.getMessage(), Toast.LENGTH_LONG).show();
				}
			@Override
			 public void success(ResponHelp hasilkeluhan, Response response) {
			 // TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Yuhu sukses"+hasilkeluhan.getDataKeluhan().size(), Toast.LENGTH_LONG).show();
				listkeluhan_ = hasilkeluhan.getDataKeluhan();
				for(DataKeluhan a : listkeluhan_)
				{
					Toast.makeText(getApplicationContext(), a.getNamaKeluhan(), Toast.LENGTH_LONG).show();
				}
			}
			}));	
			*/
		
		//Insert Keluhan
/*		RESTClient.get().simpanKeluhan("", "", "", "", "", "", "", "", "", "", "", "", new Callback<String>()
				
				{
			@Override
			public void success(String arg0, Response arg1) {
				// TODO Auto-generated method stub
				if(arg0.equals("benar")){
					Toast.makeText(getApplicationContext(),"benar!",Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Gagal"+arg0.toString(),Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"Gagal Kirim api!"+arg0.toString(),
						Toast.LENGTH_LONG).show();
			}	
				});
*/	
//		//Get All Rumahsakit
//		RESTClient.get().getRumahsakit((new Callback<ResponHelp>(){
//			@Override
//				public void failure(RetrofitError error) {
//				// TODO Auto-generated method stub
//				// progress.dismiss();
//				 Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL"+error.getMessage(), Toast.LENGTH_LONG).show();
//				}
//			@Override
//			 public void success(ResponHelp hasil, Response response) {
//			 // TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "Berhasil"+hasil.getDataRumahsakit().size(), Toast.LENGTH_LONG).show();
//				listRS_ = hasil.getDataRumahsakit();
//				for(DataRs a : listRS_)
//				{
//					Toast.makeText(getApplicationContext(), a.getkode_rs(), Toast.LENGTH_LONG).show();
//				}
//			}
//			}));	
//		
//		//Insert Rumahsakit
//		RESTClient.get().simpanRumahsakit("", "", "", "", "", "", "", "",new Callback<String>()
//				
//				{
//			@Override
//			public void success(String arg0, Response arg1) {
//				// TODO Auto-generated method stub
//				if(arg0.equals("benar")){
//					Toast.makeText(getApplicationContext(),"benar!",Toast.LENGTH_LONG).show();
//				} else {
//					Toast.makeText(getApplicationContext(),
//							"Gagal",Toast.LENGTH_LONG).show();
//				}
//			}
//
//			@Override
//			public void failure(RetrofitError arg0) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(),
//						"Gagal Kirim api!"+arg0.toString(),
//						Toast.LENGTH_LONG).show();
//			}	
//				});
		
		
		//Insert DataDiri
//		RESTClient.get().simpanDataDiri("123", "2312", "3123", "3123", "", "", "", "", "", "", "", "","", new Callback<String>()
//				
//						{
//					@Override
//					public void success(String arg0, Response arg1) {
//						// TODO Auto-generated method stub
//						if(arg0.equals("benar")){
//							Toast.makeText(getApplicationContext(),"berhasil simpan data dri",Toast.LENGTH_LONG).show();
//						} else {
//							Toast.makeText(getApplicationContext(),
//									"Gagal",Toast.LENGTH_LONG).show();
//						}
//					}
//
//					@Override
//					public void failure(RetrofitError arg0) {
//						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(),
//								"Gagal Kirim api data diri!"+arg0.toString(),
//								Toast.LENGTH_LONG).show();
//					}	
//						});
				
		//get ambulance
	/*	RESTClient.get().getAmbulance((new Callback<ResponHelp>(){
			@Override
				public void failure(RetrofitError error) {
				// TODO Auto-generated method stub
				// progress.dismiss();
				 Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL"+error.getMessage(), Toast.LENGTH_LONG).show();
				}
			@Override
			 public void success(ResponHelp hasil, Response response) {
			 // TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Yuhu sukses"+hasil.getDataAmbulance().size(), Toast.LENGTH_LONG).show();
				listAmbulance_ = hasil.getDataAmbulance();
				for(DataAmbulance a : listAmbulance_)
				{
					Toast.makeText(getApplicationContext(), a.getKode_rs(), Toast.LENGTH_LONG).show();
				}
			}
			}));*/
		//insert ambulance
/*		RESTClient.get().simpanAmbulance("", "", new Callback<String>()
				
				{
			@Override
			public void success(String arg0, Response arg1) {
				// TODO Auto-generated method stub
				if(arg0.equals("benar")){
					Toast.makeText(getApplicationContext(),"benar!",Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Gagal",Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"Gagal Kirim api!"+arg0.toString(),
						Toast.LENGTH_LONG).show();
			}	
				});*/
		//get alarm
		/*RESTClient.get().getAlarm((new Callback<ResponHelp>(){
			@Override
				public void failure(RetrofitError error) {
				// TODO Auto-generated method stub
				// progress.dismiss();
				 Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL"+error.getMessage(), Toast.LENGTH_LONG).show();
				}
			@Override
			 public void success(ResponHelp hasil, Response response) {
			 // TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Yuhu sukses"+hasil.getDataAlarms().size(), Toast.LENGTH_LONG).show();
				listAlarm_ = hasil.getDataAlarms();
				for(DataAlarm a : listAlarm_)
				{
					Toast.makeText(getApplicationContext(), a.getAlarm_time(), Toast.LENGTH_LONG).show();
				}
			}
			}));*/
		//insert alarm
/*		RESTClient.get().simpanAlarm("", "", "", "", new Callback<String>()
				
				{
			@Override
			public void success(String arg0, Response arg1) {
				// TODO Auto-generated method stub
				if(arg0.equals("benar")){
					Toast.makeText(getApplicationContext(),"benar!",Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Gagal",Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"Gagal Kirim api!"+arg0.toString(),
						Toast.LENGTH_LONG).show();
			}	
				});
*/
		//get notification
		/*RESTClient.get().getNotification((new Callback<ResponHelp>(){
			@Override
				public void failure(RetrofitError error) {
				// TODO Auto-generated method stub
				// progress.dismiss();
				 Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL"+error.getMessage(), Toast.LENGTH_LONG).show();
				}
			@Override
			 public void success(ResponHelp hasil, Response response) {
			 // TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Yuhu sukses"+hasil.getDataNotification().size(), Toast.LENGTH_LONG).show();
				listNotification_ = hasil.getDataNotification();
				for(DataNotification a : listNotification_)
				{
					Toast.makeText(getApplicationContext(), a.getStatus_notification(), Toast.LENGTH_LONG).show();
				}
			}
			}));
*/		//insert notification
/*		RESTClient.get().simpanNotifikasi("", "","","", new Callback<String>()
				
				{
			@Override
			public void success(String arg0, Response arg1) {
				// TODO Auto-generated method stub
				if(arg0.equals("benar")){
					Toast.makeText(getApplicationContext(),"benar!",Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Gagal",Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"Gagal Kirim api!"+arg0.toString(),
						Toast.LENGTH_LONG).show();
			}	
				});

*/		//get penyakit
/*		RESTClient.get().getPenyakit((new Callback<ResponHelp>(){
			@Override
				public void failure(RetrofitError error) {
				// TODO Auto-generated method stub
				// progress.dismiss();
				 Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL"+error.getMessage(), Toast.LENGTH_LONG).show();
				}
			@Override
			 public void success(ResponHelp hasil, Response response) {
			 // TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Yuhu sukses"+hasil.getDataPenyakit().size(), Toast.LENGTH_LONG).show();
				listPenyakit_ = hasil.getDataPenyakit();
				for(DataPenyakit a : listPenyakit_)
				{
					Toast.makeText(getApplicationContext(), a.getNama_penyakit(), Toast.LENGTH_LONG).show();
				}
			}
			}));
*/		
		//insert penyakit
	/*	RESTClient.get().simpanPenyakit("", "", new Callback<String>()
				
				{
			@Override
			public void success(String arg0, Response arg1) {
				// TODO Auto-generated method stub
				if(arg0.equals("benar")){
					Toast.makeText(getApplicationContext(),"benar!",Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Gagal",Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void failure(RetrofitError arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"Gagal Kirim api!"+arg0.toString(),
						Toast.LENGTH_LONG).show();
			}	
				});*/

	}
		


		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_api, menu);
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
