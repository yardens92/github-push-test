package com.cloudframe.app.dto.retcode1;

/**
*  The class Work is used to handle fields declared in it
*  @author CloudFrame Inc.
*  created on 2024-11-28 at 20:37. using version 5.0.0.160
**/


import com.cloudframe.app.dto.serialize.retcode1.*;
import com.cloudframe.app.exception.CFException;


public class Work extends WorkSerialized { 
   
	
	/**
	* Constructor for Work
	**/
    public Work() {
		super();
		/*  set the parent of each child as this which are a group variable */
	   	/*  end of offset */
    }


 


	
	
	

		public static int getWorkFieldLength() {
			return WORK_LENGTH;
		}

}
  
