package com.zm.dao;

import java.util.List;

import com.zm.model.FileAttr;

public interface FileAttrDao {

	public List<FileAttr> queryall();
	
	public FileAttr queryById(String id);
	
	public FileAttr queryByName(String fname);
	
	public void add(FileAttr fileattr);

	public void deleteById(String id);
	
	public void updateById(FileAttr fileattr);
}
