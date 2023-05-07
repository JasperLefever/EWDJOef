package domain;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import validator.ValidUserName;
import jakarta.validation.constraints.NotBlank;

public class Registration {

    //@Pattern(regexp = "^[a-zA-Z]+",
     //        message = "Username must be alphanumeric with no spaces")
    //@Pattern(regexp = "^[a-zA-Z]+", message="{validation.userName.Pattern.message}")
    @ValidUserName
    private String userName;
    
    @NotBlank
    @Size(min = 4, max = 20)
    //@Size(min=4, max=20, message="{validation.Size.message}")
    private String password;
    
    
    @NotBlank
    private String confirmPassword;
   
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setConfirmPassword(String confirmPassword) {

        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

}