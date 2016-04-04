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
public class CustomListKeluhan extends ArrayAdapter<String> {
	private final Activity context;
	private final String web[];
	
	public CustomListKeluhan(Activity context, String web[]) {
		// TODO Auto-generated constructor stub
		super(context,R.layout.list_items,web);
		this.context = context;
		this.web =  web;
		
	}
	
	
	public View getView(int position, View view, ViewGroup parent)
	{
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.list_items, null, true);
		
		  ImageView img = (ImageView) rowView.findViewById(R.id.img);
		  
		  TextView txtHelp = (TextView) rowView.findViewById(R.id.name);
		  txtHelp.setText(web[position]);
		  
		  String s= web[position];
		  if(s.startsWith("Ambulance"))
		  {
			  img.setImageResource(R.drawable.pemkeb);
			 
		  }
		  else
		  {
			  img.setImageResource(R.drawable.ambulance_icon);
		  }
		  
		  
		  return rowView;
	}
	
}
