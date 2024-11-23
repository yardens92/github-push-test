package com.cloudframe.app.progd;

import com.cloudframe.app.dto.GlobalExecutorCtx;
import com.cloudframe.app.dto.ProgramContext;
import com.cloudframe.app.dto.Context;
import com.cloudframe.app.data.Field;
import java.math.BigDecimal;
import java.util.List;
import com.cloudframe.app.exception.CFException;

import com.cloudframe.app.progd.dto.LsReturnCodeGroup;
import com.cloudframe.app.progd.dto.Work;


@Context
public class ProgdCtx implements ProgramContext, Cloneable {
    GlobalExecutorCtx globalCtx;

    Work work;
    LsReturnCodeGroup lsReturnCodeGroup;


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


    public Work getWork() {
        if (work == null) {
            work = new Work();
        }

        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
    public LsReturnCodeGroup getLsReturnCodeGroup() {
        if (lsReturnCodeGroup == null) {
            lsReturnCodeGroup = new LsReturnCodeGroup();
        }

        return lsReturnCodeGroup;
    }

    public void setLsReturnCodeGroup(LsReturnCodeGroup lsReturnCodeGroup) {
        this.lsReturnCodeGroup = lsReturnCodeGroup;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        String str = "";
        str += work.hashCode();
        str += lsReturnCodeGroup.hashCode();
       return str.hashCode();
    }

    public ProgdCtx clone() {
        ProgdCtx cloneObj = new ProgdCtx();
        cloneObj.work = new Work();
        cloneObj.work.set(work.getClonedField());
        cloneObj.lsReturnCodeGroup = new LsReturnCodeGroup();
        cloneObj.lsReturnCodeGroup.set(lsReturnCodeGroup.getClonedField());
        return cloneObj;
    }

/**
 * Program method contexts
 *
 */
     public class ProcessInCtx implements Cloneable {
     LsReturnCodeGroup lsReturnCodeGroup = ProgdCtx.this.getLsReturnCodeGroup();

	/**
	 *	Returns the value of lsReturnCode
	 *	@return lsReturnCode
	 */
	public int getLsReturnCode() throws CFException {
   		return lsReturnCodeGroup.getLsReturnCode();
	}


	/**
	 *	Returns String value of lsReturnCode
	 *	@return lsReturnCode
	 */
	public char[]  getLsReturnCodeString() throws CFException {
	     return String.valueOf(lsReturnCodeGroup.getLsReturnCodeString()).toCharArray();
	}

	 /**
	 *  This method allows testing if there is a numeric value stored in the serialized String
	 *	@return true if numeric value is stored in the string
	 */
	public boolean lsReturnCodeIsNumeric()  throws CFException{
	    return lsReturnCodeGroup.lsReturnCodeIsNumeric();
	}

	/**
	 * 	Update LsReturnCode with the passed value
	 *	@param number
	 */
	public void setLsReturnCode(int number)  throws CFException{
		lsReturnCodeGroup.setLsReturnCode(number);
	}
	

	public void setLsReturnCode(long number)  throws CFException{
	    lsReturnCodeGroup.setLsReturnCode(number);
	}
	
	
	/**
	 * 	Update LsReturnCode with the passed value
	 *	@param value (String or char[])
	 */
	public void setLsReturnCode(char[] value)  throws CFException {
		lsReturnCodeGroup.setLsReturnCode(value);
	}
	
	/**
	 * 	Update LsReturnCode with the passed value 
	 *
	 *	@param value (String or char[])
	 */
	public void setLsReturnCodeString(char[] value)  throws CFException{
		lsReturnCodeGroup.setLsReturnCode(value);
	}	


        public ProgdCtx getProgdCtx() {
            return ProgdCtx.this;
        }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        String str = "";
        str += lsReturnCodeGroup.hashCode();
       return str.hashCode();
    }

    public ProcessInCtx clone() {
        ProcessInCtx cloneObj = new ProcessInCtx();
        cloneObj.lsReturnCodeGroup = new LsReturnCodeGroup();
        cloneObj.lsReturnCodeGroup.set(lsReturnCodeGroup.getClonedField());
        return cloneObj;
    }

    }

    public ProcessInCtx getProcessInCtx() {
            return new ProcessInCtx();
    }
}
