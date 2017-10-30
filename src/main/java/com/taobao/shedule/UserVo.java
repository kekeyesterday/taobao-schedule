package com.taobao.shedule;

import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public final class UserVo {
	private Integer id;
	@Immutable
	private Integer age;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
