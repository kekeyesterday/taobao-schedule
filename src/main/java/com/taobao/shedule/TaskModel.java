package com.taobao.shedule;


public class TaskModel {
	
	private Long id;
	private String taskName;
	
	public TaskModel(Long id,String taskName){
		this.id = id;
		this.taskName = taskName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		
		return id + ":" + taskName;
	}
	
	
	

}
