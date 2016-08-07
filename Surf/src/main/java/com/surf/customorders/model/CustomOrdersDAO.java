package com.surf.customorders.model;

import java.util.List;

import org.hibernate.Session;

public interface CustomOrdersDAO {

	Session getSession();

	CustomOrdersVO insert(CustomOrdersVO bean);

	List<CustomOrdersVO> selectAll(Integer memberno);
	
	CustomOrdersVO select(Integer orderno);
}