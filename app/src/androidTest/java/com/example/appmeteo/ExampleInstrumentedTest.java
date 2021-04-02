package com.example.appmeteo;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.appmeteo.model.Place;
import com.example.appmeteo.model.db.DbWrapper;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

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
    public void dbInsertAndLoad(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Place p= new Place(UUID.randomUUID(), "test");
        DbWrapper dbWrapper= new DbWrapper(appContext);
        long before= dbWrapper.loadData().size();
        //assertTrue(dbWrapper.loadData().isEmpty());
        assertTrue(dbWrapper.insert(p)>=0);
        assertEquals(before+1, dbWrapper.loadData().size());
        assertEquals(p, dbWrapper.loadData().get(dbWrapper.loadData().size()-1));
    }

}