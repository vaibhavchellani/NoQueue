package Models;

public class Queue {
    public String description;
    public String name_of_queue;
    public String org_name;
    public int queue_status;
    //queue start time is added but need input for this from UI and a date too
    public String queue_creation_time;
    public String queue_start_time;
    public String queue_start_date;
    public token_zero users;
    public int no_of_tokens;
    public int latest_token;
    public int current_token;

    public Queue(){

    }
    public Queue(String description, String name_of_queue, String org_name, String queue_start_time, String queue_start_date
    ) {
        this.description = description;
        this.name_of_queue = name_of_queue;
        this.org_name = org_name;
        this.queue_start_date = queue_start_date;
        setQueue_status(1);
        this.queue_start_time = queue_start_time;
        users=new token_zero();
        no_of_tokens=0;
        latest_token=0;
        current_token=0;
        Long tsLong = System.currentTimeMillis()/1000;
        setQueue_creation_time(tsLong.toString());
    }

    public String getQueue_start_date() {
        return queue_start_date;
    }

    public void setQueue_start_date(String queue_start_date) {
        this.queue_start_date = queue_start_date;
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

    public String getQueue_start_time() {
        return queue_start_time;
    }

    public void setQueue_start_time(String queue_start_time) {
        this.queue_start_time = queue_start_time;
    }

    public int getCurrent_token() {
        return current_token;
    }

    public void setCurrent_token(int current_token) {
        this.current_token = current_token;
    }
}
