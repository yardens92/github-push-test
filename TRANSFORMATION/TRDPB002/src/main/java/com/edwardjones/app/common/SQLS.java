package com.edwardjones.app.common;
/* Java Code Generated by CloudFrame */ 
public class SQLS {
 
public static final char[] SQL_1000751994 = "SELECT SUM_CUSTOMER_ID , SUM_OVERDUE , SUM_REJECTED , SUM_SETTLED , SUM_CURRENCY , SUM_OPEN_BALANCE , SUM_TOTAL_DEBIT , SUM_TOTAL_CREDIT , SUM_CLOSE_BALANCE FROM TBTRDSUM ORDER BY SUM_CUSTOMER_ID ASC".toCharArray() ;
public static final char[] SQL_1599399814 = "SELECT LOG_TRANSACTION , LOG_CURRENCY , LOG_START_TS , LOG_END_TS FROM TBTRDLOG ORDER BY LOG_TRANSACTION ASC , LOG_CURRENCY ASC".toCharArray() ;
public static final char[] SQL_1655018439 = "DELETE FROM TBTRDEXC".toCharArray() ;
public static final char[] SQL_1655218451 = "DELETE FROM TBTRDLOG".toCharArray() ;
public static final char[] SQL_1655432103 = "DELETE FROM TBTRDSTQ".toCharArray() ;
public static final char[] SQL_1655432940 = "DELETE FROM TBTRDSUM".toCharArray() ;
public static final char[] SQL_587719915 = "SELECT EXC_TYPE , EXC_DESCRIPTION FROM TBTRDEXC ORDER BY EXC_TYPE ASC , EXC_DESCRIPTION ASC".toCharArray() ;
 
}
