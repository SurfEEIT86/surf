package com.surf.models.model;

import java.util.List;

import org.hibernate.Session;

import com.surf.models.model.ModelsVO;

public interface ModelsDAO {

	Session getSession();

	List<ModelsVO> selectByBrandno(Integer brandno);
	
	ModelsVO selectByModelno(Integer modelno);
	
	ModelsVO insertOrUpdate(ModelsVO bean);

	boolean delete(ModelsVO bean);

}