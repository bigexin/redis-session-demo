package app;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 8697618992873370736L;
    private Long userId;

    private String userName;

    public UserInfo() {
    }

    public UserInfo(String userName) {
        this.userName = userName;
        this.userId = System.currentTimeMillis();
    }
}
