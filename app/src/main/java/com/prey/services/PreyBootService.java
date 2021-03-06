/*******************************************************************************
 * Created by Carlos Yaconi
 * Copyright 2015 Prey Inc. All rights reserved.
 * License: GPLv3
 * Full license at "/LICENSE"
 ******************************************************************************/
package com.prey.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.prey.PreyLogger;

public class PreyBootService extends Service {

    // This is the object that receives interactions from clients
    private final IBinder mBinder = new LocalBinder();

    /**
     * Class for clients to access. Because we know this service always runs in
     * the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        PreyBootService getService() {
            return PreyBootService.this;
        }
    }

    @Override
    public void onCreate() {
        PreyLogger.d("Prey Boot Service Started!");
    }


    @Override
    public void onDestroy() {
        // locationListenerThread.stop();
        PreyLogger.d("Boot Service has been stopped");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

}


