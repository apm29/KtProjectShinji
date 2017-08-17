package com.apm29.projectshinji;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by apm29 on 2017/8/14.
 */

public class ConverterTest {
    PagerAdapter adapter=new PagerAdapter() {
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    };
}
