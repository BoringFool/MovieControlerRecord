package com.zm.service;

import java.util.List;

import com.zm.model.FileAttr;

public interface FileAttrService {
	
	public List<FileAttr> queryAll();
	
	public List<String> scanFile(String name);
}
