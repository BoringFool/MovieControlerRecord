package com.zm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.zm.model.FileAttr;
import com.zm.service.FileAttrService;

/**   
 * @ClassName:  FileAttrController   
 * @Description: 文件操作Conttroller  
 * @author: ZhaoMao 
 * @date:   2019年5月13日 上午9:48:24   
 *     
 */
@Controller
public class FileAttrController {

	@Resource
	FileAttrService filerService;
	
	/**   
	 * @Title: queryAll   
	 * @Description: 查询所有  
	 * @param: @return      
	 * @return: List<FileAttr>      
	 * @throws   
	 */
	public List<FileAttr> queryAll(){
		return filerService.queryAll();
	}
}
