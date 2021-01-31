package com.ykn.user_service.utils;

import java.util.List;

public class ObjectUtils {

    public static boolean isEqualList(List<String> l1, List<String> l2){
        if(l1 == null && l2 == null)
            return true;
        if(l1 == null)
            return false;
        return l1.equals(l2);
    }

}
