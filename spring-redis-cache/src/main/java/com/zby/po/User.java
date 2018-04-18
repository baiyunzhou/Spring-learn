package com.zby.po;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Date birthday;

}
