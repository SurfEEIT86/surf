package com.surf.products.model;

import java.util.List;

import org.hibernate.Session;

public interface ProductsDAO {

	Session getSession();

	ProductsVO select(Integer productno);

	List<ProductsVO> selectAll();

	ProductsVO insert(ProductsVO bean);

	ProductsVO update(ProductsVO bean);

	boolean delete(ProductsVO bean);

}