package olabs.kit.mvvm;


import android.content.Context;
import android.databinding.ViewDataBinding;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment<T extends BaseViewModel, S extends ViewDataBinding> extends Fragment {


    @Nullable
    protected T mViewModel;

    @NonNull
    protected S mViewDataBinding;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public BaseFragment() {
        // Required empty public constructor
    }

    protected void init(T t, S s) {
        this.mViewModel = t;
        this.mViewDataBinding = s;

    }


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }


    public void onDetach() {
        super.onDetach();
    }


    protected boolean isOnline() {
        if (getActivity() != null) {
            ConnectivityManager cm =
                    (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        } else {
            return false;
        }
    }

    protected void setToolbarTitle(String title) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle(title);
    }

}
