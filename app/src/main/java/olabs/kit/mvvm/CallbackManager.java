package olabs.kit.mvvm;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;

import onslabs.kit.networx.NetworkServiceFactory;
import onslabs.kit.networx.RetroError;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Jitendra Kumar on 25/11/16.
 */

public abstract class CallbackManager<T extends BaseResponse> implements Callback<T> {

    private HashMap<String, String> mRequestHeaderMap = new HashMap<>();

    public CallbackManager() {
        initHeaders();
    }

    public <S> S getServiceClient(Class<S> serviceClass) {
        if (Constants.IS_HEADER_UPDATE) {
            Constants.IS_HEADER_UPDATE = false;
            updateHeaders();
            return NetworkServiceFactory.getNewInstance(Constants.BASE_URL, serviceClass, mRequestHeaderMap);
        }
        return NetworkServiceFactory.getInstance(Constants.BASE_URL, serviceClass, mRequestHeaderMap);
    }

    private void initHeaders() {
        mRequestHeaderMap.put("app-type", "M");
        mRequestHeaderMap.put("Content-Type", "application/json");
        mRequestHeaderMap.put("Authorization", Constants.BASIC_AUTHORIZATION);
    }

    private void updateHeaders() {
        mRequestHeaderMap.put("app-type", "M");
        mRequestHeaderMap.put("Content-Type", "application/json");
        mRequestHeaderMap.put("Authorization", Constants.APP_AUTHORIZATION);
    }

    @Override
    public void onResponse(retrofit2.Call call, Response response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else{

            try {
                onError(new RetroError(RetroError.Kind.HTTP, response.errorBody().string(), -999));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(retrofit2.Call call, Throwable throwable) {
        if(throwable instanceof UnknownHostException){
            onError(new RetroError(RetroError.Kind.NETWORK, "Unable to connect to server.", -999));
        }else{
            onError(new RetroError(RetroError.Kind.UNEXPECTED, "Unexpected error...try after sometime.", -999));
        }
    }


    protected abstract void onSuccess(Object o);
    protected abstract void onError(RetroError retroError);

}
