  package com.cloudframe.app.process.impl;
  /* Java code generated by CloudFrame on 2024-11-27 at 18:48. */
  
  import com.cloudframe.app.retcode2.Retcode2Ctx.*;
  import com.cloudframe.app.retcode2.Retcode2Ctx;
  import com.cloudframe.app.process.Retcode2;
  import com.cloudframe.app.process.BaseProcess;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;
  import com.cloudframe.app.exception.CFException;
  import org.springframework.stereotype.Component;
  import org.springframework.web.bind.annotation.RestController;
  import org.springframework.web.bind.annotation.RequestParam;
  import com.cloudframe.app.dto.GlobalExecutorCtx;
  import com.cloudframe.app.process.Retcode1;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.beans.factory.annotation.Qualifier;
  import com.cloudframe.app.process.*;
  import com.cloudframe.app.exception.Terminate;
  import com.cloudframe.app.dto.ProgramContext;
  import com.cloudframe.app.data.Field;
  import com.cloudframe.app.retcode2.dto.*;
  import com.cloudframe.app.retcode2.dto.Parm;
  import com.cloudframe.app.retcode2.dto.Work;
  import com.cloudframe.app.common.CONSTANTS;
  import com.cloudframe.app.utility.CFUtil;
  
  @Component("retcode2")
  
  public class Retcode2Impl extends CommonProcess implements Retcode2 {
  
  Logger logger = LoggerFactory.getLogger(Retcode2Impl.class);
  
  
  
  
  @Autowired 
  @Qualifier("retcode1")
  Retcode1 retcode1;
  
  
  
  
  
  
      @Override
      public int setParameter(Retcode2Ctx programCtx, String parm) throws Exception {
      		if(parm != null)
      		    programCtx.getParm().setString(com.cloudframe.app.data.Field.getParm(parm),new String(CONSTANTS.EBCDIC_ENCODING));
      		setInitDone(false);
      		process(programCtx);
      		return programCtx.getRc();
      }
      /**
      * process 
      * Input  : None 

      * Output :  

      * - rc                             COBOL Name: RETURN-CODE
      *
      * @throws CFException
      */
      public int process(Retcode2Ctx programCtx) throws Exception {
       try {
       setCodePage("1047");
            // Reset program ended flag
           programCtx.setProgramEnded(false);
//Added variable to get the output context in place.
ProcessInCtx methodIn = programCtx.getProcessInCtx();
//Added variable to get the output context in place.
ProcessOutCtx methodOut = methodIn.getProcessOutCtx();

// *
// * This program move 1 to return-code
// * but the caller program overrides it
// * so final return-code should be what the caller program passed.
// *
          
// *
// * This program move 1 to return-code
// * but the caller program overrides it
// * so final return-code should be what the caller program passed.
// *
          programCtx.setRc( 1);
//  cobolCode::CALL WS-RETCODE USING LK-PARM
               programCtx.setRc( retcode1.call(programCtx.getGlobalCtx().getContext("RETCODE1"),methodOut.getParm()));
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
      Retcode2Ctx programCtx = (Retcode2Ctx) ctx;
      
      int len = params.length;
         if (len > 0 && params[0] != null )
            programCtx.getParm().set((Field)params[0]);
         // invoke the process and return rc
         return process(programCtx);
         
      }
      
      public int call(ProgramContext ctx, Field... parameters) throws Exception {
      Retcode2Ctx programCtx = (Retcode2Ctx) ctx;
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
      
      
      public void setFromRetcode1(Retcode2Ctx programCtx, Object[] params) {
      int len = params.length;
         if (len > 0)
         if(params[0] instanceof Field) 
   programCtx.getParm().setString(((Field)params[0] ).toCharArray());
 else    programCtx.getParm().setString((char[])params[0] );
      }
  
  
  
  
  
  }
