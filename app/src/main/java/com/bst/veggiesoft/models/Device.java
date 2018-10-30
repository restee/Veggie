package com.bst.veggiesoft.models;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.io.Serializable;

public class Device extends SugarRecord implements Serializable {

    private static final long serialVersionUID = 4L;

    private String deviceId;
    private String deviceName;
    public String bluetoothMacAddress;
    @Ignore
    private boolean visible;

    @Ignore
    private int notSeenTimes;

    public void setNotSeenTimes(int notSeenTimes) {
        this.notSeenTimes = notSeenTimes;
    }

    public int getNotSeenTimes() {
        return notSeenTimes;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getBluetoothMacAddress() {
        return bluetoothMacAddress;
    }

    public void setBluetoothMacAddress(String bluetoothMacAddress) {
        this.bluetoothMacAddress = bluetoothMacAddress;
    }
}
