package com.bst.veggiesoft.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bst.veggiesoft.R;
import com.bst.veggiesoft.adapters.DevicesAdapter;
import com.bst.veggiesoft.models.Device;

import java.util.List;

public class DeviceSelectionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, DialogInterface.OnClickListener, AdapterView.OnItemLongClickListener {

    private List<Device> devices;
    private Bundle mainBundle;
    private ListView mListViewDevices;
    private DevicesAdapter devicesAdapter;
    private ImageView mButtonAddDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_selection);

        devices = Device.listAll(Device.class);
        mListViewDevices = (ListView) findViewById(R.id.listview_devicesPaired);

        if (devices == null || devices.size() == 0) {
            Device d = new Device();
            d.setDeviceName("Device 1");
            d.save();
            devices = Device.listAll(Device.class);
        }

        devicesAdapter = new DevicesAdapter(this, devices);


        mListViewDevices.setAdapter(devicesAdapter);
        mListViewDevices.setOnItemClickListener(this);
        mListViewDevices.setOnItemLongClickListener(this);

        mButtonAddDevice = (ImageView) findViewById(R.id.button_addDevice);
        mButtonAddDevice.setOnClickListener(this);
    }

    private void refreshList() {
        devices.clear();
        devices.addAll(Device.listAll(Device.class));
        devicesAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private Device device;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        device = devices.get(position);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        return true;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}

