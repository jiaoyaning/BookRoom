package com.jyn.bookroom;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SdkSuppress;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.runner.RunWith;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import static org.junit.Assert.assertThat;

/**
 * Created by jiao on 2020/3/11.
 */
//执行单元测试的执行类
@RunWith(AndroidJUnit4.class)
//4.3以上系统可以使用
@SdkSuppress(minSdkVersion = 18)
public class UIAutomatorTest {
    private UiDevice mUiDevice;

    //测试执行之前的操作
    @Before
    public void startMainActivityFromHomeScreen() {
        mUiDevice = UiDevice.getInstance(getInstrumentation());
        //点击home键
        mUiDevice.pressHome();
        // 获取启动页的包名，并判断是否为空
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, CoreMatchers.notNullValue());
        //等待启动完成
        mUiDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 3000);
    }

    /**
     * 获取程序的启动包名
     *
     * @return
     */
    private String getLauncherPackageName() {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        // 通过PackageManager获取启动的包名
        PackageManager pm = getApplicationContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        assert resolveInfo != null;
        return resolveInfo.activityInfo.packageName;
    }
}
