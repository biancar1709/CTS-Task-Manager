package ro.ase.cts.classes;

public class Task {
    private int taskID;
    private String taskName;
    private String taskDesc;
    private int ownerID;
    private static int numberOfTasks = 0;
    private boolean isHidden;

    public Task() {
        numberOfTasks++;
        this.taskID = 0;
        this.taskName = "";
        this.taskDesc = "";
        this.ownerID = 0;
        this.isHidden = false;
    }

    public Task(String taskName, String taskDesc, int ownerID) {
        numberOfTasks++;
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.ownerID = ownerID;
        this.isHidden = false;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", taskName='" + taskName + '\'' +
                ", taskDesc='" + taskDesc + '\'' +
                ", ownerID=" + ownerID +
                ", isHidden=" + isHidden +
                '}';
    }
}
