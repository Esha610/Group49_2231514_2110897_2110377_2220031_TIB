
package Esha;


import java.io.Serializable;

public class WorkshopRegistrationData implements Serializable {
    private String name;
    private String email;
    private String mobile;
    private String joinMethod;

    public WorkshopRegistrationData(String name, String email, String mobile, String joinMethod) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.joinMethod = joinMethod;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getJoinMethod() {
        return joinMethod;
    }
}
