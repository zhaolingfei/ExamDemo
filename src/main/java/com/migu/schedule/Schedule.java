package com.migu.schedule;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

/*
 *类名和方法不能修改
 */
public class Schedule {

    public static Map<String,Map<String,String>> param ;
    public static Map<String,String> taskparam ;

    public int init() {
        param= new HashMap<String,Map<String,String>>();
        taskparam= new HashMap<String,String>();
        return ReturnCodeKeys.E001;
    }


    public int registerNode(int nodeId) {
        if(nodeId<=0){
            return ReturnCodeKeys.E004;
        }
        //如果存在就报错
        if(param.containsKey(String.valueOf(nodeId))){
            return ReturnCodeKeys.E005;
        }
//    	Map<String,String> map = new HashMap<String,String>();
//    	map.put(String.valueOf(nodeId),String.valueOf(nodeId));
        param.put(String.valueOf(nodeId), null);
        return ReturnCodeKeys.E003;
    }

    public int unregisterNode(int nodeId) {

        if(nodeId<=0){
            return ReturnCodeKeys.E004;
        }

        //如果不存在就报错
        if(!param.containsKey(String.valueOf(nodeId))){
            return ReturnCodeKeys.E007;
        }

        Iterator<String> iterator = param.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (String.valueOf(nodeId).equals(key)) {
                iterator.remove();
                param.remove(key);
            }
        }

        return ReturnCodeKeys.E006;
    }


    public int addTask(int taskId, int consumption) {

        if(taskId<=0){
            return ReturnCodeKeys.E009;
        }

        //如果存在就报错
        if(taskparam.containsKey(String.valueOf(taskId))){
            return ReturnCodeKeys.E010;
        }
        taskparam.put(String.valueOf(taskId), String.valueOf(consumption));

        return ReturnCodeKeys.E008;
    }


    public int deleteTask(int taskId) {
        if(taskId<=0){
            return ReturnCodeKeys.E009;
        }

        //如果不存在就报错
        if(!taskparam.containsKey(String.valueOf(taskId))){
            return ReturnCodeKeys.E012;
        }

        Iterator<String> iterator = taskparam.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (String.valueOf(taskId).equals(key)) {
                iterator.remove();
                taskparam.remove(key);
            }
        }
        return ReturnCodeKeys.E011;
    }


    public int scheduleTask(int threshold) {
        // TODO 方法未实现
        return ReturnCodeKeys.E014;
    }


    public int queryTaskStatus(List<TaskInfo> tasks) {
        // TODO 方法未实现
        return ReturnCodeKeys.E000;
    }

}
