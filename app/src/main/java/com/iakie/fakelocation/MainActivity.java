package com.iakie.fakelocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "iAkie";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initView();
        tv = findViewById(R.id.tv);
        tv.setText("齐齐真好看！");
        getInformation();
    }

    /**private void initView() {
        TextView tv = findViewById(R.id.tv);
        tv.setText("齐齐真好看！");
    }*/

    public static String getSystemModel() {
        return Build.MODEL;//android.os.Build
    }

    private void getInformation() {
        StringBuffer devicesInfo = new StringBuffer();
        devicesInfo.append("ID: ").append(Build.ID).append("\n");
        devicesInfo.append("DISPLAY: ").append(Build.DISPLAY).append("\n");
        devicesInfo.append("PRODUCT: ").append(Build.PRODUCT).append("\n");
        devicesInfo.append("DEVICE: ").append(Build.DEVICE).append("\n");
        devicesInfo.append("BOARD: ").append(Build.BOARD).append("\n");
        devicesInfo.append("CPU_ABI: ").append(Build.CPU_ABI).append("\n");//废
        devicesInfo.append("CPU_ABI2: ").append(Build.CPU_ABI2).append("\n");//废
        devicesInfo.append("MANUFACTURER: ").append(Build.MANUFACTURER).append("\n");
        devicesInfo.append("BRAND: ").append(Build.BRAND).append("\n");
        devicesInfo.append("MODEL: ").append(Build.MODEL).append("\n");
        devicesInfo.append("BOOTLOADER: ").append(Build.BOOTLOADER).append("\n");
        devicesInfo.append("RADIO: ").append(Build.RADIO).append("\n");//废
        devicesInfo.append("HARDWARE: ").append(Build.HARDWARE).append("\n");
        devicesInfo.append("SERIAL: ").append(Build.SERIAL).append("\n");//
        devicesInfo.append("INCREMENTAL: ").append(Build.VERSION.INCREMENTAL).append("\n");
        devicesInfo.append("RELEASE: ").append(Build.VERSION.RELEASE).append("\n");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            devicesInfo.append("BASE_OS: ").append(Build.VERSION.BASE_OS).append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            devicesInfo.append("SECURITY_PATCH: ").append(Build.VERSION.SECURITY_PATCH).append("\n");
        }
        devicesInfo.append("SDK: ").append(Build.VERSION.SDK).append("\n");//
        devicesInfo.append("SDK_INT: ").append(Build.VERSION.SDK_INT).append("\n");
        Log.e(TAG, "getInformation: " + devicesInfo.toString());
    }
}
