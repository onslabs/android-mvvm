package olabs.kit.mvvm;


import onslabs.kit.networx.RetroError;

/**
 * Created by ttnd on 27/2/17.
 */
public class BaseViewModel {

    protected IView mIView;

    public BaseViewModel(IView iView){
        mIView = iView;

    }

    public void onError(RetroError retroError) {
        if(retroError.getKind() == RetroError.Kind.HTTP){
            switch (retroError.getHttpErrorCode()){
                case 401:
//                    application.onSessionTimeout("Your session has expired...please login again");
                    break;
                case 500:
                    mIView.showMessage("Something went wrong...try after sometime.");
                    break;
                default:
                    mIView.showMessage("Something went wrong...try after sometime.");
                    break;
            }
        }
        else if(retroError.getKind() == RetroError.Kind.NETWORK){
            mIView.showMessage("Unable to connect to server.");
        }if(retroError.getKind() == RetroError.Kind.UNEXPECTED){
            mIView.showMessage("Unexpected error...try after sometime.");
        }
    }
}
