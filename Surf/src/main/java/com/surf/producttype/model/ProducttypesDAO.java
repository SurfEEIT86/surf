package com.surf.producttype.model;

import java.util.List;

import org.hibernate.Session;

public interface ProducttypesDAO {

	Session getSession();

	List<ProducttypesVO> selectAll();

	ProducttypesVO select(Integer typeno);

	ProducttypesVO insert(ProducttypesVO bean);

	ProducttypesVO update(ProducttypesVO bean);

	boolean delete(ProducttypesVO bean);

}