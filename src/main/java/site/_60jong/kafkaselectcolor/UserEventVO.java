package site._60jong.kafkaselectcolor;

public class UserEventVO {

    private final String timestamp;
    private final String userAgent;
    private final String colorName;
    private final String userName;

    public UserEventVO(String timestamp, String userAgent, String colorName, String userName) {
        this.timestamp = timestamp;
        this.userAgent = userAgent;
        this.colorName = colorName;
        this.userName = userName;
    }
}
