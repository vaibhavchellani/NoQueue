package Models;

/**
 * Created by vaibhavchellani on 9/28/17.
 */

public class Queue {
    public String description;
    public String name_of_queue;
    public String org_name;
    public int queue_status;
    public String queue_creation_time;


    public Queue(String description, String name_of_queue, String org_name) {
        this.description = description;
        this.name_of_queue = name_of_queue;
        this.org_name = org_name;
        setQueue_status(1);

        Long tsLong = System.currentTimeMillis()/1000;
        setQueue_creation_time(tsLong.toString());
    }

    public int getQueue_status() {
        return queue_status;
    }

    public void setQueue_status(int queue_status) {
        this.queue_status = queue_status;
    }

    public String getQueue_creation_time() {
        return queue_creation_time;
    }

    public void setQueue_creation_time(String queue_creation_time) {
        this.queue_creation_time = queue_creation_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName_of_queue() {
        return name_of_queue;
    }

    public void setName_of_queue(String name_of_queue) {
        this.name_of_queue = name_of_queue;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }
}
