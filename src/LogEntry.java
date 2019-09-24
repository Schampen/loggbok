import java.util.Date;

public class LogEntry {
    private Date createdAt;
    private Date updatedAt;
    private String message;
    private String logName;

    public LogEntry(String logName, String message, Date created, Date updated) {
        this.logName = logName;
        this.message = message;
        this.createdAt = created;
        this.updatedAt = updated;
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

    public void update(String newMessage, Date updated) {
        this.message = newMessage;
        this.updatedAt = updated;
    }
}
