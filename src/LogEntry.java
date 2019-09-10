import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogEntry {
    private Date createdAt;
    private Date updatedAt;
    private String message;
    private String logName;

    public LogEntry(String message) {
        this.message = message;
        createdAt = new Date();
        updatedAt = new Date();
    }

    

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", message='" + message + '\'' +
                '}';
    }

    public void update(String newMessage) {

    }
}
