package com.ksptooi.udc.entity;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;

public class BasicData {
	
	//字符集
	protected Charset charset = null;
	
	//源文件path
	protected Path sourcePath = null;
	
	//缓存的内容
	protected ArrayList<String> content = null;
	
	protected BasicData() {
		
	}
	
	public Charset getCharset() {
		return charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	public ArrayList<String> getContent() {
		return content;
	}

	public void setContent(ArrayList<String> content) {
		this.content = content;
	}

	public Path getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(Path sourcePath) {
		this.sourcePath = sourcePath;
	}

	
}
