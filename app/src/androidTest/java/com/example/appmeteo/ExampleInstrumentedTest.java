package com.example.appmeteo;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.appmeteo.controller.ConnectionController;
import com.example.appmeteo.controller.MeteoController;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.appmeteo", appContext.getPackageName());
    }

    @Test
    public void imageTest(){



        Bitmap bitmap = MeteoController.getInstance().requestImage("01d");
    }
}