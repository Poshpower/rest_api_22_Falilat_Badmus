package rest_api_22.helpers;

import rest_api_22.domian.*;


public class TestCaseContext {
    private static Space space;

    private static Folder folder;

    private static List list;

    private static Task task;

    private static AllTask allTask;

    public static void init() {
        space = null;
        folder = null;
        list = null;
        task = null;
        allTask = null;
    }

    public static Space getSpace() {
        return space;
    }

    public static void setSpace(Space space) {
        TestCaseContext.space = space;
    }

    public static Folder getFolder() {
        return folder;
    }

    public static void setFolder(Folder folder) {
        TestCaseContext.folder = folder;
    }

    public static List getList() {
        return list;
    }

    public static void setList(List list) {
        TestCaseContext.list = list;
    }

    public static Task getTask() {
        return task;
    }

    public static void setTask(Task task) {
        TestCaseContext.task = task;
    }


    public static AllTask getAllTask() {
        return allTask;
    }

    public static void setAllTask(AllTask allTask) {
        TestCaseContext.allTask = allTask;
    }


}

