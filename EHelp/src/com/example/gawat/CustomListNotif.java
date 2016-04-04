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
public class CustomListNotif extends ArrayAdapter<String> {
	private final Activity context;
	private final String nama[];
	private final String content[];
	private final String waktu[];
	
	
	public CustomListNotif(Activity context, String nama[], String[] content, String[] waktu) {
		// TODO Auto-generated constructor stub
		super(context,R.layout.list_items,nama);
		this.context = context;
		this.nama =  nama;
		this.content = content;
		this.waktu = waktu;
	}
	
	
	public View getView(int position, View view, ViewGroup parent)
	{
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.activity_custom_list_notif, null, true);
		
		  ImageView img = (ImageView) rowView.findViewById(R.id.imgNotif);
		  
		  TextView txtNama = (TextView) rowView.findViewById(R.id.TVnamaNotif);
		  txtNama.setText(nama[position]);
		  
		  TextView txtContent = (TextView) rowView.findViewById(R.id.TVcontentNotif);
		  txtContent.setText(content[position]);
		  
		  TextView txtWaktu = (TextView) rowView.findViewById(R.id.TVWaktuNotif);
		  txtWaktu.setText(waktu[position]);
		  
		  img.setImageResource(R.drawable.icon);
//		  
		  return rowView;
	}
	
}
