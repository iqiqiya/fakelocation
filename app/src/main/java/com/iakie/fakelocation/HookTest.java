package com.iakie.fakelocation;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookTest implements IXposedHookLoadPackage {

    public static final String TAG = "Test iakie";

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.iakie.fakelocation")) {
            XposedHelpers.findAndHookMethod("com.iakie.fakelocation.MainActivity",
                    lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            //super.afterHookedMethod(param);

                            Class c = lpparam.classLoader.loadClass("com.iakie.fakelocation.MainActivity");
                            Field field = c.getDeclaredField("tv");//field是指类的数据成员
                            field.setAccessible(true);//设置Field对象的Accessible的访问标志位为Ture，就可以通过反射获取私有变量的值，在访问时会忽略访问修饰符的检查
                            XposedBridge.log("Test Success");
                            Log.i(TAG, "afterHookedMethod: ");
                            TextView tv = (TextView) field.get(param.thisObject);
                            tv.setText("齐齐喜欢秋绘");
                        }
                    });
        }
    }
}
