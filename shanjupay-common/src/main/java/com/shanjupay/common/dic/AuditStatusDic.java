package com.shanjupay.common.dic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.shanjupay.common.util.EnumBase;

import java.util.HashMap;
import java.util.Map;

public enum  AuditStatusDic implements EnumBase {

    // "审核状态 0-未申请,1-已申请待审核,2-审核通过,3-审核拒绝"

    /** 未确认 **/
    UNCONFIRM(0),

    /** 审核中 **/
    AUDITING(1),

    /** 审核通过 **/
    AUDITED(2),

    /** 审核拒绝 **/
    AUDITREJECT(3),;

    private int code;

    AuditStatusDic(int code) {
        this.code = code;
    }

    //存储枚举的所有选项
    private static Map<Integer,EnumBase> map;

    //初始化所有枚举类,以便通过code从map中获取相应的枚举
    static {
        map=new HashMap<>();
        for (final  EnumBase item:values()){
           map.put(item.getCode(),item);
        }
    }

    /**
     * jackson反序列化时，通过code得到枚举的实例 注意：此方法必须是static的方法，且返回类型必须是本枚举类，而不能是接口EnumBase
     * 否则jackson将调用默认的反序列化方法，而不会调用本方法
     */

    @JsonCreator
   public static AuditStatusDic getItem(int code){
        final EnumBase enumBase = map.get(code);
        if(enumBase==null){
            throw new IllegalArgumentException("输入的code" + code + "不在枚举的取值范围内");
        }
       return (AuditStatusDic)enumBase;
    }



    /**
     * @return jackson序列化时，输出枚举实例的code
     */
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name();
    }


}
