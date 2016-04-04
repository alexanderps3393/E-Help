package com.database.gawat;

public class DataRs {
	private  String nama_rs;
	private  String kode_rs;
	private String rs_no_telp;
	private  String rs_email;
	private  String rs_alamat;
	private  String rs_longitude;
	private  String rs_latitude;
	private  String jumlah_ambulance ;
	private  String status_ambulance;
	
	public String getnama_rs()
	{
		return this.nama_rs;
	}
	public String getkode_rs()
	{
		return this.kode_rs;
	}
	public String getrs_no_telp()
	{
		return this.rs_no_telp;
	}
	public String getrs_email()
	{
		return this.rs_email;
	}
	public String getrs_alamat()
	{
		return this.rs_alamat;
	}
	public String getrs_longitude()
	{
		return this.rs_longitude;
	}
	public String getrs_latitude()
	{
		return this.rs_latitude;
	}
	public String getjumlah_ambulance()
	{
		return this.jumlah_ambulance;
	}
	public String getstatus_ambulance()
	{
		return this.status_ambulance;
	}
	
	//setter
	public void setnama_rs(String nama_rs)
	{
		this.nama_rs =nama_rs ;
	}
	public void setkode_rs(String kode_rs)
	{
		this.kode_rs =kode_rs ;
	}
	public void setrs_no_telp(String rs_no_telp)
	{
		this.rs_no_telp =rs_no_telp;
	}
	public void setrs_email(String rs_email)
	{
		this.rs_email=rs_email;
	}
	public void setrs_alamat(String rs_alamat)
	{
		this.rs_alamat=rs_alamat;
	}
	public void setrs_longitude(String rs_longitude)
	{
		this.rs_longitude=rs_longitude;
	}
	public void setrs_latitude(String rs_latitude)
	{
		this.rs_latitude=rs_latitude;
	}
	public void setjumlah_ambulance(String jumlah_ambulance)
	{
		this.jumlah_ambulance=jumlah_ambulance;
	}
	public void setstatus_ambulance(String status_ambulance)
	{
		this.status_ambulance=status_ambulance;
	}
	
	 
}
