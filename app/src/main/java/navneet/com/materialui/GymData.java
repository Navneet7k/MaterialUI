package navneet.com.materialui;

/**
 * Created by Sree on 28-08-2017.
 */

public class GymData {
    private String date;
    private String time;
    private String image;

    public GymData(String date, String time, String image) {
        this.date = date;
        this.time = time;
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
