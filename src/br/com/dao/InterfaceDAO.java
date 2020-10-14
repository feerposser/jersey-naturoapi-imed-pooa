package br.com.dao;

import java.util.ArrayList;

public interface InterfaceDAO <T> {
	
	public boolean insert(T t); // C
	
	// R
	public T findById(int id);
	public ArrayList<T> findAll();
	
	public boolean update(T t); 	// U
	
	public boolean delete(int id); // D
	
}
