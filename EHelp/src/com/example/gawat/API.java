package com.example.gawat;



import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface API {
	@POST("/tb_datadiri")
	void getAll(Callback<ResponHelp> callback);
	
	@GET("/add_tb_datadiri/{id_orang}/{nama_orang}/{tempat_lahir}/{tanggal_lahir}/{golongan_darah}/{nomor_telepon}/{whats_app}/{bbm}/{alamat}/{penyakit_id}/{foto}/{id_pembuat}/{waktu}")
	void simpanDataDiri(@Path("id_orang") String id_orang_, @Path("nama_orang") String nama_orang_, @Path("tempat_lahir") String tempat_lahir
		,@Path("tanggal_lahir") String tanggal_lahir_, @Path("golongan_darah") String golda, @Path("nomor_telepon") String nomor_telepon_, 
		@Path("whats_app") String whats_app_, @Path("bbm") String bbm_, @Path("alamat") String alamat_,
		@Path("penyakit_id") String penyakit_id, @Path("foto") String foto, @Path("id_pembuat") String id_pembuat, @Path("waktu") String waktu,
		Callback<String> callback);
	
	@POST("/tb_keluhan")
	void getKeluhan(Callback<ResponHelp> callback);
	
//	@GET("/add_keluhan/84/SakitPerut/a/s/s/s/s/s/s/s/a/s")
//	void simpanKeluhan(@Query("id_keluhan") String id_keluhan_, @Query("fk_id_orang") String fk_id_orang_, @Query("nama_keluhan") String nama_keluhan_
//		,@Query("foto_keluhan") String foto_keluhan_, @Query("longitude") String longitude_, @Query("latitude") String latitude_, 
//		@Query("jumlah_korban") String jumlahKorban_, @Query("jenis_bantuan") String jenis_bantuan_, @Query("id_pelapor") String id_pelapor_, 
//		@Query("fk_kode_rs") String fk_kode_rs_, @Query("status_keluhan") String status_keluhan_, @Query("waktu_kejadian") String waktu_kejadian_,
//		Callback<String> callback);
	
	@GET("/add_keluhan/{id_keluhan}/{fk_id_orang}/{nama_keluhan}/{foto_keluhan}/{longitude}/{latitude}/{jumlah_korban}/{jenis_bantuan}/{id_pelapor}/{fk_kode_rs}/{status_keluhan}/{waktu_kejadian}")
	void simpanKeluhan(@Path("id_keluhan") String id_keluhan_, @Path("fk_id_orang") String fk_id_orang_, @Path("nama_keluhan") String nama_keluhan_
		,@Path("foto_keluhan") String foto_keluhan_, @Path("longitude") String longitude_, @Path("latitude") String latitude_, 
		@Path("jumlah_korban") String jumlahKorban_, @Path("jenis_bantuan") String jenis_bantuan_, @Path("id_pelapor") String id_pelapor_, 
		@Path("fk_kode_rs") String fk_kode_rs_, @Path("status_keluhan") String status_keluhan_, @Path("waktu_kejadian") String waktu_kejadian_,
		Callback<String> callback);
	
	@POST("/tb_rumahsakit")
	void getRumahsakit(Callback<ResponHelp> callback);
	
	@GET("/add_rs/21112005/06864/email@example.com/1/1/1/1/1")
	void simpanRumahsakit(@Query("kode_rs") String kode_rs_, @Query("rs_no_telp") String rs_no_telp_, @Query("rs_email") String rs_email_
		,@Query("rs_alamat") String rs_alamat_, @Query("rs_longitude") String rs_longitude_, @Query("rs_latitude") String rs_latitude_, 
		@Query("jumlah_ambulance") String jumlah_ambulance_, @Query("status_ambulance") String status_ambulance_,
		Callback<String> callback);
	
	@POST("/tb_ambulance")
	void getAmbulance(Callback<ResponHelp> callback);
	
	@GET("/add_ambulance/21112027/3231")
	void simpanAmbulance(@Query("kode_rs") String kode_rs_, @Query("lokasi") String lokasi_, Callback<String> callback);
	
	@POST("/tb_alarm")
	void getAlarm(Callback<ResponHelp> callback);
	
	@GET("/add_alarm/21112027/3231/a/a")
	void simpanAlarm(@Query("id_notification") String id_notification_, @Query("status_confirm") String status_confirm_,
			@Query("alarm_time") String alarm_time_, @Query("count_alarm") String count_alarm_,
			Callback<String> callback);
	
	@POST("/tb_notification")
	void getNotification(Callback<ResponHelp> callback);
	
	@GET("/add_notification/21112027/3231/a/a")
	void simpanNotifikasi(@Query("id_notification") String id_notification_, @Query("id_orang") String id_orang_,
			@Query("create_time") String create_time_, @Query("status_notification") String status_notification_,
			Callback<String> callback);
	
	@POST("/tb_penyakit")
	void getPenyakit(Callback<ResponHelp> callback);
	
	
	
	@GET("/add_penyakit/34/Kurap")
	void simpanPenyakit(@Query("penyakit_id") String penyakit_id_, @Query("nama_penyakit") String nama_penyakit_,Callback<String> callback);
	
	@GET("/getSearchKeluhan/{kode}")
	void searchkeluhan(@Path("kode") String kode_random_,Callback<ResponHelp> callback);
	
	@GET("/register/{nama_rs}/{kode_reg}/{id_pegawai}/{rs_no_telp}/{rs_alamat}/{jlh_ambulance}/{status_ambulance}")
	void register(@Path("nama_rs") String nama_rs, @Path("kode_reg")String kode_reg,@Path("id_pegawai") String id_pegawai, @Path("rs_no_telp") String rs_no_telp,@Path("rs_alamat") String rs_alamat, @Path("jlh_ambulance") String jlh_ambulance,@Path("status_ambulance") String status_ambulance, Callback<String> callback);
	

//	@POST("/tb_status")
//	void getAll(Callback<ResponseHasilCustomer> callback);
//	
//	
//	@POST("/tb_penyakit")
//	void getAll(Callback<ResponseHasilCustomer> callback);
//
//	@POST("/tb_help")
//	void getAll(Callback<ResponseHasilCustomer> callback);
//
//	@POST("/tb_keluhan")
//	void getAll(Callback<ResponseHasilCustomer> callback);
//
//	@POST("/tb_keluhan")
//	void getAll(Callback<tb_notification> callback);
//	
//	tb_notification
//	tb_alarm
//	tb_ambulance
//	tb_rumahsakit
//	tb_status_ambulance
//	tb_petugas
//	
//	
//	@get()
//	


}
