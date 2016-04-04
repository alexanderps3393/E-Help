package com.example.gawat;

import java.io.File;
import java.util.ArrayList;

import javax.crypto.spec.IvParameterSpec;

import com.database.gawat.DataDiri;
import com.database.gawat.db_gawat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

	Animation anim;
	Button anButton;
	db_gawat db;
	ArrayList<DataDiri> datadiri;
	TextView viewNamaKorban;
	TextView nama_orang ,
	tempat_lahir , 
	tanggal_lahir , 
	jenis_kelamin ,
	golongan_darah , 
	no_telp , 
	wa, 
	bbm,
	alamat, 
	penyakit_id , 
	 
	status;
	
	ImageView foto;
	String id;
	
	DataDiri model_anak;
	LinearLayout lihatselengkapnya;
	TextView lihat_selengkapnya;
	
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		model_anak = new DataDiri();
		lihatselengkapnya = (LinearLayout) findViewById(R.id.layout_lihatselengkapnya);
		lihat_selengkapnya = (TextView) findViewById(R.id.textview_lihat_selengkapnya);
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
		// Intent intent = getIntent();
		// String op = intent.getStringExtra(MainActivity.KEY_ANIM);
		// if (op.equals(MainActivity.Target_Translate)){
		// anim = AnimationUtils.loadAnimation(SecondActivity.this,
		// R.anim.anim_translate);
		// }else if (op.equals(MainActivity.Target_Alpha)){
		// anim = AnimationUtils.loadAnimation(SecondActivity.this,
		// R.anim.anim_alpha);
		// }else if (op.equals(MainActivity.Target_Scale)){
		// anim = AnimationUtils.loadAnimation(SecondActivity.this,
		// R.anim.anim_scale);
		// }else if (op.equals(MainActivity.Target_Rotate)){
		// anim = AnimationUtils.loadAnimation(SecondActivity.this,
		// R.anim.anim_rotate);
		// }

		db = new db_gawat(this);
		datadiri = new ArrayList<DataDiri>();

		nama_orang  = (TextView) findViewById(R.id.tvNamaKorban);
		tempat_lahir  = (TextView) findViewById(R.id.tvTempatLahir);
		tanggal_lahir  = (TextView) findViewById(R.id.tvTanggalLahir);
		jenis_kelamin  = (TextView) findViewById(R.id.viewJKPasien);
		golongan_darah  = (TextView) findViewById(R.id.tvGolDar);
		no_telp  = (TextView) findViewById(R.id.phone);
//		wa = (TextView) findViewById(R.id.viewALAMATAnak);
//		bbm = (TextView) findViewById(R.id.viewStatusARV);
		alamat = (TextView) findViewById(R.id.tvAlamat);
		penyakit_id  = (TextView) findViewById(R.id.tvpenyakitParah);
		foto = (ImageView) findViewById(R.id.ivPasien);
		status = (TextView) findViewById(R.id.tvStatus);
		
		Intent intent = getIntent();
		id = intent.getStringExtra("id");
//		Toast.makeText(getApplicationContext(), "id :" + id, Toast.LENGTH_SHORT)
//				.show();
		SetTampilanIdentitasAnak();
		no_telp.setOnClickListener(new OnClickListener(){

        	
			   @Override
			   public void onClick(View arg0) {
				   Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData(Uri.parse("tel:"+no_telp.getText().toString()));
					callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
					startActivity(callIntent);
			   }});
//		DataDiri arr = new DataDiri();
//		arr = db.SearchChild(id);
//		if(arr.getNama()!=null)
//		{
//		//String nama = arr.getNama();
//		Toast.makeText(getApplicationContext(), "nama :" + arr.getNama(), Toast.LENGTH_SHORT)
//		.show();
//		viewNamaKorban.setText(arr.getNama());
//		}
	
//	else
//	{
//	Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_SHORT)
//	.show();
//	}
	}
	
	public void SetTampilanIdentitasAnak() {

		model_anak = db.ViewDataDiri(id);

		nama_orang.setText(model_anak.getNama());
		tempat_lahir.setText(model_anak.getTmptLahir());
		tanggal_lahir.setText(model_anak.getTanggalLahir());
		jenis_kelamin.setText(model_anak.getJenKel());
		golongan_darah.setText(model_anak.getGolda());
		no_telp.setText(model_anak.getTelp());
//		wa = (TextView) findViewById(R.id.viewALAMATAnak);
//		bbm = (TextView) findViewById(R.id.viewStatusARV);
		alamat.setText(model_anak.getAlamat());
		penyakit_id.setText(model_anak.getPenyakitId());

		String as = "kosong";
		if (model_anak.getFoto().equals(as)) {
			Bitmap bitmap1 = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.icon);
			foto.setImageBitmap(bitmap1);
		} else {
			File image = new File(model_anak.getFoto());
			BitmapFactory.Options bmOptions = new BitmapFactory.Options();
			Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),
					bmOptions);
			bitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, true);
			foto.setImageBitmap(bitmap);
		}

		
		
		
		status.setText(model_anak.getStatus());
		
	}

}
