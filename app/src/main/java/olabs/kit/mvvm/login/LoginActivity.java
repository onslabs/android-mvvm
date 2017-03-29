package olabs.kit.mvvm.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import olabs.kit.mvvm.BaseActivity;
import olabs.kit.mvvm.OnProgressListener;
import olabs.kit.mvvm.R;
import olabs.kit.mvvm.databinding.ActivityLoginBinding;


public class LoginActivity extends BaseActivity<LoginViewModel,ActivityLoginBinding> implements ILoginView ,OnProgressListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mViewModel = new LoginViewModel(this);
        mViewModel.setOnProgressListener(this);
        mViewDataBinding.setViewmodel(mViewModel);
    }


    @Override
    public void showProgress() {
        mViewDataBinding.progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mViewDataBinding.progress.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
