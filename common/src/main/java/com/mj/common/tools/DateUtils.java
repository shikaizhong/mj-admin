package com.mj.common.tools;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.google.common.collect.Lists;

public class DateUtils {

    private final static SimpleDateFormat NORM_DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat NORM_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat CH_DATE_FORMAT = new SimpleDateFormat("yyyy年MM月dd日");
    private final static SimpleDateFormat STATIC_DATE_FORMAT=new SimpleDateFormat("yyyy-MM");
    private final static SimpleDateFormat STATIC_YEAR_FORMAT=new SimpleDateFormat("yyyy");
    private final static SimpleDateFormat POST_FORMAT=new SimpleDateFormat("yyyy/MM/dd");
    private final static SimpleDateFormat EXPORT_FORMAT=new SimpleDateFormat("yyyyMMdd");
    private final static SimpleDateFormat GENERATE_FORMAT=new SimpleDateFormat("yyyyMM");
    private final static SimpleDateFormat GENERATE_FORMAT2=new SimpleDateFormat("MM月");



    private static Calendar calendar = null;

    /**
     * 当前时间，格式 yyyy-MM-dd HH:mm:ss
     *
     * @return 当前时间的标准形式字符串
     */
    public static String now() {
        return formatDateTime(new Date());
    }

    public static Date nowdate(){
        return fromatNormalString(formatDate(new Date()));
    }
    /**
     * 返回当前时间的yyyyMMdd格式
     * @return
     */
    public static String exportNow() {
        return formatExportDate(new Date());
    }

    public static String generateNow(){
        return GENERATE_FORMAT.format(new Date());
    }
    
    public static String zero() {
        return formatDateTime(getZero());
    }

    public static String nowDate() {
        return formatDate(new Date());
    }

    //第一天
    public static String first() {
        return formatDateTime(getFirstDay());
    }

    //最后一天
    public static String last() {
        return formatDateTime(getLastDay());
    }

    public static String formatDateTime(Date date) {
        return NORM_DATETIME_FORMAT.format(date);
    }

    public static String formatYearM(Date date) {
        return GENERATE_FORMAT.format(date);
    }

    public static String formatDate(Date date) {
        return NORM_DATE_FORMAT.format(date);
    }

    public static String formatPostDate(Date date) {
        return POST_FORMAT.format(date);
    }

    public static Date fromatNormalString(String date){
        try {
            Date parse = NORM_DATE_FORMAT.parse(date);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
    /**
     *
     * @param date  给定日期
     * @return 返回yyyyMMdd
     */
    public static String formatExportDate(Date date) {
        return EXPORT_FORMAT.format(date);
    }

    /**
     * MM月
     * @param date
     * @return
     */
    public static String formatGENERATE_FORMAT2(Date date) {
        String format = GENERATE_FORMAT2.format(date);
        if (format.startsWith("0")){
            format=format.replace("0","");
        }
        return format;
    }
    /**
     * @param date
     * @return      yyyy年MM月dd日
     */
    public static String formatCHDate(Date date) {
        return CH_DATE_FORMAT.format(date);
    }

    /**
     * @param date
     * @return  yyyy-mm
     */
    public static String formatStaticDate(Date date) {
        return STATIC_DATE_FORMAT.format(date);
    }

    /**
     * @param date
     * @return     yyyy
     */
    public static String formatStaticYear(Date date) {
        return STATIC_YEAR_FORMAT.format(date);
    }

    /**
     * yyyy-MM-dd
     *
     * @param str
     * @return
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        if (null != str && !("null".equals(str))) {
            try {
                date = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }

    /**
     * @param str
     * @return yyyy-MM-dd HH:mm:ss
     * @throws ParseException
     */
    public static Date StrToDate1(String str) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        if (null != str && !("null".equals(str))) {

            date = sdf.parse(str);
        }
        return date;
    }
    
    /**
     * yyyy-MM
     *
     * @param str
     * @return
     */
    public static Date StrToDate2(String str) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = null;

        if (null != str && !("null".equals(str))) {
            try {
                date = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }
    
    /**
     * yyyy
     *
     * @param str
     * @return
     */
    public static Date StrToDate3(String str) {
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    	Date date = null;
    	
    	if (null != str && !("null".equals(str))) {
    		try {
    			date = sdf.parse(str);
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	return date;
    }

    /**
     * 获取第一秒
     *
     * @param str yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date getFirstSecond(String str) throws ParseException {
        Date date = NORM_DATETIME_FORMAT.parse(str + " 00:00:00");
        return date;
    }

    /**
     * 获取最后一秒
     *
     * @param str yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date getLastSecond(String str) throws ParseException {
        Date date = NORM_DATETIME_FORMAT.parse(str + " 23:59:59");
        return date;
    }

    /**
     * yyyyMM
     * @return
     */
    public static String dateToStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yearsMonth = sdf.format(date);
    	return yearsMonth;
    }

    /**
     * @return 获取每天的0点
     */
    public static Date getZero() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return new Date(c.getTimeInMillis());
    }

    /**
     * @return 获取每天的24点
     */
    public static Date getTwelve() {
//		long current = System.currentTimeMillis();// 当前时间毫秒数
//		long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();// 今天零点零分零秒的毫秒数
//		long twelve = zero + 24 * 60 * 60 * 1000 - 1;// 今天23点59分59秒的毫秒数
//		Date date = new Date();
//		date = new Timestamp(twelve);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return new Date(c.getTimeInMillis());
    }

    /**
     * @return 获取每个月的第一天
     */
    public static Date getFirstDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        // 将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        c.set(Calendar.MINUTE, 0);
        // 将秒至0
        c.set(Calendar.SECOND, 0);
        // 将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return new Date(c.getTimeInMillis());

    }

    /**
     * @return 获取给定年月的第一天
     */
    public static Date getFirstDay(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.YEAR, ca.get(Calendar.YEAR));
        c.set(Calendar.MONTH, ca.get(Calendar.MONTH));
        c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        // 将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        c.set(Calendar.MINUTE, 0);
        // 将秒至0
        c.set(Calendar.SECOND, 0);
        // 将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return new Date(c.getTimeInMillis());

    }

    /**
     * @return 获取每个月的最后一天
     */
    public static Date getLastDay() {
        // 获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 将小时至0
        ca.set(Calendar.HOUR_OF_DAY, 23);
        // 将分钟至0
        ca.set(Calendar.MINUTE, 59);
        // 将秒至0
        ca.set(Calendar.SECOND, 59);
        // 将毫秒至0
        ca.set(Calendar.MILLISECOND, 0);
        // 获取本月最后一天的时间戳
        return new Date(ca.getTimeInMillis());
    }

    /**
     * @return 获取给定年月的最后一天
     */
    public static Date getLastDay(Date date) {
        // 获取给定年月最后一天
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 将小时至0
        ca.set(Calendar.HOUR_OF_DAY, 23);
        // 将分钟至0
        ca.set(Calendar.MINUTE, 59);
        // 将秒至0
        ca.set(Calendar.SECOND, 59);
        // 将毫秒至0
        ca.set(Calendar.MILLISECOND, 0);
        // 获取本月最后一天的时间戳
        return new Date(ca.getTimeInMillis());
    }

    /**
     * 判断两个日期是否为同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }

    /**
     * 判断两个日期是否为同一月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        return isSameMonth;
    }

    /**
     * 得到指定日期的年份
     *
     * @param df
     * @return
     */
    public static String getYear(Date df) {
        calendar = Calendar.getInstance();
        calendar.setTime(df);
        return "" + calendar.get(Calendar.YEAR);
    }

    public static boolean isSameYear(Date date){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String targetYear = getYear(date);
        if (currentYear==Integer.valueOf(targetYear)){
            return true;
        }
        return false;
    }

    /**
     * 得到指定日期的月份
     *
     * @param df
     * @return
     */
    public static String getMoon(Date df) {
        calendar = Calendar.getInstance();
        calendar.setTime(df);
        return getNum((calendar.get(Calendar.MONTH) + 1));
    }

    /**
     * 得到指定日期的日期
     *
     * @param df
     * @return
     */
    public static String getDay(Date df) {
        calendar = Calendar.getInstance();
        calendar.setTime(df);
        return getNum(calendar.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 得到指定日期的年月日
     *
     * @param df
     * @return
     */
    public static String getDate(Date df) {
        calendar = Calendar.getInstance();
        calendar.setTime(df);
        return "" + calendar.get(Calendar.YEAR) + getNum((calendar.get(Calendar.MONTH) + 1))
                + getNum(calendar.get(Calendar.DAY_OF_MONTH));
    }

    //获取给定时间几分钟之前的数据
    public static Date getBeforeDate(Date date, int minute) {
        Calendar nowDate = Calendar.getInstance();
        nowDate.setTime(date);
        nowDate.add(Calendar.MINUTE, minute);// n分钟之前的时间
        Date beforeDate = nowDate.getTime();
        return beforeDate;
    }

    /**
     * 补零
     *
     * @param i
     * @return
     */
    public static String getNum(int i) {
        return i > 9 ? "" + i : "0" + i;
    }

    public static String getBeforeDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    public static List<Date> findDates(String start, String end) {

        Date dBegin = StrToDate(start);
        Date dEnd = StrToDate(end);
        List<Date> lDate = Lists.newArrayList();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }


    /**
     * @return 获取昨天开始时间
     */
    public static Date getYestodayBegin() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 1);
        // 将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        c.set(Calendar.MINUTE, 0);
        // 将秒至0
        c.set(Calendar.SECOND, 0);
        // 将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return new Date(c.getTimeInMillis());

    }

    /**
     * @return 获取昨天结束时间
     */
    public static Date getYestodayEnd() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - 1);

        // 将小时至0
        c.set(Calendar.HOUR_OF_DAY, 23);
        // 将分钟至0
        c.set(Calendar.MINUTE, 59);
        // 将秒至0
        c.set(Calendar.SECOND, 59);
        // 获取本月第一天的时间戳
        return new Date(c.getTimeInMillis());

    }

    /**
     * 获取指定日期
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Date getDateTime(int day,int hour,int minute,int second) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) +day);

        // 将小时至0
        c.set(Calendar.HOUR_OF_DAY, hour);
        // 将分钟至0
        c.set(Calendar.MINUTE, minute);
        // 将秒至0
        c.set(Calendar.SECOND, second);
        // 获取本月第一天的时间戳
        return new Date(c.getTimeInMillis());
    }

    /**
     * 获取第二天的23：59：59
     * @return
     */
    public static Date getTomorrowEnd() {
        return getDateTime(1, 23, 59, 59);
    }

    /**
     * 获取第二天的0：0：0
     * @return
     */
    public static Date getTomorrowBegin() {
        return getDateTime(1, 0, 0, 0);
    }

    /**
     *  获取给定时间的0点
     */
    public static Date getZeroDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 获取给定时间的24点
     * @param date
     * @return
     */
    public static Date getTwelDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return new Date(c.getTimeInMillis());
    }

    /**
     * 获取给定年份的第一天
     * @param year
     * @return
     */
    public static Date getYearStart(int year){
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR,year);
        ca.set(Calendar.MONTH,0);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMinimum(Calendar.DAY_OF_MONTH));
        // 将小时至0
        ca.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        ca.set(Calendar.MINUTE, 0);
        // 将秒至0
        ca.set(Calendar.SECOND, 0);
        // 获取本月最一天的时后间戳
        return new Date(ca.getTimeInMillis());
    }

    /**
     * 获取给定年份的最后一天
     * @param year
     * @return
     */
    public static Date getYearEnd(int year){
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR,year);
        ca.set(Calendar.MONTH,11);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 将小时至23
        ca.set(Calendar.HOUR_OF_DAY, 23);
        // 将分钟至59
        ca.set(Calendar.MINUTE, 59);
        // 将秒至59
        ca.set(Calendar.SECOND, 59);
        // 获取本月最一天的时后间戳
        return new Date(ca.getTimeInMillis());
    }

    /**
     * 获取某年第一天
     *
     * @param year 年份
     * @return
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天
     *
     * @param year 年份
     * @return
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }

    /**
     * 获取当年的第一天
     * @return
     */
    public static Date getCurrYaerFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     * @return
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取上个月的时间
     * @return
     */
    public static  String getLastMonth(){
        LocalDate today = LocalDate.now();
        today = today.minusMonths(1);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyyMM");
        return formatters.format(today);
    }

    /**
     *获取当前时间和目标时间的间隔月份
     * @param targetDate    目标时间
     * @return
     */
    public static int getMonthNum(Date targetDate){
        //1.判断是否是今年,是以前年份的话,就返回当前月份
        Date currYaerFirst = getCurrYaerFirst();
        if (targetDate.before(currYaerFirst)){
            return Calendar.getInstance().get(Calendar.MONTH) + 1;
        }
        //2.判断从给定日期到当前日期相差的月份数
        //获取当前时间
        Date now = new Date();
        //注册时间
        Calendar bef = Calendar.getInstance();
        bef.setTime(targetDate);
        //当前时间
        Calendar aft = Calendar.getInstance();
        aft.setTime(now);
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        return Math.abs(month + result) + 1;
    }

    public static int getYearNum(Date targetDate){
        //1.判断是否是今年,是以前年份的话,就返回当前月份

        //2.判断从给定日期到当前日期相差的月份数
        //获取当前时间
        Date now = new Date();
        //注册时间
        Calendar bef = Calendar.getInstance();
        bef.setTime(targetDate);
        //当前时间
        Calendar aft = Calendar.getInstance();
        aft.setTime(now);
        //int result = aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        return Math.abs(month);
    }

    /**
     *
     * @param target
     * @return  0:在目标之前 ;1:在目标日期之后
     */
    public static int uploadIsBeforeChangePath(Date target){
        Date changePath=DateUtils.fromatNormalString("2019-04-16");
        if (changePath!=null){
            boolean before = target.before(changePath);
            if (before){
                //是否在目标日期之前
                return 0;
            }else{
                return 1;
            }
        }
        return 2;
    }

    /**
     * 获取给定开始时间
     * @param month 给定月份:当前月份-1
     * @return
     */
    public static Date getTargetDateBegin(int month) {
        // 获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MONTH,Calendar.DAY_OF_MONTH-1+month);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMinimum(Calendar.DAY_OF_MONTH));
        // 将小时至0
        ca.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        ca.set(Calendar.MINUTE, 0);
        // 将秒至0
        ca.set(Calendar.SECOND, 0);
        // 获取本月最后一天的时间戳
        return new Date(ca.getTimeInMillis());
    }

    /**
     * 获取给定结束时间
     * @param month
     * @return
     */
    public static Date getTargetDateEnd(int month) {
        // 获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MONTH,Calendar.DAY_OF_MONTH-1+month);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 将小时至0
        ca.set(Calendar.HOUR_OF_DAY, 23);
        // 将分钟至0
        ca.set(Calendar.MINUTE, 59);
        // 将秒至0
        ca.set(Calendar.SECOND, 59);
        // 获取本月最后一天的时间戳
        return new Date(ca.getTimeInMillis());
    }

    /**
     * 获取给定结束时间
     * @param num 距离天数
     * @return
     */
    public static Date getbeforeDaysStart(int num) {
        return getTargetDate(new Date(), num, 0, 0, 0);
    }
    public static Date getAfterDaysEnd(int num) {
        // 获取本月最后一天的时间戳
        return getTargetDate(new Date(), num, 23, 59, 59);
    }

    public static  Date getXbMonthEnd(int num){
        Date lastDay = getLastDay();
        return getTargetDate(lastDay, num, 23, 59, 59);
    }

    public static  Date getTargetXbMonthEnd(Date date,int num){
        return getTargetDate(date, num, 23, 59, 59);
    }

    public static Date getTargetDate(Date date,int num,int hour,int min,int second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) +num);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }


    /**
     * 判断该日期是否是该月的第一天
     *
     * @param date
     *            需要判断的日期
     * @return
     */
    public static boolean isfirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar
                .getActualMinimum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取近几个月的日期
     * @param num
     * @return
     */
    public static List<Date> getNearMonth(int num){
        List<Date> list=Lists.newArrayList();
        //循环获取
        for (int i = 1; i < num; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-i);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            Date downloadTime = calendar.getTime();
            System.out.println(formatDateTime(downloadTime));
            list.add(downloadTime);
        }
        return list;
    }

    /**
     * 获取给定月份的最后一天
     * @param month
     * @return
     */
    public static Date getMonthLastDay(int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY,calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE,calendar.getActualMaximum(Calendar.MINUTE));
        Date downloadTime = calendar.getTime();
        System.out.println(formatDateTime(downloadTime));
        return downloadTime;
    }

    public static boolean isSameMonth(int month) {
        int currentMonth = Calendar.DAY_OF_MONTH + 1;
        if (month==currentMonth){
            return true;
        }
        return false;
    }

    /**
     * 获取年份
     * @param num   间隔年份
     * @return
     */
    public static int beforeYear(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, num);
        return calendar.get(Calendar.YEAR);
    }

    public static Date getDays(Date date,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) +num);
        return calendar.getTime();
    }

    public static Date getDaysEnd(Date date,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) +num);
        // 将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        // 将分钟至0
        calendar.set(Calendar.MINUTE, 59);
        // 将秒至0
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date getLastDays(Date date,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) +num);
        // 将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        // 将分钟至0
        calendar.set(Calendar.MINUTE, 59);
        // 将秒至0
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static void main(String[] args) {
//        Date date = DateUtils.StrToDate("2019-06-23");
//        Date zero = DateUtils.getZero();
//        System.out.println(date.getTime());
//        System.out.println(zero.getTime());
//
//        System.out.println(date.after(zero));
//        System.out.println(date.before(zero));
//
//        System.out.println(DateUtils.formatDate(getDays(date, 365)));

        System.out.println(formatDateTime(getDaysEnd(new Date(), (30 * 11) * (-1))));
    }

}
