package com.cloudframe.app.progd.dto.serialize;

/**
*  The class LsReturnCodeGroupSerialized is used to define offsets in order to serialize
*  in a fixed String
*  @author CloudFrame Inc.
*  created on 2024-11-23 at 12:29. using version 5.0.0.158
**/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cloudframe.app.data.Field;
import com.cloudframe.app.exception.CFException;

public class LsReturnCodeGroupSerialized  extends Field { 

    protected Logger logger = LoggerFactory.getLogger(LsReturnCodeGroupSerialized.class);
	/*  Length of the field, if serialized as a String */
	protected static final int LS_RETURN_CODE_GROUP_LENGTH = 4;
   /*  offset of each of Child Fields when serialized as a String */
            protected  int beginLsReturnCode;
	
	/**
	* Constructor for LsReturnCodeGroupSerialized
	**/
    public LsReturnCodeGroupSerialized() {
		   			init(0);
    }
 
	/**
	* initializes the field in LsReturnCodeGroupSerialized
	**/
	@Override
	protected void init(int begin) {
	   setStartOffset(begin);
	   setLength(LS_RETURN_CODE_GROUP_LENGTH);
	   /*  set the offset/position of each field when this object is serialized as String */
             beginLsReturnCode = getStartOffset() + 0;	// set offset for serialization
  
	   /*  end of offset */
	}
     int localLsReturnCodeCounter = -1;
     public boolean isLsReturnCodeModified() {
         int sharedCounter = shareString.getSerializedField().getModifiedCounter(); 
         boolean hasModified = localLsReturnCodeCounter != sharedCounter;
         localLsReturnCodeCounter = sharedCounter; return hasModified; 
     }     

	/**
	 *	Returns String value of lsReturnCode
	 *	@return lsReturnCode
	 */
	public char[]  getLsReturnCodeString() {
	     return getCharArray(beginLsReturnCode,LS_RETURN_CODE_LEN);
	}
	
	 /**
	 *  This method allows testing if there is a numeric value stored in the serialized String
	 *	@return true if numeric value is stored in the string
	 */
	public boolean lsReturnCodeIsNumeric() {
	    return isNumeric(beginLsReturnCode
	                    ,beginLsReturnCode + LS_RETURN_CODE_LEN
	                    ,false/*Signed*/,true/*isSign trailing*/,false/*isSignStoredSeparately*/);
	}

  
   protected  static final int LS_RETURN_CODE_LEN = 4;
  	/**
	 * serializeLsReturnCode
	 */
	protected void serializeLsReturnCode(int lsReturnCode) {
		 putNumber(beginLsReturnCode,lsReturnCode,LS_RETURN_CODE_LEN,false/*isSigned?*/,true/*signTrailing?*/,false/*storeSignSeparate?*/); 
		 localLsReturnCodeCounter = shareString.getSerializedField().getModifiedCounter();

    }
    /**
	 * serializeLsReturnCode
	 */
   	protected  int serializeLsReturnCode(char[] value) {
	    int  lsReturnCode;
	    if(value.length >0 && value.length!= 4)
            value = new String(value).trim().toCharArray();
	    if (value.length < 4) value = pad(4, value, ' ', LEFT_PAD);
	    else if (value.length > 4) value = substring(value,0,4);
	    /*  String can consists of digit or a non digit characters, in case of non digit characters, mimic COBOL Behavior and take only the last 4 bits per char and convert that to a number */
	    lsReturnCode = (int) convertString2Number(value,false/*isSigned?*/,true/*signTrailing?*/,false/*storeSignSeparate?*/);
		replaceValue(
		       padNumber(4,value,false/*isSigned?*/)
		       ,beginLsReturnCode
		       ,4
		      );
		 localLsReturnCodeCounter = shareString.getSerializedField().getModifiedCounter();
		return  lsReturnCode;
    }

   protected int checkLsReturnCodeMaxLimit(long number) {

	   return (int)checkMaxLimit(number , MAX_10K/*limit*/  , false/*isSigned*/);
   }
    /**
	 *	refreshLsReturnCode is used to refresh the latest value of a variable from the Serialized String
	 *  the most common reason to serialize an Object as a string in to write to a file. There can be several other reasons for serialization as well
	 */ 
   	public int refreshLsReturnCode() throws CFException {
   	try {	 
			return (
			          getIntNumber(
			                  beginLsReturnCode
			                 ,LS_RETURN_CODE_LEN
			                 ,false/*isSigned*/,true/*isSignTrailing*/,false/*isSignStoredSeparate*/)              			                 
			          ); 
	} catch(Exception ex) {
    	throw getSoc7ABend("lsReturnCode", beginLsReturnCode,LS_RETURN_CODE_LEN);
    }
   	}




}
  
