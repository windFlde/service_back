package com.jk.bean;

import lombok.Data;

import java.util.List;

@Data
public class Tree {

	private String id;
	
	private String text;
	
	private String url;
	
	private String pid;
	
	private String state; 
	
	private List<Tree> children;

	private List<Tree> nodes;


}
