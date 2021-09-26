package com.example.demo.service;

import java.util.ArrayList;
import com.example.demo.bean.Planeta;

//En comentarios: la función equivalente en JPA
public interface IBaseDatos {
	public void inserta(Planeta planeta);		//SAVE
	public void borrar(int id);				//DELETE BY ID
	public void modifica(Planeta planeta);		//SAVE
	public Planeta getPlaneta(int id);			//FIND BY ID
	public ArrayList<Planeta> getPlanetas();	//FIND ALL
	public boolean compruebaUsuario(String usuario, String password);

}