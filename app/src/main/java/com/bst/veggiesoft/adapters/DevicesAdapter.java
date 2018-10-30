package com.bst.veggiesoft.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;


import com.bst.veggiesoft.R;
import com.bst.veggiesoft.models.Device;
import com.bst.veggiesoft.utilities.DataUtility;

import java.util.List;

public class DevicesAdapter extends BaseAdapter {

    private Context context;
    private List<Device> devices;

    public DevicesAdapter(Context context, List<Device> devices) {
        this.context = context;
        this.devices = devices;
    }

    @Override
    public int getCount() {
        return devices.size();
    }

    @Override
    public Object getItem(int position) {
        return devices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(R.layout.item_device_list, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.textView_deviceName);
        RadioButton radioButton = (RadioButton) convertView.findViewById(R.id.radioButton_visible);
        Device device = devices.get(position);
        if (!DataUtility.isStringEmpty(device.getDeviceName())) {
            title.setText(device.getDeviceName());
        } else {
            title.setText(device.getDeviceId());
        }

        if (device.isVisible()) {
            radioButton.setVisibility(View.VISIBLE);
        } else if (!device.isVisible()) {
            radioButton.setVisibility(View.GONE);
        }

        return convertView;
    }
}
