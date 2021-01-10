package com.model;
import java.io.Serializable;
public class Meta implements Serializable{
	private float time;//时间
	private float tem;//温度
	private float airhum;//空气湿度
	private float soilhum;//土壤湿度
	private float ph;//ph值
	private float lux;//光照强度
	private float ltime;//光照时间
	
	public Meta() {}
	public Meta(float time,float tem,float airhum,float soilhum,float ph,float lux,float ltime) {
		this.time = time;
		this.tem = tem;
		this.airhum = airhum;
		this.soilhum = soilhum;
		this.ph = ph;
		this.lux = lux;
		this.ltime = ltime;
	}
	public void setTime(float time) {
		this.time = time;
	}
	public float getTime() {
		return this.time;
	}
	public void setTem(float tem) {
		this.tem = tem;
	}
	public float getTem() {
		return this.tem;
	}
	public void setAirhum(float airhum) {
		this.airhum = airhum;
	}
	public float getAirhum() {
		return this.airhum;
	}
	public void setSoilhum(float soilhum) {
		this.soilhum = soilhum;
	}
	public float getSoilhum() {
		return this.soilhum;
	}
	public void setPh(float ph) {
		this.ph = ph;
	}
	public float getPh() {
		return this.ph;
	}
	public void setLux(float lux) {
		this.lux = lux;
	}
	public float getLux() {
		return this.lux;
	}
	public void setLtime(float ltime) {
		this.ltime = ltime;
	}
	public float getLtime() {
		return this.ltime;
	}
	
	

}
