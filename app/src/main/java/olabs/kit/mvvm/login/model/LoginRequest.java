package olabs.kit.mvvm.login.model;

import com.google.gson.annotations.SerializedName;

import olabs.kit.mvvm.BaseRequest;


/**
 * Created by Salil Kaul on 2/11/16.
 */

public class LoginRequest extends BaseRequest {
    @SerializedName("username")
    String arnCode ;

    @SerializedName("grant_type")
    String grant_type = "password";

    @SerializedName("password")
    String password;

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }



    public String getArnCode() {
        return arnCode;
    }

    public void setArnCode(String arnCode) {
        this.arnCode = arnCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
