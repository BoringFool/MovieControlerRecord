package com.zm.model;

/**   
 * @ClassName:  FileAttr   
 * @Description:文件实体类  
 * @author: ZhaoMao 
 * @date:   2019年5月13日 上午9:49:28   
 *     
 */
public class FileAttr {

	private String id;//主键
	private String fname;//剧名
	private int episodes;//集数
	private int season;//季数
	private int finished;//已看集数
	private int totalNum;//已下载，但未观看数
	private String state;//在播/停播/被砍/续约/…
	private String updateDate;//更新日期
	private String backDate;//下季回归时间
	private int attention;//关注程度，为数字，100为最想
	private int unused;//是否存在未下载剧集
	private int top;//已下载最新一集数
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getEpisodes() {
		return episodes;
	}
	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public int getFinished() {
		return finished;
	}
	public void setFinished(int finished) {
		this.finished = finished;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getBackDate() {
		return backDate;
	}
	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}
	public int getAttention() {
		return attention;
	}
	public void setAttention(int attention) {
		this.attention = attention;
	}
	public int getUnused() {
		return unused;
	}
	public void setUnused(int unused) {
		this.unused = unused;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	
	
}
