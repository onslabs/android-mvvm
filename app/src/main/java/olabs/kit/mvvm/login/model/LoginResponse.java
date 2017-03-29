package olabs.kit.mvvm.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import olabs.kit.mvvm.BaseResponse;


/**
 * Created by Salil Kaul on 2/11/16.
 */

public class LoginResponse extends BaseResponse {

    @SerializedName("access_token")
    @Expose
    private String access_token;

    @SerializedName("token_type")
    @Expose
    private String token_type;

    @SerializedName("refresh_token")
    @Expose
    private String refresh_token;

    @SerializedName("expires_in")
    @Expose
    private String expires_in;

    @SerializedName("scope")
    @Expose
    private String scope;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
