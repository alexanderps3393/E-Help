package com.example.gawat;

import java.io.Serializable;
import java.util.List;

import com.google.api.client.util.Key;

/** Implement this class from "Serializable"
* So that you can pass this class Object to another using Intents
* Otherwise you can't pass to another actitivy
* */
public class PlacesList implements Serializable {

	@Key
	public String status;

	@Key
	public List<Place> results;
	
	public void setstatus(String status)
	{
		this.status = status;
	}
	public void setListPlace (List<Place> places)
	{
		this.results = places;
	}


}