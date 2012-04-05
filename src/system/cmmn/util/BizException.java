package system.cmmn.util;

public class BizException extends RuntimeException {

	private String errCode = "";
	private String errMessage = "";

	public BizException() {
		super();
	}

	public String getErrCode()
	{
		return errCode;
	}

	public void setErrCode(String errCode)
	{
		this.errCode = errCode;
	}

	public String getErrMessage()
	{
		return errMessage;
	}

	public void setErrMessage(String errMessage)
	{
		this.errMessage = errMessage;
	}
}
