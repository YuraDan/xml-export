package ru.gradis.sovzond.model.domain;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by donchenko-y on 7/1/16.
 */

public class FileVO {

	private String fileData;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileData() {
		return fileData;
	}

	public void setFileData(String fileData) {
		this.fileData = fileData;
	}
}
