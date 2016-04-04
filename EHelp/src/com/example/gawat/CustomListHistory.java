package com.example.gawat;

import java.util.List;


import android.R.drawable;
import android.R.layout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


@SuppressLint("ResourceAsColor")
public class CustomListHistory extends ArrayAdapter<String> {
	private final Activity context;
	private final String lokasi[];
	private final String waktu[];
	private final String nama[];
	private final String keluhan[];
	
	public CustomListHistory(Activity context, String nama[],String keluhan[], String lokasi[],String waktu[]) {
		// TODO Auto-generated constructor stub
		super(context,R.layout.list_items,lokasi);
		this.context = context;
		this.nama =  nama;
		this.keluhan = keluhan;
		this.lokasi =  lokasi;
		this.waktu = waktu;
	}
	
	
	public View getView(int position, View view, ViewGroup parent)
	{
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.activity_custom_list_history, null, true);
		
		  TextView txtNama = (TextView) rowView.findViewById(R.id.viewNamaKorban);
		  txtNama.setText(nama[position]);
		  
		  TextView txtkeluhan = (TextView) rowView.findViewById(R.id.viewKeluhan);
		  txtkeluhan.setText(keluhan[position]);
		  
		  TextView txtLokasi = (TextView) rowView.findViewById(R.id.viewLokasiKorban);
		  txtLokasi.setText(lokasi[position]);
		  
		  TextView txtWaktu = (TextView) rowView.findViewById(R.id.viewKeluhan);
		  txtWaktu.setText(waktu[position]);
		  
		  return rowView;
	}
	
}
