package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.bean.Planeta;

public interface BaseDatos extends JpaRepository<Planeta, Integer> {
	
	/*
	public void inserta(Planeta planeta);		//SAVE
	public void borrar(int id);				//DELETE BY ID
	public void modifica(Planeta planeta);		//SAVE
	public Planeta getPlaneta(int id);			//FIND BY ID
	public ArrayList<Planeta> getPlanetas();	//FIND ALL
	public boolean compruebaUsuario(String usuario, String password);
	*/

}
