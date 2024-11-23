package com.cloudframe.app.retcode1.dto.serialize;

/**
*  The class ParmSerialized is used to define offsets in order to serialize
*  in a fixed String
*  @author CloudFrame Inc.
*  created on 2024-11-23 at 12:29. using version 5.0.0.158
**/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cloudframe.app.data.Field;
import com.cloudframe.app.exception.CFException;

public class ParmSerialized  extends Field { 

    protected Logger logger = LoggerFactory.getLogger(ParmSerialized.class);
	/*  Length of the field, if serialized as a String */
	protected static final int PARM_LENGTH = 7;
   /*  offset of each of Child Fields when serialized as a String */
            protected  int beginParmLen;
            protected  int beginParmCode;
	
	/**
	* Constructor for ParmSerialized
	**/
    public ParmSerialized() {
		   			init(0);
    }
 
	/**
	* initializes the field in ParmSerialized
	**/
	@Override
	protected void init(int begin) {
	   setStartOffset(begin);
	   setLength(PARM_LENGTH);
	   /*  set the offset/position of each field when this object is serialized as String */
             beginParmLen = getStartOffset() + 0;	// set offset for serialization
  
             beginParmCode = getStartOffset() + 2;	// set offset for serialization
  
	   /*  end of offset */
	}
         int localParmLenCounter = -1;
         public boolean isParmLenModified() {
            int sharedCounter = shareString.getSerializedField().getModifiedCounter(); 
            boolean hasModified = localParmLenCounter != sharedCounter;
            localParmLenCounter = sharedCounter; return hasModified; 
         }
   protected static final int PARM_LEN_LEN = 2;
  	/**
	 * serializeParmLen
	 */
	protected void serializeParmLen(short parmLen) {
           replaceValue( //  save the value as string
                   getBinaryString( parmLen,PARM_LEN_LEN)
                  ,beginParmLen
                  ,PARM_LEN_LEN
                 );
            localParmLenCounter = shareString.getSerializedField().getModifiedCounter();
                 
   }
       
      
   protected short checkParmLenMaxLimit(long number) {
	   return (short)checkMaxLimit(number, true/*isSigned*/,2/*dataLen*/);
   }
     /**
	 *	refreshParmLen is used to refresh the latest value of a variable from the Serialized String
	 *  the most common reason to serialize an Object as a string in to write to a file. There can be several other reasons for serialization as well
	 */ 
   	public short refreshParmLen() {	 
			return (getShort(beginParmLen));
   	}
     int localParmCodeCounter = -1;
     public boolean isParmCodeModified() {
         int sharedCounter = shareString.getSerializedField().getModifiedCounter(); 
         boolean hasModified = localParmCodeCounter != sharedCounter;
         localParmCodeCounter = sharedCounter; return hasModified; 
     }     

	/**
	 *	Returns String value of parmCode
	 *	@return parmCode
	 */
	public char[]  getParmCodeString() {
	     return getCharArray(beginParmCode,PARM_CODE_LEN);
	}
	
	 /**
	 *  This method allows testing if there is a numeric value stored in the serialized String
	 *	@return true if numeric value is stored in the string
	 */
	public boolean parmCodeIsNumeric() {
	    return isNumeric(beginParmCode
	                    ,beginParmCode + PARM_CODE_LEN
	                    ,false/*Signed*/,true/*isSign trailing*/,false/*isSignStoredSeparately*/);
	}

  
   protected  static final int PARM_CODE_LEN = 5;
  	/**
	 * serializeParmCode
	 */
	protected void serializeParmCode(long parmCode) {
		 putNumber(beginParmCode,parmCode,PARM_CODE_LEN,false/*isSigned?*/,true/*signTrailing?*/,false/*storeSignSeparate?*/); 
		 localParmCodeCounter = shareString.getSerializedField().getModifiedCounter();

    }
    /**
	 * serializeParmCode
	 */
   	protected  long serializeParmCode(char[] value) {
	    long  parmCode;
	    if(value.length >0 && value.length!= 5)
            value = new String(value).trim().toCharArray();
	    if (value.length < 5) value = pad(5, value, ' ', LEFT_PAD);
	    else if (value.length > 5) value = substring(value,0,5);
	    /*  String can consists of digit or a non digit characters, in case of non digit characters, mimic COBOL Behavior and take only the last 4 bits per char and convert that to a number */
	    parmCode = convertString2Number(value,false/*isSigned?*/,true/*signTrailing?*/,false/*storeSignSeparate?*/);
		replaceValue(
		       padNumber(5,value,false/*isSigned?*/)
		       ,beginParmCode
		       ,5
		      );
		 localParmCodeCounter = shareString.getSerializedField().getModifiedCounter();
		return  parmCode;
    }

   protected long checkParmCodeMaxLimit(long number) {

        return checkMaxLimit(number , MAX_100K/*limit*/  , false/*isSigned*/);
   }
    /**
	 *	refreshParmCode is used to refresh the latest value of a variable from the Serialized String
	 *  the most common reason to serialize an Object as a string in to write to a file. There can be several other reasons for serialization as well
	 */ 
   	public long refreshParmCode() throws CFException {
   	try {	 
			return (
			          getLongNumber(
			                  beginParmCode
			                 ,PARM_CODE_LEN
			                 ,false/*isSigned*/,true/*isSignTrailing*/,false/*isSignStoredSeparate*/)              			                 
			          ); 
	} catch(Exception ex) {
    	throw getSoc7ABend("parmCode", beginParmCode,PARM_CODE_LEN);
    }
   	}




}
  
