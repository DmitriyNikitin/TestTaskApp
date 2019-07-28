package com.example.testtaskapp.Managers.Retrofit;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

public enum TransportStatus {

    StatusSuccess,
    StatusError,
    StatusNotInternet;




    public static TransportStatus getStatus(Throwable e) {
        TransportStatus status;
        if (e instanceof ConnectException || e instanceof SocketTimeoutException || e instanceof UnknownHostException) {
            status = StatusNotInternet;
        } else if (e instanceof HttpException) {
            status = StatusError;
        } else {
            status = StatusError;
        }
        return status;
    }

    public static TransportStatus getStatus(Integer code) {
        TransportStatus status;
        if (code == null) {
            status = StatusError;
        } else if (code == 200) {
            status = StatusSuccess;
        } else {
            status = StatusError;
        }
        return status;
    }

}