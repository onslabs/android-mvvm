package olabs.kit.mvvm.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import olabs.kit.mvvm.BaseActivity;
import olabs.kit.mvvm.R;
import olabs.kit.mvvm.databinding.ActivityLoginBinding;


public class LoginActivity extends BaseActivity<LoginViewModel,ActivityLoginBinding> implements ILoginView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mViewModel = new LoginViewModel(this);
        mViewDataBinding.setViewmodel(mViewModel);
    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
