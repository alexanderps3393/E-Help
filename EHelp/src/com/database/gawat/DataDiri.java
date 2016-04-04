package com.database.gawat;

public class DataDiri {
	private  String Id_orang;
	private String Id_pembuat;
	private  String Nama_orang;
	private  String Tempat_lahir;
	private  String Tanggal_lahir;
	private  String jenis_kelamin;
	private  String Golda;
	private  String Telp;
	private  String Wa;
	private  String BBM;
	private  String Alamat;
	private  String PenyakitID;
	private  String Foto;
	private  String Waktu;
	private  String status;
	
	public String getIdOrang()
	{
		return this.Id_orang;
	}
	public String getIdPembuat()
	{
		return this.Id_pembuat;
	}
	public String getNama()
	{
		return this.Nama_orang;
	}
	public String getTmptLahir()
	{
		return this.Tempat_lahir;
	}
	public String getTanggalLahir()
	{
		return this.Tanggal_lahir;
	}
	public String getJenKel()
	{
		return this.jenis_kelamin;
	}
	public String getGolda()
	{
		return this.Golda;
	}
	public String getTelp()
	{
		return this.Telp;
	}
	public String getWa()
	{
		return this.Wa;
	}
	public String getBBM()
	{
		return this.BBM;
	}
	
	public String getAlamat()
	{
		return this.Alamat;
	}
	public String getPenyakitId()
	{
		return this.PenyakitID;
	}
	public String getFoto()
	{
		return this.Foto;
	}
	public String getWaktu()
	{
		return this.Waktu;
	}
	public String getStatus()
	{
		return this.status;
	}
	
	//setter
	public void setIdOrang(String id_orang)
	{
		this.Id_orang=id_orang;
	}
	public void setIdPembuat(String id_pembuat)
	{
		this.Id_pembuat =id_pembuat;
	}
	public void setNama(String nama)
	{
		this.Nama_orang=nama;
	}
	public void setTmpLahir(String tempat)
	{
		this.Tempat_lahir=tempat;
	}
	public void setTglLahir(String tanggal)
	{
		this.Tanggal_lahir=tanggal;
	}
	public void setJenKel(String JenKel)
	{
		this.jenis_kelamin=JenKel;
	}
	public void setGolda(String golda)
	{
		this.Golda=golda;
	}
	public void setNotelp(String notelp)
	{
		this.Telp=notelp;
	}
	public void setWa(String wa)
	{
		this.Wa=wa;
	}
	public void setBBM(String bbm)
	{
		this.BBM=bbm;
	}
	public void setAlamat(String alamat)
	{
		this.Alamat=alamat;
	}
	public void setPenyakitId(String penyakit_id)
	{
		this.PenyakitID=penyakit_id;
	}
	public void setFoto(String foto)
	{
		this.Foto=foto;
	}
	public void setWaktu(String waktu)
	{
		this.Waktu=waktu;
	}
	public void setStatus(String status)
	{
		this.status=status;
	}
	 
}
