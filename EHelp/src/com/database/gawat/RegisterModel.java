package com.database.gawat;

public class RegisterModel {
	private  String namars_reg;
	private  String kode_reg;
	private String id_pegawai;
	private  String rs_no_telp;
	private  String rs_alamat;
	private  String jumlah_ambulance;
	private  String status_ambulance;
	
	
	public String getnamars_reg()
	{
		return this.namars_reg;
	}
	public String getkode_reg()
	{
		return this.kode_reg;
	}
	public String getid_pegawai()
	{
		return this.id_pegawai;
	}
	public String getrs_no_telp()
	{
		return this.rs_no_telp;
	}
	public String getrs_alamat()
	{
		return this.rs_alamat;
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
	public void setnamars_reg(String namars_reg)
	{
		this.namars_reg =namars_reg ;
	}
	public void setkode_reg(String kode_reg)
	{
		this.kode_reg =kode_reg ;
	}
	public void setid_pegawai(String id_pegawai)
	{
		this.id_pegawai =id_pegawai;
	}
	public void setrs_no_telp(String rs_no_telp)
	{
		this.rs_no_telp =rs_no_telp;
	}
	public void setrs_alamat(String rs_alamat)
	{
		this.rs_alamat =rs_alamat;
	}
	public void setjumlah_ambulance(String jumlah_ambulance)
	{
		this.jumlah_ambulance =jumlah_ambulance;
	}
	public void setstatus_ambulance(String id_pegawai)
	{
		this.status_ambulance =status_ambulance;
	}
	 
}
