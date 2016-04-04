package com.example.gawat;

import java.io.File;
import java.util.ArrayList;








import com.database.gawat.DataDiri;
import com.database.gawat.db_gawat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

public class Grid extends Activity implements OnQueryTextListener {

	ListView lv;
	SearchView search_view;
	ArrayAdapter<String> adapter;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	final Context context = this;
	GridView gridView;
	CustomGridViewAdapter customGridAdapter;
	Bitmap bitmap1;
	db_gawat db;
	ArrayList<DataDiri> datadiri;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid);
		
		onResume();
		//getintent
		Intent intent = getIntent();
		String id_pembuat = intent.getStringExtra("id_pembuat");
		
		db = new db_gawat(this);
		datadiri = new ArrayList<DataDiri>();
		
		ArrayList<DataDiri> arr = new ArrayList<DataDiri>();
		
		arr = db.getSemuaDataPasien();
		
		lv = (ListView) findViewById(R.id.list_view);
		search_view = (SearchView) findViewById(R.id.search_view);
		
		
		lv.setAdapter(adapter);
		
		search_view.setOnQueryTextListener(this);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					final int arg2, long arg3) {
				
				
//				Intent i = new Intent(getApplicationContext(),
//						Selanjutnya.class);
//				i.putExtra("id_child", "" + iniId);
//				startActivity(i);
			}
		});

		
		// set grid view item
		for (DataDiri dd : arr) {
			String as = "kosong";
			if (dd.getIdPembuat().equals(id_pembuat)) {
			if (dd.getFoto().equals(as)) {
				Bitmap bitmap1 = BitmapFactory.decodeResource(
						context.getResources(), R.drawable.icon);
				
		gridArray.add(new Item(dd.getIdOrang(), dd.getNama(),
						bitmap1.createScaledBitmap(bitmap1, 120, 120, false)));
			
			}
			else {
				File image = new File(dd.getFoto());

				BitmapFactory.Options bmOptions = new BitmapFactory.Options();

				Bitmap bitmap = BitmapFactory.decodeFile(
						image.getAbsolutePath(), bmOptions);

				bitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, true);

				gridArray.add(new Item(dd.getIdOrang(), dd.getNama(),
						bitmap.createScaledBitmap(bitmap, 120, 120, false)));
			}
		}
			
		gridView = (GridView) findViewById(R.id.gridViewAll);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid,
				gridArray);
		gridView.setAdapter(customGridAdapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long arg3) {
				
				
				Intent intent3 = new Intent(Grid.this,
						SecondActivity.class);
//				// kirim id anak ke aktivity kunjungan anak
//
				intent3.putExtra("id", gridArray.get(position).getId());
				startActivity(intent3);
				
			}
		});
		
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
	
	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub

		return false;
	}
	


	 

	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		if (newText.length() > 0) {
			// Search
			lv.setVisibility(View.VISIBLE);
			adapter.getFilter().filter(newText);
		} else {
			// Do something when there's no input
			lv.setVisibility(View.INVISIBLE);
		}

		return true;
	}
	
	 @Override
	    public void onResume() {
	        super.onResume();
	        // Update your UI here.
	    }
	 
	 
}
