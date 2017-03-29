package olabs.kit.mvvm;


import onslabs.kit.networx.RetroError;

/**
 * Created by ttnd on 27/2/17.
 */
public class BaseViewModel {

    protected OnProgressListener mOnProgressListener;

    public void onError(RetroError retroError) {
        mOnProgressListener.hideProgress();
        if(retroError.getKind() == RetroError.Kind.HTTP){
            switch (retroError.getHttpErrorCode()){
                case 401:
//                    application.onSessionTimeout("Your session has expired...please login again");
                    break;
                case 500:
                    mOnProgressListener.showMessage("Something went wrong...try after sometime.");
                    break;
                default:
                    mOnProgressListener.showMessage("Something went wrong...try after sometime.");
                    break;
            }
        }
        else if(retroError.getKind() == RetroError.Kind.NETWORK){
            mOnProgressListener.showMessage("Unable to connect to server.");
        }if(retroError.getKind() == RetroError.Kind.UNEXPECTED){
            mOnProgressListener.showMessage("Unexpected error...try after sometime.");
        }
    }

    public void setOnProgressListener(OnProgressListener onProgressListener) {
        mOnProgressListener = onProgressListener;
    }
}
