package com.company;

import java.util.HashMap;

public final class Memo {
    protected static HashMap<String, Float> MemoMap;

    private static Memo memoObj = new Memo();

    private Memo() {
        memoObj.MemoMap = new HashMap<>();
    }

    public static Memo getInstance() {

        return memoObj;
    }

    protected float getMemoMap(String key) {
        if (Memo.getInstance().MemoMap.containsKey(key)) {
            float val = Memo.getInstance().MemoMap.get(key);

            //System.out.println(val + " found for " + key);
            return val;
            //return Memo.getInstance().MemoMap.get(key);
        } else {
            return -1;
        }
    }

    protected void setMemoMap(String key, float value) {
        //System.out.println("Setting value " + value + " for key " + key);
        Memo.getInstance().MemoMap.put(key, value);
    }

    /*public float getMemoMap(String key) {
        if (MemoMap.containsKey(key))
            return Float.parseFloat(MemoMap.get(key).toString());
        else
            return -1;
    }

    public void setMemoMap(String key, float value) {
        MemoMap.put(key,(Float) value);
    }*/
}
