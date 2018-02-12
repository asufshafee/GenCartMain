package b2infosoft.gencart.com.pojo;

/**
 * Created by b2andro on 12/28/2017.
 */

class NotificationPojo {
    public String NotificationTitle = "";
    public String NotificationDesc = "";
    public String NotificationTiming = "";

    public String order_id="";

    public NotificationPojo(String notificationTitle, String notificationDesc,String Timing,String order_id) {
        this.NotificationTitle = notificationTitle;
        this.NotificationDesc = notificationDesc;
        this.NotificationTiming = Timing;
        this.order_id = order_id;
    }
}
