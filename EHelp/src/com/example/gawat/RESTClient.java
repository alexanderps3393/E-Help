package com.example.gawat;

import retrofit.RestAdapter;

public class RESTClient {
	private static API REST_CLIENT;
	private static String URL_ORIFLAME = "http://192.168.43.5/gawat/";
	static { 
		setupRestClient();
	}

	private RESTClient() {
	}
	
	public static API get() {
		return REST_CLIENT;
	}

	private static void setupRestClient() {
		RestAdapter builder = new RestAdapter.Builder().setEndpoint(URL_ORIFLAME).build();

		REST_CLIENT = builder.create(API.class);
	}
}