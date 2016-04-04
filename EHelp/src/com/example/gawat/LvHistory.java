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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class LvHistory extends Activity {

	String names[] = { "BM.Yanti Siregar"};
	String keluhan[] = { "Melahirkan"};
	String waktu[] = { "20-10-2015; 23:05"};
	String lokasi[] = {"jl.pidel no 1"};
	final Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lv_history);
		
		 
		  CustomListHistory adap = new CustomListHistory(this, names,keluhan,lokasi,waktu);
		  
		  final ListView lv = (ListView) findViewById(R.id.listviewHistory);
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

//					String iniId = db.SearchChild(str).getChild_id()
//							.toString();

					// Toast.makeText(getApplicationContext(), ""+str,
					// Toast.LENGTH_LONG).show();
					
					 Intent intent3 = new Intent(LvHistory.this,
								Keluhan.class);
						//intent3.putExtra("id_anak_k", child_id);
						startActivity(intent3);
					//i.putExtra("id_child", "" + iniId);
					
				}
			});
		  
		  

	}

	public void onClick(View view) {
		switch (view.getId()) {
//		case R.id.listviewHistory:
//			 Intent intent3 = new Intent(LvHistory.this,
//						Keluhan.class);
//				//intent3.putExtra("id_anak_k", child_id);
//				startActivity(intent3);
//			break;


		
		default:
			break;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lv_history, menu);
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
