package com.example.gawat;


import java.io.Serializable;

import com.google.api.client.util.Key;

/** Implement this class from "Serializable"
* So that you can pass this class Object to another using Intents
* Otherwise you can't pass to another actitivy
* */
public class Place implements Serializable {

	@Key
	public String id;
	
	@Key
	public String name;
	
	@Key
	public String reference;
	
	@Key
	public String icon;
	
	@Key
	public String vicinity;
	
	@Key
	public Geometry geometry;
	
	@Key
	public String formatted_address;
	
	@Key
	public String formatted_phone_number;
	
	
	@Key
	public Double lat;
	
	@Key
	public Double lng;
	
	
	@Key
	public int jarak;
	
	@Key
	public String s_ambulans;

	@Override
	public String toString() {
		return name + " - " + id + " - " + reference;
	}
	
	public static class Geometry implements Serializable
	{
		@Key
		public Location location;
		
		public void setLocation(Location a)
		{
			this.location = a;
		}
		
		public Location getLocation()
		{
			return this.location;
		}
	}
	
	public static class Location implements Serializable
	{
		@Key
		public double lat;
		
		@Key
		public double lng;
		
		public double getlat()
		{
			return this.lat;
		}
		public double getlng()
		{
			return this.lng;
		}
		public void setlat(double lat)
		{
			this.lat = lat;
		}
		public void setlng(double lng)
		{
			this.lng = lng;
		}
	}
	
	public void setNama(String nama)
	{
		this.name = nama;
	}
	
	public void  setGeometry(Geometry g)
	{
		this.geometry = g;
	}
	
	public String getNama()
	{
		return this.name;
	}
	
	public Geometry getGeometry()
	{
		return this.geometry;
	}
	
	public void setLat(Double lat)
	{
		this.lat = lat;
	}
	
	public void setLng(Double lng)
	{
		this.lng = lng;
	}
	
	public Double getLat()
	{
		return this.lat;
	}
	
	public Double getLng()
	{
		return this.lng;
	}
	
	public String getVicinity()
	{
		return this.vicinity;
	}
	
	public void setVicinity(String vici)
	{
		this.vicinity = vici;
	}
	
	public String getformated_address()
	{
		return this.formatted_address;
	}
	
	public void setformated_address(String address)
	{
		this.formatted_address = address;
	}
	
	public String getPhone()
	{
		return this.formatted_phone_number;
	}
	
	public void setPhone(String phone)
	{
		this.formatted_phone_number = phone;
	}
	
	public int getJarak()
	{
		return this.jarak;
	}
	
	public void setJarak(int jarak)
	{
		this.jarak = jarak;
	}
	
	public String getStatusAmbulans()
	{
		return this.s_ambulans;
	}
	
	public void setStatusAmbulans(String status)
	{
		this.s_ambulans = status;
	}
}
