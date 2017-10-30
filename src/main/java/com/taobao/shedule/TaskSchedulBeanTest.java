/**  

 * Licensed to SAICMotor,Inc. under the terms of the SAICMotor 
 * Software License version 1.0.

 * See the NOTICE file distributed with this work for additional 
 * information regarding copyright ownership.  
 * ----------------------------------------------------------------------------
 * Date           Author      Version        Comments
 * 2017年6月21日        nwcjl       1.0            Initial Version

 */

package com.taobao.shedule;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.TaskItemDefine;

//@Component("testTask")
public class TaskSchedulBeanTest implements IScheduleTaskDealMulti<UserVo> {

	@Override
	public Comparator<UserVo> getComparator() {

        return new Comparator<UserVo>() {
            @Override
            public int compare(UserVo o1, UserVo o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
	}

	@Override
	public List<UserVo> selectTasks(String arg0, String arg1, int arg2, List<TaskItemDefine> arg3, int arg4)
			throws Exception {
		Object obj;
		System.out.println(arg0 + "|" + arg1 + "|" + arg2);
		Thread thread = Thread.currentThread();
		String threadNo = thread.getName() + "_" + thread.getId();
		System.out.println(threadNo + "====11====2222222=========");
		
		
		
		
		return null;
	}


	@Override
	public boolean execute(UserVo[] arg0, String arg1) throws Exception {
		System.out.println("========33333333=========");
		return false;
	}
   
}
