package com.zjgsu.ai.cameratest;

import android.hardware.Camera;

/**
 * Created by Double on 15/11/2017.
 */

public interface ViewController {
    int UPDATE_DETECT = 1;
    int UPDATE_VIEW = 2;

    void sendImage(byte[] bytes);
    void sendFaces(int[] faces);
    void setImageSize(int width, int height);
    void releaseControl();
    void loadControl();
}
