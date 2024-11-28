package com.cloudframe.app.business.impl;
  /* Java code generated by CloudFrame on 2024-11-28 at 20:37. */
  
import com.cloudframe.app.common.CommonProcess;
import com.cloudframe.app.dto.retcode1.Retcode1Ctx.*;
import com.cloudframe.app.dto.retcode1.Retcode1Ctx;
import com.cloudframe.app.business.Retcode1;
  import com.cloudframe.app.process.BaseProcess;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;
  import com.cloudframe.app.exception.CFException;
  import org.springframework.stereotype.Component;
  import org.springframework.web.bind.annotation.RestController;
  import org.springframework.web.bind.annotation.RequestParam;
  import com.cloudframe.app.dto.GlobalExecutorCtx;
  import com.cloudframe.app.exception.Terminate;
  import com.cloudframe.app.dto.ProgramContext;
  import com.cloudframe.app.data.Field;
import com.cloudframe.app.dto.retcode1.*;
import com.cloudframe.app.dto.retcode1.Parm;
import com.cloudframe.app.dto.retcode1.Work;
  import com.cloudframe.app.common.CONSTANTS;
  import com.cloudframe.app.utility.CFUtil;
  
  @Component("retcode1")
  
  public class Retcode1Impl extends CommonProcess implements Retcode1 {
  
  Logger logger = LoggerFactory.getLogger(Retcode1Impl.class);
  
  
  
  
  
  
  
  
  
  
      @Override
      public int setParameter(Retcode1Ctx programCtx, String parm) throws Exception {
      		if(parm != null)
      		    programCtx.getParm().setString(com.cloudframe.app.data.Field.getParm(parm),new String(CONSTANTS.EBCDIC_ENCODING));
      		setInitDone(false);
      		process(programCtx);
      		return programCtx.getRc();
      }
      /**
      * process 
      * Input  :  

      * - parmCode                       COBOL Name: LK-PARM-CODE
      *
      * Output :  

      * - rc                             COBOL Name: RETURN-CODE
      * - parmCode                       COBOL Name: LK-PARM-CODE
      *
      * @throws CFException
      */
      public int process(Retcode1Ctx programCtx) throws Exception {
       try {
       setCodePage("1047");
            // Reset program ended flag
           programCtx.setProgramEnded(false);
//Added variable to get the output context in place.
ProcessInCtx methodIn = programCtx.getProcessInCtx();
//Added variable to get the output context in place.
ProcessOutCtx methodOut = methodIn.getProcessOutCtx();
//  cobolCode::DISPLAY ' RETURN CODE IS ' LK-PARM-CODE
          logger.info(" RETURN CODE IS {}", String.valueOf(methodOut.getParmCode())); 
//  cobolCode::MOVE LK-PARM-CODE TO RETURN-CODE
          programCtx.setRc((int) methodOut.getParmCode());
//  cobolCode::GOBACK
          setNotLogged(false); // no need to log, it is a normal termination
          programCtx.setProgramEnded(true);
          return programCtx.getRc();
       } catch(Exception e) {
            handleErrorCode(e);
            throw e;
       }
      
      // end of process method
      }
  
  
  
      public int call(ProgramContext ctx, Object[] params) throws Exception {
      Retcode1Ctx programCtx = (Retcode1Ctx) ctx;
      
      int len = params.length;
         if (len > 0 && params[0] != null )
            programCtx.getParm().set((Field)params[0]);
         // invoke the process and return rc
         return process(programCtx);
         
      }
      
      public int call(ProgramContext ctx, Field... parameters) throws Exception {
      Retcode1Ctx programCtx = (Retcode1Ctx) ctx;
         for (int index = 0; index < parameters.length;index++) {
             switch(index) {
              case 0:
                      if(parameters[index] != null ) {
              		if (parameters[index] instanceof Parm) {
                       	programCtx.setParm((Parm) parameters[index]);
                  	} else {
                       	programCtx.getParm().set(parameters[index]);
                  	}
                  }
                
                  break;
            }
         }
      	return process(programCtx);
      }
      
      
  
  
  
  
  
  }
