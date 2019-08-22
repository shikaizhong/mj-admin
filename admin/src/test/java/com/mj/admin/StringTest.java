package com.mj.admin;

import java.util.ArrayList;

public class StringTest {
    /**
     *simon
     * @param args
     */
    public static void main(String[] args){
        String url = "[[localhost:8090/upload/69f398bb6249a91ade268a49318b.txt],[localhost:8090/upload/59f398bb6249a91ade268a49318b.txt],[localhost:8090/upload/79f398bb6249a91ade268a49318b.txt]]";
        String removeUrl="[[localhost:8090/upload/69f398bb6249a91ade268a49318b.txt]]";
        //去掉数组库中字符串的[
        String ss = url.replace("[","");
        //去掉数组库中字符串的]
        String sss = ss.replace("]","");
        System.out.println(sss);
        //去掉传入字符串的[
        String rr = removeUrl.replace("[","");
        //去掉传入字符串的]
        String rrr =rr.replace("]","");
        System.out.println(rrr);
        //数据库中的字符串去掉传入的字符串
        String mm = sss.replace(rrr,"");
        System.out.println(mm);
        String zz =null;
        //如果最前面有逗号则删除
        if (mm.startsWith(",")){
            zz=mm.substring(1);
            System.out.println(zz);
        }
        //如果最后面有逗号则删除
        if (mm.endsWith(",")){
            System.out.println(zz.length());
            zz=zz.substring(0,zz.length()-1);
            System.out.println(zz);
        }
        //用逗号分割去好的字符串
        String[] strarr = zz.split(",");
        //stringbuilder便于添加进去
        StringBuilder stringBuilder = new StringBuilder();
        //新建一个集合用于存储添加的数组使其和数据库数据保持一致
        ArrayList arrayList2 = new ArrayList();
        for (int z = 0;z<strarr.length;z++){
            //添加数据仅第一个数组
            stringBuilder.append(strarr[z]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(strarr[z]);
            //将第一个数组封装到一个大数组中去
            arrayList2.add(arrayList);
        }
        String urls = arrayList2.toString();
        System.out.println(urls+"转换成字符串");
        System.out.println(arrayList2+"遍历的数组");
    }
}
