package com.example.gawat;

import java.util.List;

import com.database.gawat.DataAlarm;
import com.database.gawat.DataAmbulance;
import com.database.gawat.DataDiri;
import com.database.gawat.DataKeluhan;
import com.database.gawat.DataNotification;
import com.database.gawat.DataPenyakit;
import com.database.gawat.DataRs;

public class ResponHelp {
	private String error;
	private List<DataDiri> tb_datadiri;
	private List<DataKeluhan> tb_keluhan;
	private List<DataRs> tb_rumahsakit;
	private List<DataAmbulance> tb_ambulance;
	private List<DataAlarm> tb_alarm;
	private List<DataNotification> tb_notification;
	private List<DataPenyakit> tb_penyakit;

	
	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public List<DataDiri> getDataDiri() {
		return this.tb_datadiri;
	}

	public void setHasilDataDiri(List<DataDiri> datadiri) {
		this.tb_datadiri= datadiri;
	
	}
	
	public List<DataKeluhan> getDataKeluhan() {
		return this.tb_keluhan;
	}

	public void setHasilDataKeluhan(List<DataKeluhan> datakeluhan) {
		this.tb_keluhan= datakeluhan;
		
	}
	
	public List<DataRs> getDataRumahsakit() {
		return this.tb_rumahsakit;
	}

	public void setHasilDataRumahsakit(List<DataRs> datarumahsakit) {
		this.tb_rumahsakit= datarumahsakit;
		
	}
	
	public List<DataAmbulance> getDataAmbulance() {
		return this.tb_ambulance;
	}

	public void setHasilDataAmbulance(List<DataAmbulance> dataambulance) {
		this.tb_ambulance= dataambulance;
		
	}
	
	public List<DataAlarm> getDataAlarms() {
		return this.tb_alarm;
	}

	public void setHasilDataAlarm(List<DataAlarm> dataalarm) {
		this.tb_alarm= dataalarm;		
	}
	
	public List<DataNotification> getDataNotification() {
		return this.tb_notification;
	}

	public void setHasilDataNotification(List<DataNotification> datanotification) {
		this.tb_notification= datanotification;		
	}
	
	public List<DataPenyakit> getDataPenyakit() {
		return this.tb_penyakit;
	}

	public void setHasilDataPenyakit(List<DataPenyakit> datapenyakit) {
		this.tb_penyakit= datapenyakit;
		
	}
}
