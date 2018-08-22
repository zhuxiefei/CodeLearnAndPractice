package com.file.business.file.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *  SystemFile
 *
 * @version : Ver 1.0
 * @date	: 2018-7-18
 */
public class SystemFile  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * UUID     
     */	
	private String fileId;
	
	/**
     * 原始文件名称     
     */	
	private String fileName;
	
	/**
     * 文件存储路径，备注：全路径     
     */	
	private String fileUrl;
	
	/**
     * 1视频2图片3户型图4场景图     
     */	
	private Integer fileType;
	
	/**
     * 文件创建时间     
     */	
	private java.util.Date createTime;
	
	 
	
	/**
	 * @param fileId UUID
	 */
	@ApiModelProperty("UUID")
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
	/**
	 * @return UUID
	 */
	@ApiModelProperty("UUID")
	public String getFileId() {
		return this.fileId;
	}
	
	/**
	 * @param fileName 原始文件名称
	 */
	@ApiModelProperty("原始文件名称")
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * @return 原始文件名称
	 */
	@ApiModelProperty("原始文件名称")
	public String getFileName() {
		return this.fileName;
	}
	
	/**
	 * @param fileUrl 文件存储路径，备注：全路径
	 */
	@ApiModelProperty("文件存储路径，备注：全路径")
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	/**
	 * @return 文件存储路径，备注：全路径
	 */
	@ApiModelProperty("文件存储路径，备注：全路径")
	public String getFileUrl() {
		return this.fileUrl;
	}
	
	/**
	 * @param fileType 1视频2图片3户型图4场景图
	 */
	@ApiModelProperty("1视频2图片3户型图4场景图")
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	
	/**
	 * @return 1视频2图片3户型图4场景图
	 */
	@ApiModelProperty("1视频2图片3户型图4场景图")
	public Integer getFileType() {
		return this.fileType;
	}
	
	/**
	 * @param createTime 文件创建时间
	 */
	@ApiModelProperty("文件创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return 文件创建时间
	 */
	@ApiModelProperty("文件创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	 
}
