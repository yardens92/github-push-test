package com.cloudframe.app.process;

import com.cloudframe.app.data.Field;
import com.cloudframe.app.dto.ProgramContext;

public interface Retcode1 {
     /**
	 * This is the entry point into the program.
	 *
	 * @return return code of the program
	 */
     public int process(ProgramContext programCtx) throws Exception;

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
