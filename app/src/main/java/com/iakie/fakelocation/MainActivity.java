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

    //获取系统信息
    private void getInformation() {
        StringBuffer devicesInfo = new StringBuffer();
        devicesInfo.append("ID: ").append(Build.ID).append("\n");//设备版本号
        devicesInfo.append("DISPLAY: ").append(Build.DISPLAY).append("\n");//获取设备显示的版本包（在系统设置中显示为版本号）和ID一样
        devicesInfo.append("PRODUCT: ").append(Build.PRODUCT).append("\n");//整个产品的名称
        devicesInfo.append("DEVICE: ").append(Build.DEVICE).append("\n");//获取设备驱动名称
        devicesInfo.append("BOARD: ").append(Build.BOARD).append("\n");//获取设备基板名称
        devicesInfo.append("CPU_ABI: ").append(Build.CPU_ABI).append("\n");//废 获取设备指令集名称（CPU的类型）
        devicesInfo.append("CPU_ABI2: ").append(Build.CPU_ABI2).append("\n");//废 获取第二个指令集名称
        devicesInfo.append("MANUFACTURER: ").append(Build.MANUFACTURER).append("\n");//获取设备制造商
        devicesInfo.append("BRAND: ").append(Build.BRAND).append("\n");//获取设备品牌
        devicesInfo.append("MODEL: ").append(Build.MODEL).append("\n");//获取手机的型号 设备名称
        devicesInfo.append("BOOTLOADER: ").append(Build.BOOTLOADER).append("\n");//获取设备引导程序版本号
        devicesInfo.append("RADIO: ").append(Build.RADIO).append("\n");//废 无线电固件版本号，通常是不可用的 显示unknown
        devicesInfo.append("HARDWARE: ").append(Build.HARDWARE).append("\n");//设备硬件名称,一般和基板名称一样（BOARD）
        devicesInfo.append("SERIAL: ").append(Build.SERIAL).append("\n");//获取设备序列号（SN）
        devicesInfo.append("INCREMENTAL: ").append(Build.VERSION.INCREMENTAL).append("\n");//获取系统的升级字 主要用于系统OTA精确版本比对
        devicesInfo.append("RELEASE: ").append(Build.VERSION.RELEASE).append("\n");//获取系统版本字符串
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            devicesInfo.append("BASE_OS: ").append(Build.VERSION.BASE_OS).append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            devicesInfo.append("SECURITY_PATCH: ").append(Build.VERSION.SECURITY_PATCH).append("\n");
        }
        devicesInfo.append("SDK: ").append(Build.VERSION.SDK).append("\n");//系统的API级别 一般使用下面大的SDK_INT 来查看
        devicesInfo.append("SDK_INT: ").append(Build.VERSION.SDK_INT).append("\n");//系统的API级别 数字表示
        Log.e(TAG, "getInformation: " + devicesInfo.toString());
    }
}
