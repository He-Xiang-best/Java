package util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    /**
     * 把Map中的值注入到对应的JavaBean属性中。
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean( T bean , Map value){
        try {
            /*
              把所有请求的参数都注入到user对象中
             */
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception ignored) { }
        return defaultValue;
    }
    public static long parseLong(String longStr, long defaultValue) {
        long value = 0;
        try {
            value = Long.parseLong(longStr);
        } catch (Exception e) {
            return defaultValue;
        }
        return value;
    }

    public static double parseDouble(String doubleStr, double defaultValue) {
        double value = 0;
        try {
            value = Double.parseDouble(doubleStr);
        } catch (Exception e) {
            return defaultValue;
        }
        return value;
    }
}
