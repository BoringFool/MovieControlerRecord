package com.zm.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
    
    private static Logger logger = Logger.getLogger(FileAttrServiceImpl.class);

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

    /**   
     * <p>Title: scanFile</p>   
     * <p>Description: 扫描指定U盘内的文件</p>   
     * @param name
     * @return List<String> 符合要求的文件夹名集合
     * @see com.zm.service.FileAttrService#scanFile(java.lang.String)   
     */
    @Override
    public List<String> scanFile(String name) {
        File file = new File(name);
        
        if(!file.exists()) {
            logger.debug("文件不存在！");
            return null;
        }
        
        String[] subList = file.list();
        List<String> sub = new ArrayList<>();
        for(String s : subList) {
            if(s.indexOf("_") != -1) {
                s = s.substring(0, s.indexOf("_"));
                sub.add(s);
            }
        }
        return sub;
    }
	
}
