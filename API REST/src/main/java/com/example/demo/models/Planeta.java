package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planetas")
public class Planeta {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="name", nullable=false, length=30)
	private String name;
	private float masa;
	private float radio;
	private float orbitradio;
	private float gravedad;
	private float rotacion;
	private float orbita;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMasa() {
		return masa;
	}
	public void setMasa(float masa) {
		this.masa = masa;
	}
	public float getRadio() {
		return radio;
	}
	public void setRadio(float radio) {
		this.radio = radio;
	}
	public float getOrbitradio() {
		return orbitradio;
	}
	public void setOrbitradio(float orbitradio) {
		this.orbitradio = orbitradio;
	}
	public float getGravedad() {
		return gravedad;
	}
	public void setGravedad(float gravedad) {
		this.gravedad = gravedad;
	}
	public float getRotacion() {
		return rotacion;
	}
	public void setRotacion(float rotacion) {
		this.rotacion = rotacion;
	}
	public float getOrbita() {
		return orbita;
	}
	public void setOrbita(float orbita) {
		this.orbita = orbita;
	}
}
