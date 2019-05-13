package com.zm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zm.dao.FileAttrDao;
import com.zm.model.FileAttr;
import com.zm.service.FileAttrService;

/**   
 * @ClassName:  FileAttrServiceImpl   
 * @Description:服务接口实现  
 * @author: ZhaoMao 
 * @date:   2019年5月13日 上午9:45:39   
 *     
 */
@Service
public class FileAttrServiceImpl implements FileAttrService {

	@Resource
	FileAttrDao fileattrDao;
	
	/**   
	 * <p>Title: queryAll</p>   
	 * <p>Description: 查询所有</p>   
	 * @return List<FileAttr>
	 * @see com.zm.service.FileAttrService#queryAll()   
	 */
	public List<FileAttr> queryAll() {
		return fileattrDao.queryall();
	}
	
}
