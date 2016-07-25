package com.surf.brands.model;

import java.util.List;

import org.hibernate.Session;

public interface BrandsDAO {

	Session getSession();

	List<BrandsVO> selectAll();

	BrandsVO insert(BrandsVO bean);

	BrandsVO update(BrandsVO bean);

	boolean delete(BrandsVO bean);

	BrandsVO select(Integer brandno);

}