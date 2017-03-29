package olabs.kit.mvvm.login.listener;

import olabs.kit.mvvm.CallbackManager;
import olabs.kit.mvvm.login.API.ILoginAPI;
import olabs.kit.mvvm.login.LoginViewModel;
import olabs.kit.mvvm.login.model.LoginResponse;
import onslabs.kit.networx.RetroError;
import retrofit2.Call;

/**
 * Created by ttnd on 27/2/17.
 */

public class LoginAPIListener extends CallbackManager {
    LoginViewModel mLoginViewModel;
    protected ILoginAPI mLoginAPI;
    public LoginAPIListener(LoginViewModel loginViewModel) {
        mLoginAPI = (ILoginAPI) getServiceClient(ILoginAPI.class);
        this.mLoginViewModel = loginViewModel;

    }

    public void doLogin(String arn,String grantType,String password) {
        Call<LoginResponse> call = mLoginAPI.doLogin(arn, grantType, password);
        call.enqueue(this);
    }

    @Override
    protected void onSuccess(Object o) {
        if(o instanceof LoginResponse){
            mLoginViewModel.onLoginSuccess((LoginResponse) o);
        }

    }

    @Override
    protected void onError(RetroError retroError) {
        mLoginViewModel.onError(retroError.getErrorMessage());
    }
}
