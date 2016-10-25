package com.example.java.apis;

import java.util.Vector;

/**
 * Created by 80107442 on 2016-01-04.
 */
public class TestList {
    private static final String TAG = TestList.class.getSimpleName();

    public static void main(String[] args) {
        Vector<Object> lists = new Vector<>();

        DataModel dataModel = new DataModel();
        dataModel.mData = "one";

        lists.add(dataModel);
        lists.add(new String("two"));
        lists.add(dataModel);
        lists.add(new String("four"));

        System.out.println("Data is:" + lists);
    }

    private static class DataModel {
        public String mData = "";

        @Override
        public String toString() {
            return mData;
        }
    }
}
