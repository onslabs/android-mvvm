package olabs.kit.mvvm.login;


import olabs.kit.mvvm.BaseViewModel;
import olabs.kit.mvvm.login.listener.LoginAPIListener;
import olabs.kit.mvvm.login.model.LoginResponse;

/**
 * Created by ttnd on 28/2/17.
 */

public class LoginViewModel extends BaseViewModel {

    private ILoginView mLoginView;
    private LoginAPIListener mLoginAPIListener;

    public LoginViewModel(ILoginView loginView){
        super(loginView);
        mLoginView = loginView;
        mLoginAPIListener = new LoginAPIListener(this);
    }

    public void onLogin(String userId,String password){
        mLoginAPIListener.doLogin(userId,password);

    }

    public void onRegister(){
        mLoginView.showMessage("To be developed by the user");
    }

    public void onLoginSuccess(LoginResponse loginResponse) {
        mLoginView.showMessage(loginResponse.getMessage());
    }
}
