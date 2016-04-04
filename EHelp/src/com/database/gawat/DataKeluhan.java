package com.database.gawat;

public class DataKeluhan {
	
	private  String id_keluhan;
	private  String fk_id_orang;
	private  String nama_keluhan;
	private  String foto_keluhan;
	private  String longitude;
	private  String latitude;
	private  String jumlah_korban;
	private  String jenis_bantuan;
	private  String id_pelapor;
	private  String fk_kode_rs;
	private  String status_keluhan;
	private  String waktu_kejadian;
	private  String idpegawai;
	
	public String getIdKeluhan()
	{
		return this.id_keluhan;
	}
	public String getFk_idorang()
	{
		return this.fk_id_orang;
	}
	public String getNamaKeluhan()
	{
		return this.nama_keluhan;
	}
	public String getFotoKeluhan()
	{
		return this.foto_keluhan;
	}
	public String getLongitude()
	{
		return this.longitude;
	}
	public String getLatitude()
	{
		return this.latitude;
	}
	public String getJumlahKorban()
	{
		return this.jumlah_korban;
	}
	public String getJenisBantuan()
	{
		return this.jenis_bantuan;
	}
	public String getIdPelapor()
	{
		return this.id_pelapor;
	}
	public String getFk_KodeRS()
	{
		return this.fk_kode_rs;
	}
	public String getStatusKeluhan()
	{
		return this.status_keluhan;
	}
	public String getWaktuKejadian()
	{
		return this.waktu_kejadian;
	}
	public String getIdPegawai()
	{
		return this.idpegawai;
	}

	//setter
		public void setIdKeluhan(String id_Keluhan)
		{
			this.id_keluhan=id_Keluhan;
		}
		public void setFkIdOrang(String fk_id_orang)
		{
			this.fk_id_orang=fk_id_orang;
		}
		public void setNamaKeluhan(String nama_keluhan)
		{
			this.nama_keluhan=nama_keluhan;
		}
		public void setFotoKeluhan(String foto_Keluhan)
		{
			this.foto_keluhan=foto_Keluhan;
		}
		public void setLongitude(String longitude)
		{
			this.longitude=longitude;
		}
		public void setLatitude(String latitude)
		{
			this.latitude=latitude;
		}
		public void setJumlahKorban(String jumlahKorban)
		{
			this.jumlah_korban=jumlahKorban;
		}
		public void setJenisBantuan(String jenis_bantuan)
		{
			this.jenis_bantuan=jenis_bantuan;
		}
		public void setId_pelapor(String id_pelapor)
		{
			this.id_pelapor=id_pelapor;
		}
		public void setFk_kode_rs(String fk_kode_rs)
		{
			this.fk_kode_rs=fk_kode_rs;
		}
		public void setStatusKeluhan(String status_keluhan)
		{
			this.status_keluhan=status_keluhan;
		}
		public void setWaktuKejadian(String waktu_kejadian)
		{
			this.waktu_kejadian=waktu_kejadian;
		}
		public void setIdPegawai(String id_pegawai)
		{
			this.waktu_kejadian=id_pegawai;
		}
}