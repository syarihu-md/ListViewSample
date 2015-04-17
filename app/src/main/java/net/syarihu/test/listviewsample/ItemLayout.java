package net.syarihu.test.listviewsample;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by usr0200500 on 2015/04/17.
 */
public class ItemLayout extends RelativeLayout {
    // タイトル
    TextView mTitleView;
    // 概要
    TextView mDescriptionView;
    // アイコン
    ImageView mIconView;

    public ItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mTitleView = (TextView) findViewById(R.id.list_item1);
        mDescriptionView = (TextView) findViewById(R.id.list_item2);
        mIconView = (ImageView) findViewById(R.id.image);
    }

    public void bindView(TestData item) {
        mTitleView.setText(item.getmData1());
        mDescriptionView.setText(item.getmData2());
        mIconView.setImageBitmap(item.getmBitmap());
    }
}
