package com.example.gawat;

import java.io.File;

import com.database.gawat.DataDiri;
import com.database.gawat.DataKeluhan;
import com.database.gawat.db_gawat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewKeluhanOrang extends Activity {

	LinearLayout lihatselengkapnya;
	TextView lihat_selengkapnya, viewNamaKeluhan;
	TextView tvNmaKorban, viewBODPasien, viewJKPasien, viewALAMATAnak,
			tvGolDar, viewStatusAnak, viewpenyakitParah, viewTelp;
	TextView TVjamKeluh1,TVjamKeluh2,TVjamKeluh3,TVjamKeluh4,viewWaktuKejadian;
	final Context context = this;
	ImageView foto_keluh1, foto_keluh2, foto_keluh3, foto_keluh4;
	// String
	String id_keluhan, id_grid;
	int count;

	// database dan model
	db_gawat db;
	
	//EditText
	TextView viewJumlah;

	DataKeluhan dataKeluh;
	DataDiri datadiri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_keluhan_orang);
		dataKeluh = new DataKeluhan();
		db = new db_gawat(this);
		
		TVjamKeluh1 = (TextView) findViewById(R.id.TVjamKeluh1OL);
		TVjamKeluh2 = (TextView) findViewById(R.id.TVjamKeluh2OL);
		TVjamKeluh3 = (TextView) findViewById(R.id.TVjamKeluh3OL);
		TVjamKeluh4 = (TextView) findViewById(R.id.TVjamKeluh4OL);
		viewWaktuKejadian = (TextView) findViewById(R.id.viewWaktuKejadian);
		
		foto_keluh1 = (ImageView) findViewById(R.id.foto_keluh1OL);
		foto_keluh2 = (ImageView) findViewById(R.id.foto_keluh2OL);
		foto_keluh3 = (ImageView) findViewById(R.id.foto_keluh3OL);
		foto_keluh4 = (ImageView) findViewById(R.id.foto_keluh4OL);

		viewJumlah = (TextView) findViewById(R.id.viewJumlah);

		

		Intent intent = getIntent();
		id_keluhan = intent.getStringExtra("id_keluhan");
		id_grid = intent.getStringExtra("id_pelapor");
		count = intent.getIntExtra("count",count);


//		viewNamaKeluhan = (TextView) findViewById(R.id.viewNamaKeluhanOL);
//		dataKeluh = db.ViewDataKeluhan(id_keluhan);
//		
//		viewNamaKeluhan.setText(dataKeluh.getNamaKeluhan());
//		viewJumlah.setText(dataKeluh.getJumlahKorban());
//		viewWaktuKejadian.setText(dataKeluh.getWaktuKejadian());
//		TVjamKeluh1.setText(dataKel.getJenisBantuan());
//		TVjamKeluh2.setText(dataKel.getWaktuKejadian().toString());
//		TVjamKeluh3.setText(dataKel.getWaktuKejadian());
//		TVjamKeluh4.setText(dataKel.getWaktuKejadian());
		//SetTampilanIdentitasAnak();

		
	}

	public void SetTampilanIdentitasAnak() {
		// String id_pasien = db.ViewIdByIdKeluhan(id_keluhan);

		//datadiri = db.ViewDataDiri(id_grid);

		String as = "kosong";
//		File image = new File(dataKel.getFotoKeluhan());
//		BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//		Bitmap bitmap = BitmapFactory.decodeFile(
//				image.getAbsolutePath(), bmOptions);
//		bitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, true);
//		foto_keluh1.setImageBitmap(bitmap);
//		foto_keluh2.setImageBitmap(bitmap);
//		foto_keluh3.setImageBitmap(bitmap);
//		foto_keluh4.setImageBitmap(bitmap);
		
		
//		Toast.makeText(getApplicationContext(), "kosong :" + count,
//				Toast.LENGTH_SHORT).show();
//		for(int i =0; i<=count;i++)
//		{
//		File image = new File(dataKel.getFotoKeluhan());
//		BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//		Bitmap bitmap = BitmapFactory.decodeFile(
//				image.getAbsolutePath(), bmOptions);
//		bitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, true);
//		foto_keluh1.setImageBitmap(bitmap);
//		}
		
//		if (dataKel.getFotoKeluhan().equals(as)) {
//			
//			Bitmap bitmap1 = BitmapFactory.decodeResource(
//					context.getResources(), R.drawable.icon);
//			
//			Bitmap bitmap2 = BitmapFactory.decodeResource(
//					context.getResources(), R.drawable.contoh_foto_anak);
//			
//			if (dataKel.getFotoKeluhan().length() == 1) {
//				foto_keluh1.setImageBitmap(bitmap2);
//			} else if (dataKel.getFotoKeluhan().length() == 2) {
//				foto_keluh1.setImageBitmap(bitmap2);
//				foto_keluh2.setImageBitmap(bitmap2);
//			} else if (dataKel.getFotoKeluhan().length() == 3) {
//				foto_keluh1.setImageBitmap(bitmap1);
//				foto_keluh2.setImageBitmap(bitmap1);
//				foto_keluh3.setImageBitmap(bitmap1);
//			} else if (dataKel.getFotoKeluhan().length() == 3) {
//				foto_keluh1.setImageBitmap(bitmap1);
//				foto_keluh2.setImageBitmap(bitmap1);
//				foto_keluh3.setImageBitmap(bitmap1);
//				foto_keluh4.setImageBitmap(bitmap1);
//			}
//
//		} else {
//
//			File image = new File(dataKel.getFotoKeluhan());
//			BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//			Bitmap bitmap = BitmapFactory.decodeFile(
//					image.getAbsolutePath(), bmOptions);
//			bitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, true);
//			
//			Bitmap bitmap1 = BitmapFactory.decodeResource(
//					context.getResources(), R.drawable.contoh_foto_anak);
//			if (dataKel.getFotoKeluhan().length() == 1) {
//				foto_keluh1.setImageBitmap(bitmap1);
//			} else if (dataKel.getFotoKeluhan().length() == 2) {
//				foto_keluh1.setImageBitmap(bitmap1);
//				foto_keluh2.setImageBitmap(bitmap1);
//			} else if (dataKel.getFotoKeluhan().length() == 3) {
//				foto_keluh1.setImageBitmap(bitmap);
//				foto_keluh2.setImageBitmap(bitmap);
//				foto_keluh3.setImageBitmap(bitmap);
//			} else if (dataKel.getFotoKeluhan().length() == 4) {
//				foto_keluh1.setImageBitmap(bitmap);
//				foto_keluh2.setImageBitmap(bitmap);
//				foto_keluh3.setImageBitmap(bitmap);
//				foto_keluh4.setImageBitmap(bitmap);
//			}
//		}

		

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
}
