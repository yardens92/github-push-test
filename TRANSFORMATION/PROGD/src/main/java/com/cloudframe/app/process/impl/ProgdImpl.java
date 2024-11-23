  package com.cloudframe.app.process.impl;
  /* Java code generated by CloudFrame on 2024-11-23 at 12:29. */
  
  import com.cloudframe.app.progd.ProgdCtx.*;
  import com.cloudframe.app.progd.ProgdCtx;
  import com.cloudframe.app.process.Progd;
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
  import com.cloudframe.app.progd.dto.*;
  import com.cloudframe.app.progd.dto.LsReturnCodeGroup;
  import com.cloudframe.app.progd.dto.Work;
  import com.cloudframe.app.common.CONSTANTS;
  import com.cloudframe.app.utility.CFUtil;
  
  @Component("progd")
  
  public class ProgdImpl extends CommonProcess implements Progd {
  
  Logger logger = LoggerFactory.getLogger(ProgdImpl.class);
  
  
  
  
  
  
  
  
  
  
      @Override
      public int setParameter(ProgdCtx programCtx, String lsReturnCodeGroup) throws Exception {
      		if(lsReturnCodeGroup != null)
      		    programCtx.getLsReturnCodeGroup().setString(com.cloudframe.app.data.Field.getParm(lsReturnCodeGroup),new String(CONSTANTS.EBCDIC_ENCODING));
      		setInitDone(false);
      		process(programCtx);
      		return programCtx.getRc();
      }
      /**
      * process 
      * Input  :  

      * - rc                             COBOL Name: RETURN-CODE
      * - lsReturnCode                   COBOL Name: LS-RETURN-CODE
      *
      * Output : None 

      * @throws CFException
      */
      public int process(ProgdCtx programCtx) throws Exception {
       try {
       setCodePage("1047");
            // Reset program ended flag
           programCtx.setProgramEnded(false);
//Added variable to get the output context in place.
ProcessInCtx methodIn = programCtx.getProcessInCtx();
//  cobolCode::DISPLAY 'INSIDE PROGRAMD WITH RETURN CODE ' RETURN-CODE
          logger.info("INSIDE PROGRAMD WITH RETURN CODE {}", String.valueOf(programCtx.getRc())); 

// *    Move 12 to ls-return-code
//  cobolCode::DISPLAY 'INSIDE PROGRAMD WITH LS-RETURN CODE ' LS-RETURN-CODE
          logger.info("INSIDE PROGRAMD WITH LS-RETURN CODE {}", String.valueOf(methodIn.getLsReturnCode())); 
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
      ProgdCtx programCtx = (ProgdCtx) ctx;
      
      int len = params.length;
         if (len > 0 && params[0] != null )
            programCtx.getLsReturnCodeGroup().set((Field)params[0]);
         // invoke the process and return rc
         return process(programCtx);
         
      }
      
      public int call(ProgramContext ctx, Field... parameters) throws Exception {
      ProgdCtx programCtx = (ProgdCtx) ctx;
         for (int index = 0; index < parameters.length;index++) {
             switch(index) {
              case 0:
                      if(parameters[index] != null ) {
              		if (parameters[index] instanceof LsReturnCodeGroup) {
                       	programCtx.setLsReturnCodeGroup((LsReturnCodeGroup) parameters[index]);
                  	} else {
                       	programCtx.getLsReturnCodeGroup().set(parameters[index]);
                  	}
                  }
                
                  break;
            }
         }
      	return process(programCtx);
      }
      
      
  
  
  
  
  
  }