package com.database.gawat;

public class DataAlarm {

	private String id_notification;
	private String status_confirm;
	private String alarm_time;
	private String count_alarm;
	
	public String getId_notification() {
		return this.id_notification;
	}
	public void setId_notification(String id_notification) {
		this.id_notification = id_notification;
	}
	public String getStatus_confirm() {
		return this.status_confirm;
	}
	public void setStatus_confirm(String status_confirm) {
		this.status_confirm = status_confirm;
	}
	public String getAlarm_time() {
		return this.alarm_time;
	}
	public void setAlarm_time(String alarm_time) {
		this.alarm_time = alarm_time;
	}
	public String getCount_alarm() {
		return this.count_alarm;
	}
	public void setCount_alarm(String count_alarm) {
		this.count_alarm = count_alarm;
	}
	
	
}
