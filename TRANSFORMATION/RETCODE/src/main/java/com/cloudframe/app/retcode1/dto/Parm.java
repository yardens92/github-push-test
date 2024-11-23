package com.cloudframe.app.retcode1.dto;

/**
*  The class Parm is used to handle fields declared in it
*  @author CloudFrame Inc.
*  created on 2024-11-23 at 12:29. using version 5.0.0.158
**/


import com.cloudframe.app.retcode1.dto.serialize.*;
import com.cloudframe.app.exception.CFException;


public class Parm extends ParmSerialized { 
   

								private short parmLen;

								private long parmCode;
	
	/**
	* Constructor for Parm
	**/
    public Parm() {
		super();
		/*  set the parent of each child as this which are a group variable */
	   	/*  end of offset */
    }


 

	/**
	 *	Returns the value of parmLen
	 *	@return parmLen
	 */
	public short getParmLen() throws CFException {
        if (isParmLenModified()) { 
           parmLen = refreshParmLen();
        }
   		return parmLen;
	}
	
	/**
	 * 	Update ParmLen with the passed value
	 *  Corresponding COBOL Variable is LK-PARM-LEN
	 *	@param number
	 */
	public void setParmLen(short number) {
	     // Truncate if the number is beyond +/- Max range
	    parmLen = checkParmLenMaxLimit(number); 
		serializeParmLen(parmLen);
	}

	public void setParmLen(int number) {
	    number = checkParmLenMaxLimit((short)number); // Truncate if value is beyond +/- Max range
		setParmLen((short)number);
	}
	public void setParmLen(long number) {
	    number = checkParmLenMaxLimit((short)number); // Truncate if value is beyond +/- Max range
		setParmLen((short)number);
	}
	

	/**
	 *	Returns the value of parmCode
	 *	@return parmCode
	 */
	public long getParmCode() throws CFException {
       if (isParmCodeModified()) { 
           parmCode = refreshParmCode();
        }
   		return parmCode;
	}
	

	
	   
	/**
	 * 	Update ParmCode with the passed value
	 *  Corresponding COBOL Variable is LK-PARM-CODE
	 *	@param number
	 */
	public void setParmCode(long number) {
	     // Truncate if the number is beyond +/- Max range	
	    parmCode = checkParmCodeMaxLimit(number); 
		serializeParmCode(parmCode);
	}
	

	/**
	 * 	Update ParmCode with the passed value
	 *	@param value (String or char[])
	 */
	public void setParmCode(char[] value) throws CFException {
		 parmCode = serializeParmCode(value);
	}
	/**
	 * 	Update ParmCode with the passed value 
	 *
	 *	@param value (String or char[])
	 */
	public void setParmCodeString(char[] value) throws CFException {
		 setParmCode(value);
	}

	
	
	

		public static int getParmFieldLength() {
			return PARM_LENGTH;
		}

}
  
