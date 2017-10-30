package com.taobao.shedule;

public class MyDemoTest {

	public static void main(String[] args) {
		UserVo userVo = new UserVo();
		userVo.setAge(20);
		userVo.setName("test");
		System.out.println(userVo.getAge());
		userVo = new UserVo();
		userVo.setAge(30);
		System.out.println(userVo.getAge());

	}

}
