package net.syarihu.test.listviewsample;

import android.graphics.Bitmap;

/**
 * Created by usr0200500 on 2015/04/17.
 */
public class TestData {
    private String mData1;
    private String mData2;
    private Bitmap mBitmap;

    public TestData(String data1, String data2, Bitmap bitmap) {
        setmData1(data1);
        setmData2(data2);
        setmBitmap(bitmap);
    }

    public String getmData1() {
        return mData1;
    }

    public void setmData1(String mData1) {
        this.mData1 = mData1;
    }

    public String getmData2() {
        return mData2;
    }

    public void setmData2(String mData2) {
        this.mData2 = mData2;
    }

    public Bitmap getmBitmap() {
        return mBitmap;
    }

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }
}
