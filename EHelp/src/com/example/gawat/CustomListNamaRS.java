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
public class CustomListNamaRS extends ArrayAdapter<String> {
 private final Activity context;
 private final String namaRS[];
 private final String jarak[];
 private final String alamatRS[];
 
 
 public CustomListNamaRS(Activity context, String namaRS[], String jarak[], String alamatRS[]) {
  // TODO Auto-generated constructor stub
  super(context,R.layout.list_items,namaRS);
  this.context = context;
  this.namaRS =  namaRS;
  this.jarak = jarak;
  this.alamatRS = alamatRS;
 }
 
 
 public View getView(int position, View view, ViewGroup parent)
 {
  LayoutInflater inflater = context.getLayoutInflater();
  View rowView = inflater.inflate(R.layout.activity_custom_list_nama_rs, null, true);
  
    TextView txtNama = (TextView) rowView.findViewById(R.id.TVnamaRSRekom);
    txtNama.setText(namaRS[position]);
    
    TextView txtContent = (TextView) rowView.findViewById(R.id.TVAlamatRSRekom);
    txtContent.setText(jarak[position]);
    
    TextView txtWaktu = (TextView) rowView.findViewById(R.id.TVJarakRSRekom);
    txtWaktu.setText(alamatRS[position]);
    
   
    return rowView;
 }
 
}