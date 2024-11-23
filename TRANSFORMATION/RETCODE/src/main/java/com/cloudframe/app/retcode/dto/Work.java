package com.cloudframe.app.retcode.dto;

/**
*  The class Work is used to handle fields declared in it
*  @author CloudFrame Inc.
*  created on 2024-11-23 at 12:29. using version 5.0.0.158
**/


import com.cloudframe.app.retcode.dto.serialize.*;
import com.cloudframe.app.exception.CFException;


public class Work extends WorkSerialized { 
   

						private char[] retcode = new char[8];
	
	/**
	* Constructor for Work
	**/
    public Work() {
		super();
		/*  set the parent of each child as this which are a group variable */
	   	/*  end of offset */
								setRetcode(("RETCODE1").toCharArray());
    }


 

	/**
	 *	Returns the value of retcode
	 *	@return retcode
	 */
   public char[] getRetcode() throws CFException{
   		return retcode;
   }

  
	/**
	*  set variable retcode
	*  Corresponding COBOL Variable is WS-RETCODE
	*  @param value
	**/
   public void setRetcode(char[] value) {
       value = checkRetcodeConstraints(value);
       arraycopy(value,0,retcode,0,value.length);
   } 
	public void setRetcode(char[] value , int beginIndex, int endIndex) {
       //value = checkL1CtlData801Constraints(value);
       arraycopy(value,beginIndex,retcode,0,beginIndex + endIndex);
   }

	
	
	

		public static int getWorkFieldLength() {
			return WORK_LENGTH;
		}

}
  
