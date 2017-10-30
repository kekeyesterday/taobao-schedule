package com.taobao.shedule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.TaskItemDefine;

@Component("testTask")
public class IScheduleTaskDealMultiTest implements IScheduleTaskDealMulti<TaskModel> {

    private static final Log logger = LogFactory.getLog(IScheduleTaskDealMultiTest.class);
    
    private static boolean flag = true;

    @Override
    public Comparator<TaskModel> getComparator() {
    	logger.info("=================Comparator==========================");
        return new Comparator<TaskModel>() {
            @Override
            public int compare(TaskModel o1, TaskModel o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
//    	return null;
    }

    private static List<TaskModel> models = new ArrayList<TaskModel>();
    @Override
    public List<TaskModel> selectTasks(String taskParameter, String ownSign, int taskQueueNum,
            List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
    	
    	logger.info("====测试一下=====");
        //LOG.info("IScheduleTaskDealSingleTest配置的参数，taskParameter:{}，ownSina:{}，taskQueueNum:{},taskItemList:{}, eachFetchDataNum:{}", taskParameter, ownSign, taskQueueNum, taskItemList, eachFetchDataNum);
       // LOG.info("server1...............IScheduleTaskDealSingleTest选择任务列表开始啦..........");
       if(flag){
	    	 models.add(new TaskModel(1l, "taosirTest1"));
	         models.add(new TaskModel(2l, "taosirTest2"));
	         models.add(new TaskModel(3l, "taosirTest3"));
	         models.add(new TaskModel(4l, "taosirTest4"));
	         models.add(new TaskModel(5l, "taosirTest5"));
	         models.add(new TaskModel(6l, "taosirTest6"));
    	     flag = false;
       }
        

       // LOG.info("server1...............IScheduleTaskDealSingleTest选择任务列表结束啦..........");
        //return models;
        return models;

    }


	@Override
	public boolean execute(TaskModel[] modelList, String arg1) throws Exception {
        
		Thread thread = Thread.currentThread();
		String threadNo = thread.getName() + "_" + thread.getId();
        
        for(TaskModel taskModel : modelList){
        	System.out.println(threadNo + "_" + taskModel.toString());
        }
        models.clear();
        return true;
	}

}