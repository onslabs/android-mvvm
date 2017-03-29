package olabs.kit.mvvm;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class BaseApplication extends Application {
    private SessionTimeoutListener sessionTimeoutListener;
    @Override
    public void onCreate() {
        super.onCreate();
        initHeaders();

    }

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    public void initHeaders(){
        Constants.APP_AUTHORIZATION = getSharedPreferences(Constants.APP_PREFERENCE, Context.MODE_PRIVATE).getString("Authorization", null);
    }

    public void updateAuthHeader(String authHeader){
        Constants.IS_HEADER_UPDATE = true;
        Constants.APP_AUTHORIZATION = authHeader;
        SharedPreferences.Editor editor = getSharedPreferences(Constants.APP_PREFERENCE, Context.MODE_PRIVATE).edit();
        editor.putString("Authorization", authHeader);
        editor.commit();
    }

    public void onSessionTimeout(String errorMessage){
        sessionTimeoutListener.onSessionTimeout(errorMessage);
    }

    public void setSessionTimeoutListener(SessionTimeoutListener sessionTimeoutListener) {
        this.sessionTimeoutListener = sessionTimeoutListener;
    }

    public SessionTimeoutListener getSessionTimeoutListener() {
        return  this.sessionTimeoutListener;
    }
}
