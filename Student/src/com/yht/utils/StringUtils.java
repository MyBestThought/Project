package com.yht.utils;

import java.util.Date;
import java.util.List;

public class StringUtils {

    public static String joinString(List<Object> list, String split){
        String ret = "";
        for(Object obj : list){
            ret += obj + split;
        }
        if(!"".equals(ret)){
            ret = ret.substring(0, ret.length()-split.length());
        }
        return ret;
    }

    public static String generateSn(String prefix, String suffix){
        return prefix + new Date().getTime() + suffix;
    }

}
