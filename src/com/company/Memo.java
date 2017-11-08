package com.company;

import java.util.HashMap;

public class Memo {
    private HashMap<String, Float> MemoMap;

    public float getMemoMap(String key) {
        if (MemoMap.containsKey(key))
            return Float.parseFloat(MemoMap.get(key).toString());
        else
            return -1;
    }

    public void setMemoMap(String key, float value) {
        MemoMap.put(key,(Float) value);
    }
}
