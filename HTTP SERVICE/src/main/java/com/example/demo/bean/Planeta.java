package com.example.demo.bean;

import javax.persistence.*;


@Entity
@Table(name="planetas")

public class Planeta { 

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;

	@Column(name="nombre", nullable=false, length=30)
	private String nombre;
	private float masa;
	private float radio;
	private float orbitradio;	
	private float gravedad;
	private float rotacion;
	private float orbita;

	public Planeta(int id, String nombre, float masa, float radio, float orbitradio, float gravedad, float rotacion, float orbita) {
		this.id = id;
		this.nombre = nombre;
		this.masa = masa;
		this.radio = radio;
		this.orbitradio = orbitradio;
		this.gravedad = gravedad;
		this.orbita = orbita;
	}
	
	public Planeta() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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