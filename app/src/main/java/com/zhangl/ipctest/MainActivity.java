package com.zhangl.ipctest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //客户端aidl实例

    private UserAidl mUserAidl;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {


            mUserAidl = UserAidl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        startService(new Intent(this,MessageService.class));



        // 客户端代码
        // 隐式意图

        Intent intent = new Intent(this,MessageService.class);
        bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);


        final TextView tv_main = findViewById(R.id.tv_main);

        tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tv_main.setText(mUserAidl.getUserName() + mUserAidl.getUserPassword());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });



    }










}
