import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogEntry {
    private Date createdAt;
    private Date updatedAt;
    private String message;
    private String logName;

    public LogEntry(String logName, String message) {
        this.logName = logName;
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

    public String getLogName() {
        return logName;
    }

    @Override
    public String toString() {
        return logName + " - " +
                "created at " + createdAt +
                "\n { " + message + " }" +
                "\n last updated at " + updatedAt;
    }

    public void update(String newMessage) {
        this.message = newMessage;
        updatedAt = new Date();
    }
}
