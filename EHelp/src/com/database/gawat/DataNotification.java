package com.database.gawat;

public class DataNotification {

	private String id_notification;
	private String id_orang;
	private String create_time;
	private String status_notification;
	
	public String getId_notification() {
		return this.id_notification;
	}
	public void setId_notification(String id_notification) {
		this.id_notification = id_notification;
	}
	public String getId_orang() {
		return this.id_orang;
	}
	public void setId_orang(String id_orang) {
		this.id_orang = id_orang;
	}
	public String getCreate_time() {
		return this.create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getStatus_notification() {
		return this.status_notification;
	}
	public void setStatus_notification(String status_notification) {
		this.status_notification = status_notification;
	}
}
