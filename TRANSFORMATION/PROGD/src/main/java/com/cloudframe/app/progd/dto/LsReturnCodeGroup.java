package com.cloudframe.app.progd.dto;

/**
*  The class LsReturnCodeGroup is used to handle fields declared in it
*  @author CloudFrame Inc.
*  created on 2024-11-23 at 12:29. using version 5.0.0.158
**/


import com.cloudframe.app.progd.dto.serialize.*;
import com.cloudframe.app.exception.CFException;


public class LsReturnCodeGroup extends LsReturnCodeGroupSerialized { 
   

								private int lsReturnCode;
	
	/**
	* Constructor for LsReturnCodeGroup
	**/
    public LsReturnCodeGroup() {
		super();
		/*  set the parent of each child as this which are a group variable */
	   	/*  end of offset */
    }


 

	/**
	 *	Returns the value of lsReturnCode
	 *	@return lsReturnCode
	 */
	public int getLsReturnCode() throws CFException {
       if (isLsReturnCodeModified()) { 
           lsReturnCode = refreshLsReturnCode();
        }
   		return lsReturnCode;
	}
	

	
	   
	/**
	 * 	Update LsReturnCode with the passed value
	 *  Corresponding COBOL Variable is LS-RETURN-CODE
	 *	@param number
	 */
	public void setLsReturnCode(int number) {
	     // Truncate if the number is beyond +/- Max range	
	    lsReturnCode = checkLsReturnCodeMaxLimit(number); 
		serializeLsReturnCode(lsReturnCode);
	}
	

	public void setLsReturnCode(long number) {
	    number = checkLsReturnCodeMaxLimit(number); // Truncate if value is beyond +/- Max range
		setLsReturnCode((int)number);
	}
	
	/**
	 * 	Update LsReturnCode with the passed value
	 *	@param value (String or char[])
	 */
	public void setLsReturnCode(char[] value) throws CFException {
		 lsReturnCode = serializeLsReturnCode(value);
	}
	/**
	 * 	Update LsReturnCode with the passed value 
	 *
	 *	@param value (String or char[])
	 */
	public void setLsReturnCodeString(char[] value) throws CFException {
		 setLsReturnCode(value);
	}

	
	
	

		public static int getLsReturnCodeGroupFieldLength() {
			return LS_RETURN_CODE_GROUP_LENGTH;
		}

}
  
