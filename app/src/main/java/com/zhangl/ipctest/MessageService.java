package com.zhangl.ipctest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by zhangl on 2018/10/19.
 */

public class MessageService extends Service {




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //绑定

        return mBinder;
    }





    private final UserAidl.Stub mBinder = new UserAidl.Stub()
    {

        @Override
        public String getUserName() throws RemoteException {
            return "547700324@qq.com";
        }

        @Override
        public String getUserPassword() throws RemoteException {
            return "13763354042";
        }
    };


}
