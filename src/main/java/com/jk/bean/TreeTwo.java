package com.jk.bean;

import lombok.Data;

import java.util.List;

@Data
public class TreeTwo {

	private Integer id;
	
	private String text;
	
	private String url;
	
	private String pid;
	
	private String state; 
	
	private List<TreeTwo> children;

	private boolean checked;



}
