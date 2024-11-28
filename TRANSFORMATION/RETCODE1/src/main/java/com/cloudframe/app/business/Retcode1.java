package com.cloudframe.app.business;

import com.cloudframe.app.dto.retcode1.Retcode1Ctx;
import com.cloudframe.app.data.Field;


import com.cloudframe.app.dto.ProgramContext;

public interface Retcode1 {
    /**
     * This method is derived from Cobol Paragraph - 
     *
     * @return return code of program
     */
    public int setParameter(Retcode1Ctx programCtx, String parm) throws Exception;

    /**
     * This method is derived from Cobol Paragraph - PROCESS
     *
     * @return Return Code of the this class
     */
    public int process(Retcode1Ctx programCtx) throws Exception;


     /**
	 * This will invoke the program given parameters from the
      * caller program.
	 *
	 * @return return code of the program
	 */
     public int call(ProgramContext programCtx, Object[] parameters) throws Exception;

     /**
	 * This will invoke the program given Field parameters from
      * the caller program.
	 *
	 * @return return code of the program
	 */
     public int call(ProgramContext programCtx, Field... parameters) throws Exception;
}
