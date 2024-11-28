package com.cloudframe.app.dto.retcode1;

import com.cloudframe.app.dto.GlobalExecutorCtx;
import com.cloudframe.app.dto.ProgramContext;
import com.cloudframe.app.dto.Context;
import com.cloudframe.app.data.Field;
import java.math.BigDecimal;
import java.util.List;
import com.cloudframe.app.exception.CFException;

 
 


@Context
public class Retcode1Ctx implements ProgramContext, Cloneable {
    GlobalExecutorCtx globalCtx;

    Parm parm;
    Work work;


    private int rc;

    public GlobalExecutorCtx getGlobalCtx() {
            return globalCtx;
    }

    public void setGlobalCtx(GlobalExecutorCtx globalCtx) {
        this.globalCtx = globalCtx;
    }

    public int getRc() {
        return this.rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }



    boolean programEnded = false;

    public boolean isProgramEnded() {
        return this.programEnded;
    }

    public void setProgramEnded(boolean programEnded) {
        this.programEnded = programEnded;
    }


    public Parm getParm() {
        if (parm == null) {
            parm = new Parm();
        }

        return parm;
    }

    public void setParm(Parm parm) {
        this.parm = parm;
    }
    public Work getWork() {
        if (work == null) {
            work = new Work();
        }

        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        String str = "";
        str += parm.hashCode();
        str += work.hashCode();
       return str.hashCode();
    }

    public Retcode1Ctx clone() {
        Retcode1Ctx cloneObj = new Retcode1Ctx();
        cloneObj.parm = new Parm();
        cloneObj.parm.set(parm.getClonedField());
        cloneObj.work = new Work();
        cloneObj.work.set(work.getClonedField());
        return cloneObj;
    }

/**
 * Program method contexts
 *
 */
     public class ProcessInCtx implements Cloneable {
     Parm parm = Retcode1Ctx.this.getParm();

	/**
	 *	Returns the value of parmCode
	 *	@return parmCode
	 */
	public long getParmCode() throws CFException {
   		return parm.getParmCode();
	}


	/**
	 *	Returns String value of parmCode
	 *	@return parmCode
	 */
	public char[]  getParmCodeString() throws CFException {
	     return String.valueOf(parm.getParmCodeString()).toCharArray();
	}

	 /**
	 *  This method allows testing if there is a numeric value stored in the serialized String
	 *	@return true if numeric value is stored in the string
	 */
	public boolean parmCodeIsNumeric()  throws CFException{
	    return parm.parmCodeIsNumeric();
	}

	/**
	 * 	Update ParmCode with the passed value
	 *	@param number
	 */
	public void setParmCode(long number)  throws CFException{
		parm.setParmCode(number);
	}
	

	
	/**
	 * 	Update ParmCode with the passed value
	 *	@param value (String or char[])
	 */
	public void setParmCode(char[] value)  throws CFException {
		parm.setParmCode(value);
	}
	
	/**
	 * 	Update ParmCode with the passed value 
	 *
	 *	@param value (String or char[])
	 */
	public void setParmCodeString(char[] value)  throws CFException{
		parm.setParmCode(value);
	}	


        public Retcode1Ctx getRetcode1Ctx() {
            return Retcode1Ctx.this;
        }

        public ProcessOutCtx getProcessOutCtx() {
            return new ProcessOutCtx();
        }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        String str = "";
        str += parm.hashCode();
       return str.hashCode();
    }

    public ProcessInCtx clone() {
        ProcessInCtx cloneObj = new ProcessInCtx();
        cloneObj.parm = new Parm();
        cloneObj.parm.set(parm.getClonedField());
        return cloneObj;
    }

    }

    public ProcessInCtx getProcessInCtx() {
            return new ProcessInCtx();
    }
     public class ProcessOutCtx implements Cloneable {
     Parm parm = Retcode1Ctx.this.getParm();

	/**
	 *	Returns the value of parmCode
	 *	@return parmCode
	 */
	public long getParmCode() throws CFException {
   		return parm.getParmCode();
	}


	/**
	 *	Returns String value of parmCode
	 *	@return parmCode
	 */
	public char[]  getParmCodeString() throws CFException {
	     return String.valueOf(parm.getParmCodeString()).toCharArray();
	}

	 /**
	 *  This method allows testing if there is a numeric value stored in the serialized String
	 *	@return true if numeric value is stored in the string
	 */
	public boolean parmCodeIsNumeric()  throws CFException{
	    return parm.parmCodeIsNumeric();
	}

	/**
	 * 	Update ParmCode with the passed value
	 *	@param number
	 */
	public void setParmCode(long number)  throws CFException{
		parm.setParmCode(number);
	}
	

	
	/**
	 * 	Update ParmCode with the passed value
	 *	@param value (String or char[])
	 */
	public void setParmCode(char[] value)  throws CFException {
		parm.setParmCode(value);
	}
	
	/**
	 * 	Update ParmCode with the passed value 
	 *
	 *	@param value (String or char[])
	 */
	public void setParmCodeString(char[] value)  throws CFException{
		parm.setParmCode(value);
	}	


        public Retcode1Ctx getRetcode1Ctx() {
            return Retcode1Ctx.this;
        }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        String str = "";
        str += parm.hashCode();
       return str.hashCode();
    }

    public ProcessOutCtx clone() {
        ProcessOutCtx cloneObj = new ProcessOutCtx();
        cloneObj.parm = new Parm();
        cloneObj.parm.set(parm.getClonedField());
        return cloneObj;
    }

    }

    public ProcessOutCtx getProcessOutCtx() {
            return new ProcessOutCtx();
    }
}
